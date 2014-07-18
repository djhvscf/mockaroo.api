package com.mockaroo.api;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import jxl.write.WriteException;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.classes.MockarooFile;
import com.mockaroo.api.exceptions.MockarooExceptionJSONArray;
import com.mockaroo.api.helpers.MockarooJSONHelper;

/**
 * Class base to Mockaroo JSON
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 16/July/2014
 */
public class MockarooJSON extends MockarooFile {

	private static final String messageExceptionJSONArray = "The count parameter can't be less than 0 or equal";
	private MockarooJSONHelper jsonHelper;
	private String fileName;
	private static final String EXTENSION = ".json";
	
	/**
	 * Constructor
	 * @param path Where save the file .json
	 * @param fileName File name
	 */
	public MockarooJSON(String path, String fileName)
	{
		this.setJsonHelper(new MockarooJSONHelper());
		this.setFileName(path + fileName + EXTENSION);
	}
	
	/**
	 * Get the json helper to write a .json
	 * @return the jsonHelper
	 */
	private MockarooJSONHelper getJsonHelper() {
		return jsonHelper;
	}

	/**
	 * Get the file name
	 * @return the fileName
	 */
	private String getFileName() {
		return fileName;
	}

	/**
	 * Set the json helper
	 * @param jsonHelper the jsonHelper to set
	 */
	private void setJsonHelper(MockarooJSONHelper jsonHelper) {
		this.jsonHelper = jsonHelper;
	}

	/**
	 * Set the file name
	 * @param fileName the fileName to set
	 */
	private void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Generate the {@link JSONObject}
	 * @param conn {@link HttpURLConnection}
	 * @param columns {@link JSONArray} columns
	 * @return {@link JSONObject}
	 * @throws IOException
	 */
	public static JSONObject getJSONObject(HttpURLConnection conn, JSONArray columns) throws IOException
	{
		OutputStream os = conn.getOutputStream();
		os.write(columns.toString().getBytes());
		os.flush();

		return new JSONObject(IOUtils.toString(conn.getInputStream()));
	}
	
	/**
	* Generate the {@link JSONArray}
	 * @param conn {@link HttpURLConnection}
	 * @param columns {@link JSONArray} with the columns
	 * @param countRegister Qunatity of register in the JSONArray
	 * @return {@link JSONArray}
	 * @throws IOException
	 * @throws MockarooExceptionJSONArray
	 */
	public static JSONArray getJSONArray(HttpURLConnection conn, JSONArray columns, int countRegister) throws IOException, MockarooExceptionJSONArray
	{
		if(countRegister <= 0)
		{
			throw new MockarooExceptionJSONArray(messageExceptionJSONArray);
		}
		
		OutputStream os = conn.getOutputStream();
		os.write(columns.toString().getBytes());
		os.flush();
		return new JSONArray(IOUtils.toString(conn.getInputStream()));
	}

	@Override
	public void write(JSONObject jsonObject) throws IOException, WriteException 
	{
		this.getJsonHelper().write(this.getFileName(), jsonObject);
	}
}