/**
 * 
 */
package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;

/**
 * CurrencyCode mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 26/07/2014
 * @since 2.0.0
 */
public class CurrencyCode implements IMockarooObject {
	
	private static CurrencyCode instance = null;
	private String columnName;
	
	/**
	 * Constructor
	 * @param columnName
	 */
	private CurrencyCode(String columnName)
	{
		this.setColumnName(columnName);
	}
	
	/**
	 * Get the {@link CurrencyCode} object
	 * @param columnName
	 * @return
	 * @throws MockarooExceptionName 
	 */
	public static CurrencyCode getInstance(String columnName) throws MockarooExceptionName
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		
		if(instance == null)
		{
			instance = new CurrencyCode(columnName);
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
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#geyType()
	 */
	@Override
	public String getType() {
		return MockarooType.Currency_Code.toString().replace(UNDERSCORE, SPACE);
	}
}
