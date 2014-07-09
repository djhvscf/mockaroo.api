package com.mockaroo.api.classes;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionArray;
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
}
