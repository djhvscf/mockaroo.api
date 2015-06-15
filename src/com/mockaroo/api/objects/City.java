package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * City mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 25/July/2014
 * @since 2.0.0
 */
public class City implements IMockarooObject {

	private static City instance = null;
	private String columnName;
	
	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private City(String columnName)
	{
		this.setColumnName(columnName);
	}
	
	/**
	 * Get thee {@link City} object
	 * Applying singleton
	 * @param columnName Column namee
	 * @return {@link City} object
	 * @throws MockarooExceptionName
	 */
	public static City getInstance(String columnName) throws MockarooExceptionName
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		
		if(instance == null)
		{
			instance = new City(columnName);
		}
		
		return instance;
	}
	
	/**
	 * Set the column name
	 * @param columnName Column name
	 */
	private void setColumnName(String columnName) 
	{
		this.columnName = columnName;
	}
	
	/**
	 * Get the column name
	 * @return String column name
	 */
	private String getColumnName()
	{
		return this.columnName;
	}

	@Override
	public JSONObject getJSONObject() 
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());

		return jsonObject;
	}
	
	@Override
	public String getType() {
		return MockarooType.City.toString();
	}
}
