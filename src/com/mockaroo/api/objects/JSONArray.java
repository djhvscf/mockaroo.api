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
 * JSONArray mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class JSONArray implements IMockarooObject {

	private static JSONArray instance = null;
	private String columnName;
	private int minItems;
	private int maxItems;

	/**
	 * Constructor
	 * @param columnName Column name
	 * @param minItems The minimum number of items to generate (0 to 100)
	 * @param maxItems The maximum number of items to generate (0 to 100)
	 */
	private JSONArray(String columnName, int minItems, int maxItems) {
		this.setColumnName(columnName);
		this.setMinItems(minItems);
		this.setMaxItems(maxItems);
	}

	/**
	 * Get the {@link JSONArray} object
	 * @param columnName Column name
	 * @param minItems The minimum number of items to generate (0 to 100)
	 * @param maxItems The maximum number of items to generate (0 to 100)
	 * @return {@link JSONArray} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionNumber 
	 */
	public static JSONArray getInstance(String columnName, int minItems, int maxItems)
			throws MockarooExceptionName, MockarooExceptionNumber {
		
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateNumber(minItems, messageExceptionMinLess);
		VALIDATOR.validateNumber(maxItems, messageExceptionMaxLess);		
		VALIDATOR.validateNumberEquals(minItems, maxItems, messageExceptionNumberSame);
		VALIDATOR.validateNumber(maxItems, 101, messageExceptionNumberJSONArray);
		
		if (instance == null) {
			instance = new JSONArray(columnName, minItems, maxItems);
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
	 * Get the minItems
	 * @return the minItems
	 */
	private int getMinItems() {
		return minItems;
	}

	/**
	 * Get the maxItems
	 * @return the maxItems
	 */
	private int getMaxItems() {
		return maxItems;
	}

	/**
	 * Set the minItems
	 * @param minItems the minItems to set
	 */
	private void setMinItems(int minItems) {
		this.minItems = minItems;
	}

	/**
	 * Set the maxItems
	 * @param maxItems the maxItems to set
	 */
	private void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(MINITEMS, this.getMinItems());
		jsonObject.put(MAXITEMS, this.getMaxItems());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.JSON_Array.toString().replace(UNDERSCORE, SPACE);
	}
}
