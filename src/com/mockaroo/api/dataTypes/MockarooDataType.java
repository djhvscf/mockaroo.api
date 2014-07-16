package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.helpers.ValidatorHelper;
import com.mockaroo.api.interfaces.IMockarooDataType;

public abstract class MockarooDataType implements IMockarooDataType {

	protected static ValidatorHelper validator = new ValidatorHelper();

	@Override
	public abstract String getType();

	@Override
	public abstract JSONObject getJSONObject();
}