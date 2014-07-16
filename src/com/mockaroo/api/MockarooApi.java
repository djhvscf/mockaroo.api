package com.mockaroo.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.classes.MockarooCreateJSONObject;
import com.mockaroo.api.classes.MockarooUrl;
import com.mockaroo.api.exceptions.MockarooExceptionJSONArray;
import com.mockaroo.api.interfaces.IUrl;

/**
 * Class base to MockarooApi
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 16/July/2014
 */
public class MockarooApi {

	private final IUrl url;
	private String key;
	private String contentType;
	private int countRegister;
	private final MockarooCreateJSONObject creater;
	private static final String messageExceptionInsertError = "An error ocurred inserting the data";
	private static final String INSERT_INTO = "INSERT INTO ";
	
	/**
	 * Constructor
	 * @param key Api key
	 * @param contentType Content type
	 */
	public MockarooApi(String key, String contentType)
	{
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
	 */
	public MockarooApi(String key, String contentType, int countRegister)
	{
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
	 * @return {@link IUrl}
	 */
	public IUrl getUrl() {
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
	
	/**
	 * Insert into the database specified
	 * @param jsonObject JSONObject with the information
	 * @param dataAccess Object Data Access layer
	 * @param tableName Table to insert
	 * @param values Values of the table
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void Insert(JSONObject jsonObject, MockarooDataAccess dataAccess, String tableName, String[] values) throws ClassNotFoundException, SQLException
	{
		String insertQuery = INSERT_INTO + tableName + generateValues(values) + generateValuesInsert(jsonObject);
		if(!dataAccess.Insert(insertQuery))
		{
			throw new SQLException(messageExceptionInsertError);
		}
	}
	
	/**
	 * Generate the values of the table
	 * @param values Array to generate the string
	 * @return String with the values of the table
	 */
	private String generateValues(String[] values)
	{
		String first = " (";
		String last = ") ";
		String valuesGenerated = "";
		valuesGenerated += first;
		
		for(int i = 0; i < values.length; i++)
		{
			valuesGenerated += values[i] + ",";
		}
		
		valuesGenerated = validateEnds(valuesGenerated) + last;
		
		return valuesGenerated;
	}
	
	/**
	 * Generate the values to insert
	 * @param jsonObject
	 * @return String with values to insert
	 */
	private String generateValuesInsert(JSONObject jsonObject)
	{
		JSONArray name = jsonObject.names();
		String first = "VALUES(";
		String last = ") ";
		String valuesToInsert = "";
		
		valuesToInsert += first;
		
		for(int i = 0; i < name.length(); i++)
		{
			valuesToInsert += "'" + jsonObject.getString(name.getString(i)) + "'" + ",";
		}
		
		valuesToInsert = validateEnds(valuesToInsert) + last;
		
		return valuesToInsert;
	}
	
	/**
	 * Validate if the string ends with ,
	 * @param value String to validate
	 * @return String without ,
	 */
	private String validateEnds(String value)
	{
		if (value.endsWith(",")) 
		{
			value = value.substring(0, value.length() - 1);
		}
		
		return value;	
	}
}
