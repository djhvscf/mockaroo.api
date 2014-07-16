package com.mockaroo.api;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.exceptions.MockarooExceptionJSONArray;

/**
 * Class base to Mockaroo JSON
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 16/July/2014
 */
public abstract class MockarooJSON {

	private static final String messageExceptionJSONArray = "The count parameter can't be less than 0 or equal";
	
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
}