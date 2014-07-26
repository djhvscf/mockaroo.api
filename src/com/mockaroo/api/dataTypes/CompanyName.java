/**
 * 
 */
package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;

/**
 * Company Name mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 26/07/2014
 * @since 2.0.0
 */
public class CompanyName implements IMockarooObject {
	
	private static CompanyName instance = null;
	private String columnName;
	
	/**
	 * Constructor
	 * @param columnName Column name
	 */
	private CompanyName(String columnName)
	{
		this.setColumnName(columnName);
	}
	
	/**
	 * Get the {@link CompanyName} object
	 * @param columnName Column name
	 * @return {@link CompanyName} object
	 * @throws MockarooExceptionName 
	 */
	public static CompanyName getInstance(String columnName) throws MockarooExceptionName
	{
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		
		if(instance == null)
		{
			instance = new CompanyName(columnName);
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

	@Override
	public JSONObject getJSONObject() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.geyType());

		return jsonObject;
	}

	@Override
	public String geyType() {
		return MockarooType.Company_Name.toString().replace(UNDERSCORE, SPACE);
	}
}