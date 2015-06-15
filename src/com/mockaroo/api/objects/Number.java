/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * Number mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class Number implements IMockarooObject {

	private static Number instance = null;
	private String columnName;
	private int min;
	private int decimals;

	/**
	 * Constructor
	 * @param columnName Column name
	 * @param min The maximum value
	 * @param decimals The number of decimals
	 */
	private Number(String columnName, int min, int decimals) {
		this.setColumnName(columnName);
		this.setMin(min);
		this.setDecimals(decimals);
	}

	/**
	 * Get the {@link Number} object
	 * @param columnName Column name
	 * @param min The maximum value
	 * @param decimals The number of decimals
	 * @return {@link Number} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 */
	public static Number getInstance(String columnName, int min, int decimals)
			throws MockarooExceptionName, MockarooExceptionNumber {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateNumber(min, messageExceptionMinLess);
		VALIDATOR.validateNumber(decimals, messageExceptionDecimalLess);

		if (instance == null) {
			instance = new Number(columnName, min, decimals);
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
	 * Get the min
	 * @return the min
	 */
	private int getMin() {
		return min;
	}

	/**
	 * Get the decimals
	 * @return the decimals
	 */
	private int getDecimals() {
		return decimals;
	}

	/**
	 * Set the min
	 * @param min the min to set
	 */
	private void setMin(int min) {
		this.min = min;
	}

	/**
	 * Set the decimals
	 * @param decimals the decimals to set
	 */
	private void setDecimals(int decimals) {
		this.decimals = decimals;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(MIN, this.getMin());
		jsonObject.put(DECIMALS, this.getDecimals());

		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.Number.toString();
	}
}
