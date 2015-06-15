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
 * @version 1.0.0 - 18/July/2014
 * @since 1.0.0
 */
public class MockarooXMLHelper implements IMockarooXMLHelper {

	private static MockarooXMLHelper instance = null;
	private DocumentBuilder docBuilder;
	private DocumentBuilderFactory docFactory;
	private Document document;
	private Element rootElement;
	private Element object;
	
	/**
	 * Constructor
	 * Applying singleton
	 * @throws ParserConfigurationException
	 */
	private MockarooXMLHelper() throws ParserConfigurationException
	{
		this.setDocFactory(DocumentBuilderFactory.newInstance());
		this.setDocBuilder(this.getDocFactory().newDocumentBuilder());
		this.setDocument(this.getDocBuilder().newDocument());
	}
	
	/**
	 * Return a {@link MockarooXMLHelper} object
	 * @return {@link MockarooXMLHelper}
	 * @throws ParserConfigurationException
	 */
	public static MockarooXMLHelper getInstance() throws ParserConfigurationException
	{
		if(instance == null)
		{
			instance = new MockarooXMLHelper();
		}
		
		return instance;
	}

	/**
	 * Get the document builder
	 * @return {@link DocumentBuilder}
	 */
	private DocumentBuilder getDocBuilder() {
		return docBuilder;
	}

	/**
	 * Set the document builder
	 * @param docBuilder {@link DocumentBuilder}
	 */
	private void setDocBuilder(DocumentBuilder docBuilder) {
		this.docBuilder = docBuilder;
	}

	/**
	 * Get the document builder factory
	 * @return {@link DocumentBuilderFactory} 
	 */
	private DocumentBuilderFactory getDocFactory() {
		return docFactory;
	}

	/**
	 * Set the document builder factory
	 * @param docFactory {@link DocumentBuilderFactory}
	 */
	private void setDocFactory(DocumentBuilderFactory docFactory) {
		this.docFactory = docFactory;
	}

	/**
	 * Get the {@link Document} object
	 * @return {@link Document}
	 */
	private Document getDocument() {
		return document;
	}

	/**
	 * Set the document
	 * @param document {@link Document}
	 */
	private void setDocument(Document document) {
		this.document = document;
	}
	
	/**
	 * Get the root {@link Element}
	 * @return {@link Element}
	 */
	private Element getRootElement() {
		return rootElement;
	}

	/**
	 * Set the root element
	 * @param rootElement {@link Element}
	 */
	private void setRootElement(Element rootElement) {
		this.rootElement = rootElement;
	}

	/**
	 * Get the object {@link Element}
	 * @return {@link Element}
	 */
	private Element getObject() {
		return object;
	}

	/**
	 * Set the object element
	 * @param object {@link Element}
	 */
	private void setObject(Element object) {
		this.object = object;
	}

	/**
	 * Set the name of the root element tag
	 * @param rootTagName String with the tag name
	 */
	private void createRootElement(String rootTagName)
	{
		this.setRootElement(this.getDocument().createElement(rootTagName));
		this.getDocument().appendChild(rootElement);
	}
	
	/**
	 * Set the child element name
	 * @param objectName String with the child element name
	 */
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
	
	/**
	 * Create the .XML object with tag name and its value
	 * @param tagName Tag name
	 * @param tagValue Tag value
	 */
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
	
	/**
	 * Create all the tag for the object
	 * @param jsonObject {@link JSONObject}
	 */
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