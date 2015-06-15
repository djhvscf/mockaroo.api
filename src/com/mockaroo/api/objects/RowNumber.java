/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * RowNumber mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class RowNumber implements IMockarooObject {

	private static RowNumber instance = null;
	private String columnName;

	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private RowNumber(String columnName) {
		this.setColumnName(columnName);
	}

	/**
	 * Get the {@link RowNumber} object
	 * @param columnName Column name
	 * @return {@link RowNumber} object
	 * @throws MockarooExceptionName 
	 */
	public static RowNumber getInstance(String columnName)
			throws MockarooExceptionName {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		if (instance == null) {
			instance = new RowNumber(columnName);
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
		return MockarooType.Row_Number.toString().replace(UNDERSCORE, SPACE);
	}
}
