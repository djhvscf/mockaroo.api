/**
 * 
 */
package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;

/**
 * Sentences mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class Sentences implements IMockarooObject {

	private static Sentences instance = null;
	private String columnName;
	private int min;
	private int max;

	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private Sentences(String columnName, int min, int max) {
		this.setColumnName(columnName);
		this.setMin(min);
		this.setMax(max);
	}

	/**
	 * Get the {@link Sentences} object
	 * @param columnName Column name
	 * @return {@link Sentences} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 */
	public static Sentences getInstance(String columnName, int min, int max)
			throws MockarooExceptionName, MockarooExceptionNumber {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateNumber(min, messageExceptionMinLess);
		VALIDATOR.validateNumber(max, messageExceptionMaxLess);		
		VALIDATOR.validateNumberEquals(min, max, messageExceptionNumberSame);
		
		if (instance == null) {
			instance = new Sentences(columnName, min, max);
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
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.Sentences.toString();
	}
}
