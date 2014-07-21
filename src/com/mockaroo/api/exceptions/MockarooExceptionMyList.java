package com.mockaroo.api.exceptions;

/**
 * Throw when my list name provided is null or empty
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 12/July/2014
 * @since 0.1.0
 */
public class MockarooExceptionMyList extends MockarooException {

	private static final long serialVersionUID = 4772261623861747999L;

	public MockarooExceptionMyList(String message) {
		super(message);
	}

}
