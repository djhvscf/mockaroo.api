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
import com.mockaroo.api.interfaces.IMockarooUrl;

/**
 * Class base to MockarooApi
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 16/July/2014
 */
public class MockarooApi {

	private final IMockarooUrl url;
	private String key;
	private String contentType;
	private int countRegister;
	private final MockarooCreateJSONObject creater;
	
	/**
	 * Constructor
	 * @param key Api key
	 * @param contentType Content type
	 * @throws MockarooExceptionPing 
	 */
	public MockarooApi(String key, String contentType) throws MockarooExceptionPing
	{
		MockarooPingHelper.ping();
		
		this.setKey(key);
		this.setContentType(contentType);
		this.setCountRegister(-1);
		url = MockarooUrl.getInstance(key, contentType);
		creater = new MockarooCreateJSONObject();
	}
	
	/**
	 * Constructor
	 * @param key Api key
	 * @param contentType Content type
	 * @param countRegister Qunatity of registers
	 * @throws MockarooExceptionPing 
	 */
	public MockarooApi(String key, String contentType, int countRegister) throws MockarooExceptionPing
	{
		MockarooPingHelper.ping();
		
		this.setKey(key);
		this.setContentType(contentType);
		this.setCountRegister(countRegister);
		url = MockarooUrl.getInstance(key, contentType);
		creater = new MockarooCreateJSONObject();
	}
	
	/**
	 * Get the content type
	 * @return Content type
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * Set the content type
	 * @param contentType
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
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
	 * Get the {@link MockarooCreateJSONObject}
	 * @return {@link MockarooCreateJSONObject}
	 */
	public MockarooCreateJSONObject getCreater() {
		return creater;
	}
	
	/**
	 * Gets the counter
	 * @return Quantity
	 */
	public int getCountRegister() {
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
	
	/*/**
	 * Insert into the database specified
	 * @param jsonObject JSONObject with the information
	 * @param dataAccess Object Data Access layer
	 * @param tableName Table to insert
	 * @param values Values of the table
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 *
	public void Insert(JSONObject jsonObject, MockarooDataAccess dataAccess, String tableName, String[] values) throws ClassNotFoundException, SQLException
	{
		String insertQuery = INSERT_INTO + tableName + mockarooApiHelper.generateValues(values) + 
								mockarooApiHelper.generateValuesInsert(jsonObject);
		if(!dataAccess.Insert(insertQuery))
		{
			throw new SQLException(messageExceptionInsertError);
		}
	}*/
}