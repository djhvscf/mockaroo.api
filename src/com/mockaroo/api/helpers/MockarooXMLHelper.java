package com.mockaroo.api.helpers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import jxl.write.WriteException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.mockaroo.api.interfaces.IMockarooXMLHelper;

/**
 * Class that create a XML file
 * @author Dennis Hernández Vargas
 * @version 0.1.1
 * @since 18/July/2014
 */
public class MockarooXMLHelper implements IMockarooXMLHelper {

	private static MockarooXMLHelper instance = null;
	private DocumentBuilder docBuilder;
	private DocumentBuilderFactory docFactory;
	private Document document;
	private Element rootElement;
	private Element object;
	
	private MockarooXMLHelper() throws ParserConfigurationException
	{
		this.setDocFactory(DocumentBuilderFactory.newInstance());
		this.setDocBuilder(this.getDocFactory().newDocumentBuilder());
		this.setDocument(this.getDocBuilder().newDocument());
	}
	
	public static MockarooXMLHelper getInstance() throws ParserConfigurationException
	{
		if(instance == null)
		{
			instance = new MockarooXMLHelper();
		}
		
		return instance;
	}

	private DocumentBuilder getDocBuilder() {
		return docBuilder;
	}

	private void setDocBuilder(DocumentBuilder docBuilder) {
		this.docBuilder = docBuilder;
	}

	private DocumentBuilderFactory getDocFactory() {
		return docFactory;
	}

	private void setDocFactory(DocumentBuilderFactory docFactory) {
		this.docFactory = docFactory;
	}

	private Document getDocument() {
		return document;
	}

	private void setDocument(Document document) {
		this.document = document;
	}
	
	private Element getRootElement() {
		return rootElement;
	}

	private void setRootElement(Element rootElement) {
		this.rootElement = rootElement;
	}

	private Element getObject() {
		return object;
	}

	private void setObject(Element object) {
		this.object = object;
	}

	private void createRootElement(String rootTagName)
	{
		this.setRootElement(this.getDocument().createElement(rootTagName));
		this.getDocument().appendChild(rootElement);
	}
	
	private void createChildElement(String objectName)
	{
		this.setObject(this.getDocument().createElement(objectName));
		this.getRootElement().appendChild(this.getObject());
	}
	
	@SuppressWarnings("unused")
	private void createAttributes(String attributeName, String attributeValue)
	{
		Attr attr = this.getDocument().createAttribute(attributeName);
		attr.setValue(attributeValue);
		this.getObject().setAttributeNode(attr);
	}
	
	private void createObjectTag(String tagName, String tagValue)
	{
		Element element = this.getDocument().createElement(tagName);
		element.appendChild(this.getDocument().createTextNode(tagValue));
		this.getObject().appendChild(element);
	}

	@Override
	public void write(String fileName, String rootTagName, String objectName, JSONObject jsonObject)
			throws IOException, WriteException, TransformerException {
		
		this.createRootElement(rootTagName);
		this.createChildElement(objectName);
		this.setObjectTag(jsonObject);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(this.getDocument());
		StreamResult result = new StreamResult(new File(fileName));
		
		transformer.transform(source, result);
	}
	
	/**
	 * Generate the object tags name
	 * @param jsonObject {@link JSONObject}
	 * @return String with the tags name
	 */
	public String[] getObjectTag(JSONObject jsonObject)
	{
		JSONArray name = jsonObject.names();
		String[] tagsName = new String[name.length()];
		
		for(int i = 0; i < name.length(); i++)
		{
			tagsName[i] = name.getString(i);
		}
		
		return tagsName;
	}
	
	/**
	 * Generate the object values
	 * @param jsonObject
	 * @return String with the object values
	 */
	public String[] generateObjectValue(JSONObject jsonObject)
	{
		JSONArray name = jsonObject.names();
		String objectValues[] = new String[name.length()];
		
		for(int i = 0; i < name.length(); i++)
		{
			objectValues[i] = jsonObject.getString(name.getString(i));
		}
		
		return objectValues;
	}
	
	private void setObjectTag(JSONObject jsonObject)
	{
		String[] tagsName = this.getObjectTag(jsonObject);
		String[] objectValues = this.generateObjectValue(jsonObject);
		
		for(int i = 0; i < tagsName.length; i++)
		{
			this.createObjectTag(tagsName[i], objectValues[i]);
		}
	}
}