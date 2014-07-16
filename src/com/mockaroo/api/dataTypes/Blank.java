package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;

public class Blank extends MockarooDataType {

	private static Blank instance = null;
	private String columnName;
	
	private Blank(String columnName)
	{
		setColumnName(columnName);
	}
	
	public static Blank getInstance(String columnName) throws MockarooExceptionName
	{
		validator.validateColumnName(columnName, messageExceptionName);
		
		if(instance == null)
		{
			instance = new Blank(columnName);
		}
		
		return instance;
	}

	@Override
	public String getType() 
	{
		return MockarooType.Blank.toString();
	}
	
	private void setColumnName(String columnName) 
	{
		this.columnName = columnName;
	}
	
	private String getColumnName()
	{
		return this.columnName;
	}

	@Override
	public JSONObject getJSONObject() 
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", this.getColumnName());
		jsonObject.put("type", this.getType());

		return jsonObject;
	}
}