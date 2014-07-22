package com.mockaroo.api.helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.interfaces.IMockarooDataAccessHelper;

/**
 * Class to help the MockarooDataAccess class - Helper class
 * @author Dennis Hernández Vargas
 * @version 1.0.0 - 19/July/2014
 * @since 1.0.0
 */
public class MockarooDataAccessHelper implements IMockarooDataAccessHelper {

	private static MockarooDataAccessHelper instance = null;
	private static final String messageExceptionInsertError = "An error ocurred inserting the data";
	private static final String INSERT_INTO = "INSERT INTO ";
	private static final String LAST = ") ";
	private static final String COMMA = ",";

	/**
	 * Default constructor
	 * Applying singleton
	 */
	private MockarooDataAccessHelper(){}
	
	/**
	 * Get the {@link MockarooDataAccessHelper}
	 * @return MockarooDataAccessHelper
	 */
	public static MockarooDataAccessHelper getInstance()
	{
		if(instance == null)
		{
			instance = new MockarooDataAccessHelper();
		}
		return instance;
	}
	/**
	 * Generate the values of the table
	 * @param values Array to generate the string
	 * @return String with the values of the table
	 */
	public String generateValues(String[] values)
	{
		String first = " (";
		String valuesGenerated = "";
		valuesGenerated += first;
		
		for(int i = 0; i < values.length; i++)
		{
			valuesGenerated += values[i] + COMMA;
		}
		
		valuesGenerated = validateEnds(valuesGenerated) + LAST;
		
		return valuesGenerated;
	}
	
	/**
	 * Generate the values to insert
	 * @param jsonObject
	 * @return String with values to insert
	 */
	public String generateValuesInsert(JSONObject jsonObject)
	{
		JSONArray name = jsonObject.names();
		String first = "VALUES(";
		String valuesToInsert = "";
		valuesToInsert += first;
		
		for(int i = 0; i < name.length(); i++)
		{
			valuesToInsert += "'" + jsonObject.getString(name.getString(i)) + "'" + COMMA;
		}
		
		valuesToInsert = validateEnds(valuesToInsert) + LAST;
		
		return valuesToInsert;
	}
	
	/**
	 * Validate if the string ends with ,
	 * @param value String to validate
	 * @return String without ,
	 */
	private String validateEnds(String value)
	{
		if (value.endsWith(COMMA)) 
		{
			value = value.substring(0, value.length() - 1);
		}
		
		return value;
	}

	@Override
	public void Insert(String tableName, JSONObject jsonObject, String[] values, Connection connection)
			throws ClassNotFoundException, SQLException {
		
		String insertQuery = INSERT_INTO + tableName + this.generateValues(values) + 
				this.generateValuesInsert(jsonObject);

		Statement statement;
		statement = connection.createStatement();
		try
		{
			statement.execute(insertQuery);
		}
		catch(SQLException s)
		{
			throw new SQLException(messageExceptionInsertError);
		}
	}

	@Override
	public void Insert(String tableName, JSONArray jsonArray, String[] values,
			Connection connection) throws ClassNotFoundException, SQLException {
		
		String columns = this.generateValues(values);
		String insertQuery = "";
		for(int i = 0; i < jsonArray.length(); i ++){
			insertQuery = INSERT_INTO + tableName + columns + 
					this.generateValuesInsert(jsonArray.getJSONObject(i));
	
			Statement statement;
			statement = connection.createStatement();
			try
			{
				statement.execute(insertQuery);
			}
			catch(SQLException s)
			{
				throw new SQLException(messageExceptionInsertError);
			}
			finally
			{
				insertQuery = "";
			}
		}
	}
}