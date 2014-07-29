/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionMyList;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionValue;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * MyList mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class MyList implements IMockarooObject {

	private static MyList instance = null;
	private String columnName;
	private String myListName;

	/**
	 * Constructor
	 * @param columnName Column name
	 * @param myListName The name of a saved list
	 */
	private MyList(String columnName, String myListName) {
		this.setColumnName(columnName);
		this.setMyListName(myListName);
	}

	/**
	 * Get the {@link MyList} object
	 * @param columnName Column name
	 * @param myListName The name of a saved list
	 * @return {@link MyList} object
	 * @throws MockarooExceptionName 
	 * @throws MockarooExceptionMyList 
	 * @throws MockarooExceptionValue 
	 */
	public static MyList getInstance(String columnName, String myListName)
			throws MockarooExceptionName, MockarooExceptionMyList, MockarooExceptionValue {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		VALIDATOR.validateString(myListName, messageExceptionMyList);
		
		if (instance == null) {
			instance = new MyList(columnName, myListName);
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
	 * Get the myListName
	 * @return the myListName
	 */
	private String getMyListName() {
		return myListName;
	}

	/**
	 * Set the myListName
	 * @param myListName the myListName to set
	 */
	private void setMyListName(String myListName) {
		this.myListName = myListName;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(LIST, this.getMyListName());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.My_List.toString().replace(UNDERSCORE, SPACE);
	}
}
