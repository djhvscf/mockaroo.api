package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;

public class Boolean extends MockarooDataType {

	private static Boolean instance = null;
	private String columnName;
	
	private Boolean(String columnName)
	{
		setColumnName(columnName);
	}
	
	public static Boolean getInstance(String columnName)
	{
		if(instance == null)
		{
			instance = new Boolean(columnName);
		}
		
		return instance;
	}

	@Override
	public String getType() {
		return MockarooType.Boolean.toString();
	}

	
	private void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public String getColumnName()
	{
		return this.columnName;
	}

	@Override
	public JSONObject getJSONObject() {
		return null;
	}
}