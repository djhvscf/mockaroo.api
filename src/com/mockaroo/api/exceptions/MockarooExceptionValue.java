package com.mockaroo.api.exceptions;

/**
 * Throw when the value string is empty or null
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 13/July/2014
 */
public class MockarooExceptionValue extends MockarooException {

	private static final long serialVersionUID = -7321304439812457748L;

	public MockarooExceptionValue(String message) {
		super(message);
	}
}