package com.mockaroo.api;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.classes.MockarooCreateJSONObject;
import com.mockaroo.api.classes.MockarooUrl;
import com.mockaroo.api.exceptions.MockarooExceptionJSONArray;
import com.mockaroo.api.exceptions.MockarooExceptionPing;
import com.mockaroo.api.helpers.MockarooPingHelper;
import com.mockaroo.api.interfaces.IMockarooPingHelper;
import com.mockaroo.api.interfaces.IMockarooUrl;

/**
 * Class base to MockarooApi
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 16/July/2014
 * @since 0.1.0
 */
public class MockarooApi {

	private final IMockarooUrl url;
	private String key;
	private int countRegister;
	private final MockarooCreateJSONObject creater;
	private static IMockarooPingHelper mockarooPingHelper;
	private static final String contentType = "application/json";
	
	/**
	 * Constructor
	 * @param key Api key
	 * @throws MockarooExceptionPing 
	 */
	public MockarooApi(String key) throws MockarooExceptionPing
	{
		this(key, -1);
	}
	
	/**
	 * Constructor
	 * @param key Api key
	 * @param countRegister Qunatity of registers
	 * @throws MockarooExceptionPing 
	 */
	public MockarooApi(String key, int countRegister) throws MockarooExceptionPing
	{
		mockarooPingHelper = MockarooPingHelper.getInstance();
		mockarooPingHelper.ping();
		
		this.setKey(key);
		this.setCountRegister(countRegister);
		if(countRegister == -1)
		{
			url = MockarooUrl.getInstance(key, contentType);
		}
		else
		{
			url = MockarooUrl.getInstance(key, contentType, countRegister);
		}
		creater = new MockarooCreateJSONObject();
	}

	/**
	 * Get the api key
	 * @return Api key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Api key
	 * @param key
	 */
	private void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Get the url
	 * @return {@link IMockarooUrl}
	 */
	public IMockarooUrl getUrl() {
		return url;
	}

	/**
	 * Get the {@link MockarooCreateJSONObject} object
	 * @return {@link MockarooCreateJSONObject}
	 */
	public MockarooCreateJSONObject getCreater() {
		return creater;
	}
	
	/**
	 * Gets the counter
	 * @return Quantity
	 */
	private int getCountRegister() {
		return countRegister;
	}

	/**
	 * Set the quantity of the register
	 * @param countRegister Quantity
	 */
	private void setCountRegister(int countRegister) {
		this.countRegister = countRegister;
	}
	
	/**
	 * Return a JSONObject
	 * @param conn Connection
	 * @param columns Columns of the JSONObject
	 * @return JSONObject with data
	 * @throws IOException
	 */
	public JSONObject getJSONObject(HttpURLConnection conn, JSONArray columns) throws IOException
	{
		return MockarooJSON.getJSONObject(conn, columns);
	}
	
	/**
	 * Return a JSONArray
	 * @param conn Connection
	 * @param columns Columns of the JSONArray
	 * @return JSONArray with data
	 * @throws IOException
	 * @throws MockarooExceptionJSONArray
	 */
	public JSONArray getJSONArray(HttpURLConnection conn, JSONArray columns) throws IOException, MockarooExceptionJSONArray
	{
		return MockarooJSON.getJSONArray(conn, columns, this.getCountRegister());
	}
}