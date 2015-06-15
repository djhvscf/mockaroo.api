package com.mockaroo.api.exceptions;

/**
 * Class base to the mockaroo exception
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 09/July/2014
 * @since 0.1.0
 */
public class MockarooException extends Exception {

	private static final long serialVersionUID = 3884247340374128998L;

	public MockarooException(String message)
	{
		super(message);
	}
}
