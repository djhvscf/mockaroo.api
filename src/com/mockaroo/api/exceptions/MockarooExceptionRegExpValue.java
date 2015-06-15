package com.mockaroo.api.exceptions;

/**
 * Throw when the regular expression value is not correct
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 12/July/2014
 * @since 0.1.0
 */
public class MockarooExceptionRegExpValue extends MockarooException {

	private static final long serialVersionUID = -1536155730128282563L;

	public MockarooExceptionRegExpValue(String message) {
		super(message);
	}
}
