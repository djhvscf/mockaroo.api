/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * FamilyNameChinese mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 26/07/2014
 * @since 2.0.0
 */
public class FamilyNameChinese implements IMockarooObject {

	private static FamilyNameChinese instance = null;
	private String columnName;

	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private FamilyNameChinese(String columnName) {
		this.setColumnName(columnName);
	}

	/**
	 * Get the {@link FamilyNameChinese} object
	 * @param columnName Column name
	 * @return {@link FamilyNameChinese} object
	 * @throws MockarooExceptionName 
	 */
	public static FamilyNameChinese getInstance(String columnName)
			throws MockarooExceptionName {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		if (instance == null) {
			instance = new FamilyNameChinese(columnName);
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
		return "Family Name (Chinese)";
	}
}
