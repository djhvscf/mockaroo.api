package com.mockaroo.api;

import java.io.IOException;

import jxl.write.WriteException;

import org.json.JSONObject;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.mockaroo.api.classes.MockarooFile;
import com.mockaroo.api.exceptions.MockarooExceptionValue;
import com.mockaroo.api.helpers.MockarooValidatorHelper;
import com.mockaroo.api.helpers.MockarooXMLHelper;
import com.mockaroo.api.interfaces.IMockarooValidatorHelper;
import com.mockaroo.api.interfaces.IMockarooXMLHelper;

/**
 * Class base to Mockaroo XML
 * @author Dennis Hernández Vargas
 * @version 0.1.1
 * @since 18/July/2014
 */
public class MockarooXML extends MockarooFile {

	private IMockarooXMLHelper xmlHelper;
	private String path;
	private String fileName;
	private String rootElement;
	private static final String CHILD_ELEMENT = "Object";
	private static final String EXTENSION = ".xml";
	private IMockarooValidatorHelper validator = MockarooValidatorHelper.getInstance();
	private String messageExceptionPath = "The path can't be empty";
	private String messageExceptionFileName = "The file name can't be empty";
	private String messageExceptionRootElement = "The root element name can't be empty";
	
	/**
	 * Constructor
	 * @param path Path where save the file
	 * @param fileName File name
	 * @param rootElement Name of the root element of the .XML
	 * @throws ParserConfigurationException
	 * @throws MockarooExceptionValue 
	 */
	public MockarooXML(String path, String fileName, String rootElement) throws ParserConfigurationException, MockarooExceptionValue
	{
		validator.validateString(path, messageExceptionPath);
		validator.validateString(fileName, messageExceptionFileName);
		validator.validateString(rootElement, messageExceptionRootElement);
		
		xmlHelper = MockarooXMLHelper.getInstance();
		this.setFileName(fileName + EXTENSION);
		this.setPath(path);
		this.setRootElement(rootElement);
	}
	
	/**
	 * Get the path
	 * @return Path where save the file
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Get the file name
	 * @return File name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Set the path where save the file
	 * @param path String with the path
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * File name
	 * @param fileName String with the file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Get the root element
	 * @return The root element name
	 */
	private String getRootElement() {
		return rootElement;
	}

	/**
	 * Set the root element name
	 * @param rootElement the rootElement to set
	 */
	private void setRootElement(String rootElement) {
		this.rootElement = rootElement;
	}

	@Override
	public void write(JSONObject jsonObject) throws IOException, WriteException, TransformerException 
	{
		xmlHelper.write(this.getPath() + this.getFileName(), this.getRootElement(), CHILD_ELEMENT, jsonObject);
	}
}