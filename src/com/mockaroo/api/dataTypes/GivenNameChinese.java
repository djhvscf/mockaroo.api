/**
 * 
 */
package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.exceptions.MockarooExceptionName;

/**
 * GivenNameChinese mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class GivenNameChinese implements IMockarooObject {

	private static GivenNameChinese instance = null;
	private String columnName;

	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private GivenNameChinese(String columnName) {
		this.setColumnName(columnName);
	}

	/**
	 * Get the {@link GivenNameChinese} object
	 * @param columnName Column name
	 * @return {@link GivenNameChinese} object
	 * @throws MockarooExceptionName 
	 */
	public static GivenNameChinese getInstance(String columnName)
			throws MockarooExceptionName {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		if (instance == null) {
			instance = new GivenNameChinese(columnName);
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
		return "Given Name (Chinese)";
	}
}
