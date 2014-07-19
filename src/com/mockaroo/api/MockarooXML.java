package com.mockaroo.api;

import java.io.IOException;

import jxl.write.WriteException;

import org.json.JSONObject;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.mockaroo.api.classes.MockarooFile;
import com.mockaroo.api.helpers.MockarooXMLHelper;
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
	
	public MockarooXML(String path, String fileName, String rootElement) throws ParserConfigurationException
	{
		xmlHelper = MockarooXMLHelper.getInstance();
		this.setFileName(fileName + EXTENSION);
		this.setPath(path);
		this.setRootElement(rootElement);
	}
	
	public String getPath() {
		return path;
	}

	public String getFileName() {
		return fileName;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the rootElement
	 */
	private String getRootElement() {
		return rootElement;
	}

	/**
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