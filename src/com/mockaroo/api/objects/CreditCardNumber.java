/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * CreditCardNumber mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 26/07/2014
 * @since 2.0.0
 */
public class CreditCardNumber implements IMockarooObject {

	private static CreditCardNumber instance = null;
	private String columnName;
	
	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private CreditCardNumber(String columnName) {
		this.setColumnName(columnName);
	}
	
	/**
	 * Get the {@link CreditCardNumber} object
	 * @param columnName Column name
	 * @return {@link CreditCardNumber} object
	 * @throws MockarooExceptionName
	 */
	public static CreditCardNumber getInstance(String columnName) throws MockarooExceptionName
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		
		if(instance == null)
		{
			instance = new CreditCardNumber(columnName);
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
		return MockarooType.Credit_Card_1.toString().replace(UNDERSCORE, SPACE).replace('1', '#');
	}
}