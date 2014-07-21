package com.mockaroo.api.exceptions;

/**
 * Throw when the format time is not correct
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 13/July/2014
 * @since 0.1.0
 */
public class MockarooExceptionFormatTime extends MockarooException {

	private static final long serialVersionUID = 4560312626429769845L;

	public MockarooExceptionFormatTime(String message) {
		super(message);
	}
}