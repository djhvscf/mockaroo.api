/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooTimeType;
import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionFormatTime;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionValue;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * Time mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class Time implements IMockarooObject {

	private static Time instance = null;
	private String columnName;
	private String min;
	private String max;
	private MockarooTimeType format;

	/**
	 * Constructor
	 * @param columnName Column name
	 * @param min The minimum time in HH:MM AM/PM format
	 * @param max The maximum time in HH:MM AM/PM format
	 * @param format The format to output. This can be any format directive supported by ruby Time.strftime. 
	 * Defaults to ISO 8601 format. Example value: "08:37:48"
	 */
	private Time(String columnName, String min, String max, MockarooTimeType format) {
		this.setColumnName(columnName);
		this.setMin(min);
		this.setMax(max);
		this.setFormat(format);
	}

	/**
	 * Get the {@link Time} object
	 * @param columnName Column name
	 * @param min The minimum time in HH:MM AM/PM format
	 * @param max The maximum time in HH:MM AM/PM format
	 * @param format The format to output. This can be any format directive supported by ruby Time.strftime. 
	 * Defaults to ISO 8601 format. Example value: "08:37:48"
	 * @return {@link Time} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionValue 
	 * @throws MockarooExceptionFormatTime 
	 */
	public static Time getInstance(String columnName, String min, String max, MockarooTimeType format)
			throws MockarooExceptionName, MockarooExceptionValue, MockarooExceptionFormatTime {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);		
		VALIDATOR.validateString(min, messageExceptionMinTime);		
		VALIDATOR.validateString(max, messageExceptionMaxTime);
		VALIDATOR.validateTimeFormat(format.toString(), messageExceptionValueTemplate);
		
		if (instance == null) {
			instance = new Time(columnName, min, max, format);
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
	private String getMin() {
		return min;
	}

	/**
	 * Get the max
	 * @return the max
	 */
	private String getMax() {
		return max;
	}

	/**
	 * Get the format
	 * @return the format
	 */
	private MockarooTimeType getFormat() {
		return format;
	}

	/**
	 * Set the min
	 * @param min the min to set
	 */
	private void setMin(String min) {
		this.min = min;
	}

	/**
	 * Set the max
	 * @param max the max to set
	 */
	private void setMax(String max) {
		this.max = max;
	}

	/**
	 * Set the format
	 * @param format the format to set
	 */
	private void setFormat(MockarooTimeType format) {
		this.format = format;
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
		jsonObject.put(FORMAT, this.getFormat().toString());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.Time.toString();
	}
}
