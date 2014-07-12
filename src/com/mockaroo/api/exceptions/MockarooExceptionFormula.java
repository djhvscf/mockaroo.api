package com.mockaroo.api.exceptions;

/**
 * Throw when formula provided is null or empty
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 12/July/2014
 */
public class MockarooExceptionFormula extends MockarooException {

	private static final long serialVersionUID = 3585009716300503921L;

	public MockarooExceptionFormula(String message) {
		super(message);
	}
}