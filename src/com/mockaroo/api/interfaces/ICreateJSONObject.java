package com.mockaroo.api.interfaces;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;

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
	
	JSONObject createJSONObject(String pname, String pType) throws MockarooExceptionName;

	JSONObject createJSONObject(String name, int min, int max, int decimals)
			throws MockarooExceptionNumber, MockarooExceptionName;

	JSONObject createJSONObject(String name, String min, String max,
			String format) throws MockarooExceptionName;

	JSONObject createJSONObject(String name, String type, JSONArray values)
			throws MockarooExceptionName, MockarooExceptionArray;
}
