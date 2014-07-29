/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionRegExpValue;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * RegularExpression mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class RegularExpression implements IMockarooObject {

	private static RegularExpression instance = null;
	private String columnName;
	private String value;

	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private RegularExpression(String columnName, String value) {
		this.setColumnName(columnName);
		this.setValue(value);
	}

	/**
	 * Get the {@link RegularExpression} object
	 * @param columnName Column name
	 * @return {@link RegularExpression} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionRegExpValue 
	 */
	public static RegularExpression getInstance(String columnName, String value)
			throws MockarooExceptionName, MockarooExceptionRegExpValue {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateRegularExpression(value, messageExceptionRegValueInvalid);
		if(value.isEmpty())
		{
			throw new MockarooExceptionRegExpValue(messageExceptionValue);
		}
		
		if (instance == null) {
			instance = new RegularExpression(columnName, value);
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
	 * Get the value
	 * @return the value
	 */
	private String getValue() {
		return value;
	}

	/**
	 * Set the value
	 * @param value the value to set
	 */
	private void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(VALUE, this.getValue());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.Regular_Expression.toString().replace(UNDERSCORE, SPACE);
	}
}
