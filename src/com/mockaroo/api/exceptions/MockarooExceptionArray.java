package com.mockaroo.api.exceptions;

/**
 * Throw when array values are null, or the array value has length == 0
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 09/July/2014
 */
public class MockarooExceptionArray extends MockarooException{

	private static final long serialVersionUID = -7651250517747167061L;

	public MockarooExceptionArray(String message) {
		super(message);
	}
}