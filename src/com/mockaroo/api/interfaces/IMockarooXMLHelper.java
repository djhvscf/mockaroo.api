package com.mockaroo.api.interfaces;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import jxl.write.WriteException;

import org.json.JSONObject;

/**
 * Class to create a XML file
 * @author Dennis Hernández Vargas
 * @version 0.1.1
 * @since 18/July/2014
 */
public interface IMockarooXMLHelper {

	/**
	 * Write in the XML file
	 * @param fileName File name
	 * @param jsonObject {@link JSONObject}
	 * @throws IOException
	 * @throws WriteException
	 * @throws TransformerException
	 */
	public void write(String fileName, String rootTagName, String objectName, JSONObject jsonObject) 
			throws IOException, WriteException, TransformerException;
}
