package com.mockaroo.api.exceptions;

/**
 * Throw when column name provided is null or empty
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 09/July/2014
 * @since 0.1.0
 */
public class MockarooExceptionName extends MockarooException {

	private static final long serialVersionUID = -8542073660700164339L;

	public MockarooExceptionName(String message) {
		super(message);
	}
}
