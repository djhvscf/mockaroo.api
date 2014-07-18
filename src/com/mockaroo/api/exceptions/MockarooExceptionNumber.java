package com.mockaroo.api.exceptions;

/**
 * Throw when the number format is not correct
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 09/July/2014
 */
public class MockarooExceptionNumber extends MockarooException {

	private static final long serialVersionUID = 8078324175852885852L;

	public MockarooExceptionNumber(String message) {
		super(message);
	}

}
