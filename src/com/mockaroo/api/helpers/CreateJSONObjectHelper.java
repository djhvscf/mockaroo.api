package com.mockaroo.api.helpers;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionFormula;
import com.mockaroo.api.exceptions.MockarooExceptionMyList;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;
import com.mockaroo.api.exceptions.MockarooExceptionRegExpValue;
import com.mockaroo.api.interfaces.ICreateJSONObjectHelper;

/**
 * Class to create a specific JSONObject - Helper class
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 09/July/2014
 */
public class CreateJSONObjectHelper implements ICreateJSONObjectHelper {
	
	private ValidatorHelper validator = new ValidatorHelper();
	
	@Override
	public JSONObject createJSONObject(String name, String type) throws MockarooExceptionName 
	{
		validator.validateColumnName(name, messageExceptionName);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);

		return jsonObject;
	}
	
	@Override
	public JSONObject createJSONObject(String name, String type, JSONArray values) 
			throws MockarooExceptionName, MockarooExceptionArray
	{
		validator.validateColumnName(name, messageExceptionName);
		
		if(values.length() == 0)
		{
			throw new MockarooExceptionArray(messageExceptionArray);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);
		jsonObject.put("values", values);
		
		return jsonObject;
	}
	
	@Override
	public JSONObject createJSONObject(String name, String min, String max, String format) 
			throws MockarooExceptionName 
	{
		validator.validateColumnName(name, messageExceptionName);
		
		if(min.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionMinDate);
		}
		
		if(max.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionMaxDate);
		}
		
		if(format.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionFormatDate);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", MockarooType.Date.toString());
		jsonObject.put("min", min);
		jsonObject.put("max", max);
		jsonObject.put("format", format);
		
		return jsonObject;
	}
	
	@Override
	public JSONObject createJSONObject(String name, int min, int max, int decimals) 
													throws MockarooExceptionNumber, MockarooExceptionName 
	{
		validator.validateColumnName(name, messageExceptionName);
		
		validator.validateNumber(min, messageExceptionMinLess);
		
		validator.validateNumber(max, messageExceptionMaxLess);
		
		validator.validateNumber(decimals , messageExceptionDecimalLess);
		
		validator.validateNumberEquals(min, max, messageExceptionNumberSame);
		
		validator.validateNumber(max, min, messageExceptionMinMax);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", MockarooType.Number.toString());
		jsonObject.put("min", min);
		jsonObject.put("max", max);
		jsonObject.put("decimals", decimals);

		return jsonObject;
	}

	@Override
	public JSONObject createJSONObject(String name, String formula, String type)
			throws MockarooExceptionName, MockarooExceptionFormula 
	{
		validator.validateColumnName(name, messageExceptionName);
		
		if(formula.isEmpty())
		{
			throw new MockarooExceptionFormula(messageExceptionFormula);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);
		jsonObject.put("formula", formula);
		
		return jsonObject;
	}

	@Override
	public JSONObject createJSONObject(String name, int minItems, int maxItems, String type)
			throws MockarooExceptionName, MockarooExceptionNumber {

		validator.validateColumnName(name, messageExceptionName);
		
		validator.validateNumber(minItems, messageExceptionMaxLess);
		
		validator.validateNumber(maxItems, messageExceptionMaxLess);
		
		validator.validateNumberEquals(minItems, maxItems, messageExceptionNumberSame);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);
		jsonObject.put("minItems", minItems);
		jsonObject.put("maxItems", maxItems);
		
		return jsonObject;
	}

	@Override
	public JSONObject createJSONObject(String name, int min, int max,
			String type, String moneyType) throws MockarooExceptionName, MockarooExceptionNumber 
	{
		
		validator.validateColumnName(name, messageExceptionName);
		
		validator.validateNumber(min, messageExceptionMaxLess);
		
		validator.validateNumber(max, messageExceptionMaxLess);
		
		validator.validateNumberEquals(min, max, messageExceptionNumberSame);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);
		jsonObject.put("min", min);
		jsonObject.put("max", max);
		jsonObject.put("symbol", moneyType);
		
		return jsonObject;
	}

	@Override
	public JSONObject createJSONObjectMyList(String name, String type,
			String myListName) throws MockarooExceptionName, MockarooExceptionMyList 
	{
		validator.validateColumnName(name, messageExceptionName);
		
		if(myListName.isEmpty())
		{
			throw new MockarooExceptionMyList(messageExceptionMyList);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);
		jsonObject.put("list", myListName);
		
		return jsonObject;
	}

	@Override
	public JSONObject createJSONObject(String name, Double mean, Double sd,
			int decimals, String type) throws MockarooExceptionName, MockarooExceptionNumber {
		
		validator.validateColumnName(name, messageExceptionName);
		
		validator.validateNumber(mean, messageExceptionMeanLess);
		
		validator.validateNumber(decimals, messageExceptionDecimalLess);
		
		validator.validateNumber(sd, 1, messageExceptionSdLess);
		
		validator.validateNumber(decimals, messageExceptionDecimalLess);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);
		jsonObject.put("mean", mean);
		jsonObject.put("sd", sd);
		
		return jsonObject;
	}

	@Override
	public JSONObject createJSONObjectRegExp(String name, String value, String type) 
			throws MockarooExceptionName, MockarooExceptionRegExpValue {
		
		validator.validateColumnName(name, messageExceptionName);
		
		if(value.isEmpty())
		{
			throw new MockarooExceptionRegExpValue(messageExceptionValue);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);
		jsonObject.put("value", value);
		
		return jsonObject;
	}

	@Override
	public JSONObject createJSONObjectSentences(String name, int min, int max,
			String type) throws MockarooExceptionName, MockarooExceptionNumber {
		
		validator.validateColumnName(name, messageExceptionName);
		
		validator.validateNumber(min, messageExceptionMinLess);
		
		validator.validateNumber(max, messageExceptionMaxLess);
		
		validator.validateNumberEquals(min, max, messageExceptionNumberSame);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);
		jsonObject.put("min", min);
		jsonObject.put("max", max);
		
		return jsonObject;
	}
}