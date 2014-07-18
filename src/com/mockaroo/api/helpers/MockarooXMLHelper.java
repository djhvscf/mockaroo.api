package com.mockaroo.api.helpers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import jxl.write.WriteException;

import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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

	public DocumentBuilder getDocBuilder() {
		return docBuilder;
	}

	private void setDocBuilder(DocumentBuilder docBuilder) {
		this.docBuilder = docBuilder;
	}

	public DocumentBuilderFactory getDocFactory() {
		return docFactory;
	}

	public void setDocFactory(DocumentBuilderFactory docFactory) {
		this.docFactory = docFactory;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
	
	public Element getRootElement() {
		return rootElement;
	}

	public void setRootElement(Element rootElement) {
		this.rootElement = rootElement;
	}

	public Element getObject() {
		return object;
	}

	public void setObject(Element object) {
		this.object = object;
	}

	public void createRootElement(String rootTagName)
	{
		this.setRootElement(this.getDocument().createElement(rootTagName));
		this.getDocument().appendChild(rootElement);
	}
	
	public void createChildElement(String objectName)
	{
		this.setObject(this.getDocument().createElement(objectName));
		this.getRootElement().appendChild(this.getObject());
	}
	
	public void createAttributes(String attributeName, String attributeValue)
	{
		Attr attr = this.getDocument().createAttribute(attributeName);
		attr.setValue(attributeValue);
		this.getObject().setAttributeNode(attr);
	}
	
	public void createObjectTag(String tagName, String tagValue)
	{
		Element element = this.getDocument().createElement(tagName);
		element.appendChild(this.getDocument().createTextNode(tagValue));
		this.getObject().appendChild(element);
	}
	
	public void write(String path, String fileName) throws TransformerException
	{
		
	}

	@Override
	public void write(String fileName, JSONObject jsonObject)
			throws IOException, WriteException, TransformerException {
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(this.getDocument());
		StreamResult result = new StreamResult(new File(fileName));
		
		transformer.transform(source, result);
	}
}