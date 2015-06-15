package com.mockaroo.api.exceptions;

/**
 * Throw when is invalid received a JSONArray because the count parameter is less than 0 
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 16/July/2014
 * @since 0.1.0
 */
public class MockarooExceptionJSONArray extends MockarooException {

	
	private static final long serialVersionUID = -5395681146871802805L;

	public MockarooExceptionJSONArray(String message) {
		super(message);
	}
}