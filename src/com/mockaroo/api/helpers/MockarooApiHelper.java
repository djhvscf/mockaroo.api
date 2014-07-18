package com.mockaroo.api.helpers;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class to help th MockarooApi class - Helper class
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 17/July/2014
 */
public class MockarooApiHelper {

	/**
	 * Generate the values of the table
	 * @param values Array to generate the string
	 * @return String with the values of the table
	 */
	public String generateValues(String[] values)
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
	public String generateValuesInsert(JSONObject jsonObject)
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
