package com.mockaroo.api.interfaces;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.enums.MockarooMoneyType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionFormula;
import com.mockaroo.api.exceptions.MockarooExceptionMyList;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;
import com.mockaroo.api.exceptions.MockarooExceptionRegExpValue;
import com.mockaroo.api.exceptions.MockarooExceptionValue;

/**
 * Interface that provide base methods to create JSONObject
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 09/July/2014
 */
public interface ICreateJSONObjectHelper {

	public static final String messageExceptionName = "The column name can't be empty";
	public static final String messageExceptionMinDate = "The min date can't be empty";
	public static final String messageExceptionMaxDate = "The max date can't be empty";
	public static final String messageExceptionFormatDate = "The format date can't be empty";
	public static final String messageExceptionMinLess = "The min number can't be less than 0";
	public static final String messageExceptionMeanLess = "The mean number can't be less than 0";
	public static final String messageExceptionSdLess = "The sd number can't be less than 1";
	public static final String messageExceptionMaxLess = "The max number can't be less than 0";
	public static final String messageExceptionDecimalLess = "The decimals number can't be less than 0";
	public static final String messageExceptionNumberSame = "The min and max numbers can't be the same";
	public static final String messageExceptionMinMax = "The min number must be less than max number";
	public static final String messageExceptionArray = "The array values can't be empty";
	public static final String messageExceptionFormula = "The formula can't be empty";
	public static final String messageExceptionMyList = "The my list name can't be empty";
	public static final String messageExceptionValue = "The regular expression value can't be empty";
	public static final String messageExceptionStartLess = "The start number can't be less than 1";
	public static final String messageExceptionStepLess = "The step number can't be less than 1";
	public static final String messageExceptionRepeatLess = "The repeat number can't be less than 1";
	public static final String messageExceptionValueTemplate = "The value template can't be empty";

	/**
	 * Create a JSONObject
	 * @param pname Column name
	 * @param pType {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionMyList 
	 */
	JSONObject createJSONObjectMyList(String name, String type, String myListName) 
			throws MockarooExceptionName, MockarooExceptionMyList;
	
	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param value Expression value
	 * @param type {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionRegExpValue 
	 */
	JSONObject createJSONObjectRegExp(String name, String value, String type) 
			throws MockarooExceptionName, MockarooExceptionRegExpValue;
	
	
	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param min Minimum sentences
	 * @param maxs Maximum sentences
	 * @param type {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionNumber 
	 */
	JSONObject createJSONObjectSentences(String name, int min, int max, String type)
			throws MockarooExceptionName, MockarooExceptionNumber;
	
	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param start The first number in the sequence
	 * @param step The number to add to each subsequent value
	 * @param repeat The number of times each value should occur before the step amount is added.
	 * @param type {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionNumber
	 */
	JSONObject createJSONObjectSequence(String name, int start, int step, int repeat, String type)
			throws MockarooExceptionName, MockarooExceptionNumber;
	
	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param value Templates allow you to incorporate values from other columns by surrounding column names 
	 * 	with {braces}. For example, let's say you have a "first_name" column and a "last_name" column. 
		The following template will generate a formatted name where last name comes first:
		{last_name}, {first_name}
	 * @param type {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionValue 
	 */
	JSONObject createJSONObjectTemplate(String name, String value, String type)
			throws MockarooExceptionName, MockarooExceptionValue;
	
	/**
	 * Create a JSONObject
	 * @param pname Column name
	 * @param pType {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 */
	JSONObject createJSONObject(String name, String type) throws MockarooExceptionName;
	
	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param min Minimum number
	 * @param max Maximum number
	 * @param decimals Number of decimals
	 * @param type {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionNumber
	 * @throws MockarooExceptionName
	 */
	JSONObject createJSONObject(String name, int min, int max, int decimals, String type)
			throws MockarooExceptionNumber, MockarooExceptionName;

	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param min Minimum number
	 * @param max Maximum number
	 * @param format Format date
	 * @param type {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 */
	JSONObject createJSONObject(String name, String min, String max, String format, String type) 
			throws MockarooExceptionName;

	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param type {@link MockarooType}
	 * @param values {@link JSONArray}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionArray
	 */
	JSONObject createJSONObject(String name, String type, JSONArray values)
			throws MockarooExceptionName, MockarooExceptionArray;
	
	/**
	 * Create a JSONObject 
	 * @param name Column name
	 * @param formula Formula
	 * @param type {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionFormula 
	 */
	JSONObject createJSONObject(String name, String formula, String type) 
			throws MockarooExceptionName, MockarooExceptionFormula;
	
	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param minItems Minimum items
	 * @param maxItems Maximum items
	 * @param type {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionNumber 
	 */
	JSONObject createJSONObject(String name, int minItems, int maxItems, String type)
			throws MockarooExceptionName, MockarooExceptionNumber;
	
	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param minimum Minimum value
	 * @param maximum Maximum value
	 * @param type {@link MockarooType}
	 * @param moneyType {@link MockarooMoneyType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionNumber
	 */
	JSONObject createJSONObject(String name, int min, int max, String type, String moneyType)
			throws MockarooExceptionName, MockarooExceptionNumber;
	
	/**
	 * Create a JSONObject
	 * @param name Column name
	 * @param mean The mean value for the normal distribution
	 * @param sd The standard deviation for the normal distribution
	 * @param decimals The number of decimals places for each generated value
	 * @param type {@link MockarooType}
	 * @return {@link JSONObject}
	 * @throws MockarooExceptionName
	 * @throws MockarooExceptionNumber
	 */
	JSONObject createJSONObject(String name, Double mean, Double sd, int decimals, String type)
			throws MockarooExceptionName, MockarooExceptionNumber;;
}