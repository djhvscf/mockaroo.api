package com.mockaroo.api.interfaces;

import org.json.JSONObject;

public interface IMockarooDataType {

	static final String messageExceptionName = "The column name can't be empty";
	static final String messageExceptionMinDate = "The min date can't be empty";
	static final String messageExceptionMaxDate = "The max date can't be empty";
	static final String messageExceptionFormatDate = "The format date can't be empty";
	static final String messageExceptionMinLess = "The min number can't be less than 0";
	static final String messageExceptionMeanLess = "The mean number can't be less than 0";
	static final String messageExceptionSdLess = "The sd number can't be less than 1";
	static final String messageExceptionMaxLess = "The max number can't be less than 0";
	static final String messageExceptionDecimalLess = "The decimals number can't be less than 0";
	static final String messageExceptionNumberSame = "The min and max numbers can't be the same";
	static final String messageExceptionMinMax = "The min number must be less than max number";
	static final String messageExceptionArray = "The array values can't be empty";
	static final String messageExceptionFormula = "The formula can't be empty";
	static final String messageExceptionMyList = "The my list name can't be empty";
	static final String messageExceptionValue = "The regular expression value can't be empty";
	static final String messageExceptionStartLess = "The start number can't be less than 1";
	static final String messageExceptionStepLess = "The step number can't be less than 1";
	static final String messageExceptionRepeatLess = "The repeat number can't be less than 1";
	static final String messageExceptionValueTemplate = "The value template can't be empty";
	static final String messageExceptionMinTime = "The minimum time can't be empty";
	static final String messageExceptionMaxTime = "The maximum time can't be empty";

	
	abstract String getType();
	abstract JSONObject getJSONObject();
}
