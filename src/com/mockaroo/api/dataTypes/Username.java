package com.mockaroo.api.dataTypes;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;

/**
 * Username mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 28/07/2014
 * @since 2.0.0
 */
public class Username implements IMockarooObject {

	private static Username instance = null;
	private String columnName;
	
	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private Username(String columnName)
	{
		this.setColumnName(columnName);
	}
	
	/**
	 * Get the {@link Username} object
	 * @param columnName Column name
	 * @return {@link Username} object
	 * @throws MockarooExceptionName 
	 */
	public static Username getInstance(String columnName) throws MockarooExceptionName
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		
		if (instance == null) {
			instance = new Username(columnName);
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

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());

		return jsonObject;
	}
	
	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.Username.toString();
	}

}
