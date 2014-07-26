package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;

/**
 * Blank mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 25/July/2014
 * @since 2.0.0
 */
public class Blank implements IMockarooObject {

	private static Blank instance = null;
	private String columnName;
	
	/**
	 * Default constructor
	 * @param columnName Column name
	 */
	private Blank(String columnName)
	{
		this.setColumnName(columnName);
	}
	
	/**
	 * Get the {@link Blank} object
	 * @param columnName Column name
	 * @return {@link Blank} object
	 * @throws MockarooExceptionName 
	 */
	public static Blank getInstance(String columnName) throws MockarooExceptionName
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		if(instance == null)
		{
			instance = new Blank(columnName);
		}
		
		return instance;
	}

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public JSONObject getJSONObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", this.getColumnName());
		jsonObject.put("type", this.geyType());

		return jsonObject;
	}

	@Override
	public String geyType() {
		return MockarooType.Blank.toString();
	}
}