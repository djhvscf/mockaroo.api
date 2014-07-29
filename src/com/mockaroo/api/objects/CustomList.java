/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * CustomList mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 26/07/2014
 * @since 2.0.0
 */
public class CustomList implements IMockarooObject {

	private static CustomList instance = null;
	private String columnName;
	private JSONArray values;

	/**
	 * Constructor
	 * @param columnName Column name
	 * @param values An array of values to pick from. Each value should be a string
	 */
	private CustomList(String columnName, JSONArray values) {
		this.setColumnName(columnName);
		this.setValues(values);
	}

	/**
	 * Get the {@link CustomList} object
	 * @param columnName Column name
	 * @param values An array of values to pick from. Each value should be a string
	 * @return {@link CustomList} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionArray 
	 */
	public static CustomList getInstance(String columnName, JSONArray values) 
			throws MockarooExceptionName, MockarooExceptionArray 
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		
		if(values.length() == 0)
		{
			throw new MockarooExceptionArray(messageExceptionArray);
		}
		
		if (instance == null) {
			instance = new CustomList(columnName, values);
		}

		return instance;
	}

	/**
	 * Get the columnName
	 * @return the columnName
	 */
	private String getColumnName() {
		return columnName;
	}

	/**
	 * Set the columnName
	 * @param columnName the columnName to set
	 */
	private void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * Get the values
	 * @return the values
	 */
	private JSONArray getValues() {
		return values;
	}

	/**
	 * Set the values
	 * @param values the values to set
	 */
	private void setValues(JSONArray values) {
		this.values = values;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(VALUES, this.getValues());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#geyType()
	 */
	@Override
	public String getType() {
		return MockarooType.Custom_List.toString().replace(UNDERSCORE, SPACE);
	}
}
