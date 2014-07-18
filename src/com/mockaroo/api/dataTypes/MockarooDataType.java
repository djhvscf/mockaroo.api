package com.mockaroo.api.dataTypes;

import org.json.JSONObject;

import com.mockaroo.api.helpers.MockarooValidatorHelper;
import com.mockaroo.api.interfaces.IMockarooDataType;

public abstract class MockarooDataType implements IMockarooDataType {

	protected static MockarooValidatorHelper validator = new MockarooValidatorHelper();

	@Override
	public abstract String getType();

	@Override
	public abstract JSONObject getJSONObject();
}