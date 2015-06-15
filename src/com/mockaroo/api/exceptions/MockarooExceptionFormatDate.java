package com.mockaroo.api.exceptions;

/**
 * Throw when the format date is not correct
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 17/July/2014
 * @since 0.1.0
 */
public class MockarooExceptionFormatDate extends MockarooException{

	private static final long serialVersionUID = 8628355048097022943L;

	public MockarooExceptionFormatDate(String message) {
		super(message);
	}
}