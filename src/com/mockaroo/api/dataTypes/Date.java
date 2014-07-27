/**
 * 
 */
package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionFormatDate;
import com.mockaroo.api.exceptions.MockarooExceptionName;

/**
 * Date mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 26/07/2014
 * @since 2.0.0
 */
public class Date implements IMockarooObject {

	private static Date instance = null;
	private String columnName;
	private String minDate;
	private String maxDate;
	private String formatDate;

	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private Date(String columnName, String minDate, String maxDate, String formatDate) 
	{
		this.setColumnName(columnName);
		this.setMinDate(minDate);
		this.setMaxDate(maxDate);
		this.setFormatDate(formatDate);
	}

	/**
	 * Get the {@link Date} object
	 * @param columnName Column name
	 * @param minDate Minimum date
	 * @param maxDate Maximum date
	 * @param formatDate Format date
	 * @return {@link Date} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionFormatDate 
	 */
	public static Date getInstance(String columnName, String minDate, String maxDate, String formatDate) 
			throws MockarooExceptionName, MockarooExceptionFormatDate 
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateDateFormat(minDate, formatDate, messageExceptionMinDate, messageExceptionFormatDate);
		VALIDATOR.validateDateFormat(maxDate, formatDate, messageExceptionMaxDate, messageExceptionFormatDate);
		
		if (instance == null) {
			instance = new Date(columnName, minDate, maxDate, formatDate);
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
	 * Get the minDate
	 * @return the minDate
	 */
	private String getMinDate() {
		return minDate;
	}

	/**
	 * Get the maxDate
	 * @return the maxDate
	 */
	private String getMaxDate() {
		return maxDate;
	}

	/**
	 * Get the formatDate
	 * @return the formatDate
	 */
	private String getFormatDate() {
		return formatDate;
	}

	/**
	 * Set the minDate
	 * @param minDate the minDate to set
	 */
	private void setMinDate(String minDate) {
		this.minDate = minDate;
	}

	/**
	 * Set the maxDate
	 * @param maxDate the maxDate to set
	 */
	private void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	/**
	 * Set the formatDate
	 * @param formatDate the formatDate to set
	 */
	private void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(MIN, this.getMinDate());
		jsonObject.put(MAX, this.getMaxDate());
		jsonObject.put(FORMAT, this.getFormatDate());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#geyType()
	 */
	@Override
	public String getType() {
		return MockarooType.Date.toString();
	}
}
