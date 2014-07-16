package com.mockaroo.api;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
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
	private static final String messageExceptionJSONArray = "The count parameter can't be less than 0 or equal";
	private static final String messageExceptionInsertError = "An error ocurred inserting the data";
	private static final String INSERT_INTO = "INSERT INTO ";
	
	public MockarooApi(String key, String contentType)
	{
		this.setKey(key);
		this.setContentType(contentType);
		this.setCountRegister(-1);
		url = MockarooUrl.getInstance(key, contentType);
		creater = new MockarooCreateJSONObject();
	}
	
	public MockarooApi(String key, String contentType, int countRegister)
	{
		this.setKey(key);
		this.setContentType(contentType);
		this.setCountRegister(countRegister);
		url = MockarooUrl.getInstance(key, contentType);
		creater = new MockarooCreateJSONObject();
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getKey() {
		return key;
	}

	private void setKey(String key) {
		this.key = key;
	}
	
	public IUrl getUrl() {
		return url;
	}

	public MockarooCreateJSONObject getCreater() {
		return creater;
	}
	
	public int getCountRegister() {
		return countRegister;
	}

	private void setCountRegister(int countRegister) {
		this.countRegister = countRegister;
	}
	
	public JSONObject getJSONObject(HttpURLConnection conn, JSONArray columns) throws IOException
	{
		OutputStream os = conn.getOutputStream();
		os.write(columns.toString().getBytes());
		os.flush();

		return new JSONObject(IOUtils.toString(conn.getInputStream()));
	}
	
	public JSONArray getJSONArray(HttpURLConnection conn, JSONArray columns) throws IOException, MockarooExceptionJSONArray
	{
		if(this.getCountRegister() <= 0)
		{
			throw new MockarooExceptionJSONArray(messageExceptionJSONArray);
		}
		
		OutputStream os = conn.getOutputStream();
		os.write(columns.toString().getBytes());
		os.flush();
		return new JSONArray(IOUtils.toString(conn.getInputStream()));
	}
	
	public void Insert(JSONObject jsonObject, MockarooDataAccess dataAccess, String tableName, String[] values) throws ClassNotFoundException, SQLException
	{
		String insertQuery = INSERT_INTO + tableName + generateValues(values) + generateValuesInsert(jsonObject);
		if(!dataAccess.Insert(insertQuery))
		{
			throw new SQLException(messageExceptionInsertError);
		}
	}
	
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
	
	private String generateValuesInsert(JSONObject jsonObject)
	{
		JSONArray name = jsonObject.names();
		String first = "VALUES(";
		String last = ") ";
		String retur = "";
		
		retur += first;
		
		for(int i = 0; i < name.length(); i++)
		{
			retur += "'" + jsonObject.getString(name.getString(i)) + "'" + ",";
		}
		
		retur = validateEnds(retur) + last;
		
		return retur;
	}
	
	private String validateEnds(String value)
	{
		if (value.endsWith(",")) 
		{
			value = value.substring(0, value.length() - 1);
		}
		
		return value;	
	}
}
