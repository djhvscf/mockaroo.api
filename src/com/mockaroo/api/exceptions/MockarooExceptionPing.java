package com.mockaroo.api.exceptions;

/**
 * Throw when the ping is not success
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 17/July/2014
 * @since 0.1.0
 */
public class MockarooExceptionPing  extends MockarooException {

	private static final long serialVersionUID = 8018157517385691591L;

	public MockarooExceptionPing(String message) {
		super(message);
	}
}