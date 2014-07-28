package com.mockaroo.api.dataTypes;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;
import com.mockaroo.api.helpers.JSONObject;

/**
 * Words mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 28/07/2014
 * @since 2.0.0
 */
public class Words implements IMockarooObject {

	private static Words instance = null;
	private String columnName;
	private int min;
	private int max;
	
	/**
	 * Constructor
	 * @param columnName Column name
	 * @param min The minimum number of words
	 * @param max The maximum number of words
	 */
	private Words(String columnName, int min, int max)
	{
		this.setColumnName(columnName);
		this.setMin(min);
		this.setMax(max);
	}
	
	/**
	 * Get the {@link Words} object
	 * @param columnName Column name
	 * @param min The minimum number of words
	 * @param max The maximum number of words
	 * @return {@link Words} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 */
	public static Words getInstance(String columnName, int min, int max) throws MockarooExceptionName, MockarooExceptionNumber
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateNumber(min, messageExceptionMinLess);		
		VALIDATOR.validateNumber(max, messageExceptionMaxLess);		
		VALIDATOR.validateNumberEquals(min, max, messageExceptionNumberSame);
		
		if (instance == null) {
			instance = new Words(columnName, min, max);
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

	public void setMin(int min) {
		this.min = min;
	}

	public void setMax(int max) {
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
		return MockarooType.Words.toString();
	}

}
