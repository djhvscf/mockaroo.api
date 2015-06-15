/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * Color mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 25/07/2014
 * @since 2.0.0
 */
public class Color implements IMockarooObject{

	private static Color instance = null;
	private String columnName;
	
	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private Color(String columnName)
	{
		this.setColumnName(columnName);
	}
	
	/**
	 * Get the {@link Color} object
	 * @param columnName Column name
	 * @return {@link Color} object
	 * @throws MockarooExceptionName 
	 */
	public static Color getInstance(String columnName) throws MockarooExceptionName
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		
		if(instance == null)
		{
			instance = new Color(columnName);
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

	@Override
	public JSONObject getJSONObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());

		return jsonObject;
	}

	@Override
	public String getType() {
		return MockarooType.Color.toString();
	}

}
