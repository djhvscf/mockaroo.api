package com.mockaroo.api.interfaces;

import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;

/**
 * Interface that provide base methods to validator helper
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 12/July/2014
 */
public interface IValidatorHelper {

	/**
	 * Validate if the column name is null or empty
	 * @param name Column name
	 * @param messageException
	 * @throws MockarooExceptionName
	 */
	void validateColumnName(String name, String messageException) throws MockarooExceptionName;
	
	/**
	 * Validate if the number is less than 0
	 * @param number Number to validate
	 * @param messageException
	 * @throws MockarooExceptionName
	 */
	void validateNumber(int number, String messageException) throws MockarooExceptionNumber;
	
	/**
	 * Validate if the number is less than 0
	 * @param number Number to validate
	 * @param messageException
	 * @throws MockarooExceptionName
	 */
	void validateNumber(Double number, String messageException) throws MockarooExceptionNumber;
	
	/**
	 * Validate if the number is less than number passed by parameter
	 * @param number Number to validate
	 * @param numberValidator Number validator
	 * @param messageException
	 * @throws MockarooExceptionName
	 */
	void validateNumber(int number, int numberValidator, String messageException) throws MockarooExceptionNumber;
	
	/**
	 * Validate if the number is less than number passed by parameter
	 * @param number Number to validate
	 * @param numberValidator Number validator
	 * @param messageException
	 * @throws MockarooExceptionName
	 */
	void validateNumber(Double number, int numberValidator, String messageException) 
			throws MockarooExceptionNumber;

	/**
	 * Validate if the number are equals
	 * @param number Number to validate
	 * @param numberValidator Number validator
	 * @param messageException
	 * @throws MockarooExceptionName
	 */
	void validateNumberEquals(int number, int numberValidator, String messageException) 
			throws MockarooExceptionNumber;
	
	/**
	 * Validate if the number are equals
	 * @param number Number to validate
	 * @param numberValidator Number validator
	 * @param messageException
	 * @throws MockarooExceptionName
	 */
	void validateNumberEquals(Double number, Double numberValidator, String messageException) 
			throws MockarooExceptionNumber;
	
}