/**
 * 
 */
package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooMoneyType;
import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;

/**
 * Money mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class Money implements IMockarooObject {

	private static Money instance = null;
	private String columnName;
	private int min;
	private int max;
	private MockarooMoneyType moneyType;

	/**
	 * Constructor
	 * @param columnName Column name
	 * @param min The minimum value
	 * @param max The maximum value
	 * @param moneyType See {@link MockarooMoneyType}
	 */
	private Money(String columnName, int min, int max, MockarooMoneyType moneyType) {
		this.setColumnName(columnName);
		this.setMin(min);
		this.setMax(max);
		this.setMoneyType(moneyType);
	}

	/**
	 * Get the {@link Money} object
	 * @param columnName Column name
	 * @param min The minimum value
	 * @param max The maximum value
	 * @param moneyType See {@link MockarooMoneyType}
	 * @return {@link Money} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 */
	public static Money getInstance(String columnName, int min, int max, MockarooMoneyType moneyType)
			throws MockarooExceptionName, MockarooExceptionNumber {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateNumber(min, messageExceptionMaxLess);
		VALIDATOR.validateNumber(max, messageExceptionMaxLess);
		VALIDATOR.validateNumberEquals(min, max, messageExceptionNumberSame);
		
		if (instance == null) {
			instance = new Money(columnName, min, max, moneyType);
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
	 * Get the max
	 * @return the max
	 */
	private int getMax() {
		return max;
	}

	/**
	 * Set the min
	 * @param min the min to set
	 */
	private void setMin(int min) {
		this.min = min;
	}

	/**
	 * Set the max
	 * @param max the max to set
	 */
	private void setMax(int max) {
		this.max = max;
	}

	/**
	 * Get the moneyType
	 * @return the moneyType
	 */
	private MockarooMoneyType getMoneyType() {
		return moneyType;
	}

	/**
	 * Set the moneyType
	 * @param moneyType the moneyType to set
	 */
	private void setMoneyType(MockarooMoneyType moneyType) {
		this.moneyType = moneyType;
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
		jsonObject.put(MAX, this.getMax());
		jsonObject.put(SYMBOL, this.getMoneyType().toString());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.Money.toString();
	}
}
