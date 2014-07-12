package com.mockaroo.api.classes;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
import com.mockaroo.api.exceptions.MockarooExceptionFormula;
import com.mockaroo.api.exceptions.MockarooExceptionMyList;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;
import com.mockaroo.api.interfaces.ICreateJSONObject;

/**
 * Class to create a specific JSONObject - Helper class
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 09/July/2014
 */
public class CreateJSONObjectHelper implements ICreateJSONObject {
	
	@Override
	public JSONObject createJSONObject(String name, String type) throws MockarooExceptionName
	{
		if(name.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionName);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);

		return jsonObject;
	}
	
	@Override
	public JSONObject createJSONObject(String name, String type, JSONArray values) 
			throws MockarooExceptionName, MockarooExceptionArray
	{
		if(name.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionName);
		}
		
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
		if(name.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionName);
		}
		
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
		if(name.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionName);
		}
		
		if(min < 0)
		{
			throw new MockarooExceptionNumber(messageExceptionMinLess);
		}
		
		if(max < 0)
		{
			throw new MockarooExceptionNumber(messageExceptionMaxLess);
		}
		
		if(decimals < 0)
		{
			throw new MockarooExceptionNumber(messageExceptionDecimalLess);
		}
		
		if(min == max)
		{
			throw new MockarooExceptionNumber(messageExceptionNumberSame);
		}
		
		if(max < min)
		{
			throw new MockarooExceptionNumber(messageExceptionMinMax);
		}
		
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
		if(name.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionName);
		}
		
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

		if(minItems < 0)
		{
			throw new MockarooExceptionNumber(messageExceptionMinLess);
		}
		
		if(maxItems < 0)
		{
			throw new MockarooExceptionNumber(messageExceptionMaxLess);
		}
		
		if(minItems == maxItems)
		{
			throw new MockarooExceptionNumber(messageExceptionNumberSame);
		}
		
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
		
		if(name.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionName);
		}
		
		if(min < 0)
		{
			throw new MockarooExceptionNumber(messageExceptionMinLess);
		}
		
		if(max < 0)
		{
			throw new MockarooExceptionNumber(messageExceptionMaxLess);
		}
		
		if(min == max)
		{
			throw new MockarooExceptionNumber(messageExceptionNumberSame);
		}
		
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
		if(name.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionName);
		}
		
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
		
		if(name.isEmpty())
		{
			throw new MockarooExceptionName(messageExceptionName);
		}
		
		if(mean < 0)
		{
			throw new MockarooExceptionNumber(messageExceptionMeanLess);
		}
		
		if(sd < 1)
		{
			throw new MockarooExceptionNumber(messageExceptionSdLess);
		}
		
		if(decimals < 0)
		{
			throw new MockarooExceptionNumber(messageExceptionDecimalLess);
		}
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("type", type);
		jsonObject.put("mean", mean);
		jsonObject.put("sd", sd);
		
		return jsonObject;
	}
}