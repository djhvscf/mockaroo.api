package com.mockaroo.api.interfaces;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;

/**
 * Interface that provide base methods to create JSONObject
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 09/July/2014
 */
public interface ICreateJSONObject {

	public static final String messageExceptionName = "The column name can't be empty";
	public static final String messageExceptionMinDate = "The min date can't be empty";
	public static final String messageExceptionMaxDate = "The max date can't be empty";
	public static final String messageExceptionFormatDate = "The format date can't be empty";
	public static final String messageExceptionMinLess = "The min number can't be less than 0";
	public static final String messageExceptionMaxLess = "The max number can't be less than 0";
	public static final String messageExceptionDecimalLess = "The decimals number can't be less than 0";
	public static final String messageExceptionNumberSame = "The min and max numbers can't be the same";
	public static final String messageExceptionMinMax = "The min number must be less than max number";
	public static final String messageExceptionArray = "The array values can't be empty";
	
	/**
	 * Create a JSONObject
	 * @param pname Column name
	 * @param pType {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 */
	JSONObject createJSONObject(String pname, String pType) throws MockarooExceptionName;

	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param min Minimum number
	 * @param max Maximum number
	 * @param decimals Number of decimals
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionNumber
	 * @throws MockarooExceptionName
	 */
	JSONObject createJSONObject(String name, int min, int max, int decimals)
			throws MockarooExceptionNumber, MockarooExceptionName;

	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param min Minimum number
	 * @param max Maximum number
	 * @param format Format date
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 */
	JSONObject createJSONObject(String name, String min, String max,
			String format) throws MockarooExceptionName;

	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param type {@link MockarooType}
	 * @param values {@link JSONArray}
	 * @return {@link JSONObject
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionArray
	 */
	JSONObject createJSONObject(String name, String type, JSONArray values)
			throws MockarooExceptionName, MockarooExceptionArray;
}