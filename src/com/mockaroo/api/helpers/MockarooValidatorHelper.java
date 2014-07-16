package com.mockaroo.api.helpers;

import com.mockaroo.api.enums.MockarooTimeType;
import com.mockaroo.api.exceptions.MockarooExceptionFormatTime;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.exceptions.MockarooExceptionNumber;
import com.mockaroo.api.exceptions.MockarooExceptionValue;
import com.mockaroo.api.interfaces.IValidatorHelper;

/**
 * Class to validate some things - Helper class
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 12/July/2014
 */
public class MockarooValidatorHelper implements IValidatorHelper {

	@Override
	public void validateColumnName(String name, String messageException) throws MockarooExceptionName
	{
		if(name.isEmpty())
		{
			throw new MockarooExceptionName(messageException);
		}
	}
	
	@Override
	public void validateNumber(int number, String messageException) throws MockarooExceptionNumber
	{
		if(number < 0)
		{
			throw new MockarooExceptionNumber(messageException);
		}
	}

	@Override
	public void validateNumber(Double number, String messageException)
			throws MockarooExceptionNumber {
		
		if (number < 0)
		{
			throw new MockarooExceptionNumber(messageException);
		}
	}

	@Override
	public void validateNumber(int number, int numberValidator,
			String messageException) throws MockarooExceptionNumber {
		
		if(number < numberValidator)
		{
			throw new MockarooExceptionNumber(messageException);
		}		
	}

	@Override
	public void validateNumber(Double number, int numberValidator,
			String messageException) throws MockarooExceptionNumber {
		
		if(number < numberValidator)
		{
			throw new MockarooExceptionNumber(messageException);
		}
	}

	@Override
	public void validateNumberEquals(int number, int numberValidator,
			String messageException) throws MockarooExceptionNumber {
	
		if(number == numberValidator)
		{
			throw new MockarooExceptionNumber(messageException);
		}
	}

	@Override
	public void validateNumberEquals(Double number, Double numberValidator,
			String messageException) throws MockarooExceptionNumber {
		if(number == numberValidator)
		{
			throw new MockarooExceptionNumber(messageException);
		}
	}

	@Override
	public void validateString(String value, String messageException) throws MockarooExceptionValue {
		
		if(value.isEmpty())
		{
			throw new MockarooExceptionValue(messageException);
		}
	}

	@Override
	public void validateTimeFormat(String value, String messageException)
			throws MockarooExceptionFormatTime {
		
		boolean isValidFormatTime = false;
		MockarooTimeType.values();
		
		for(MockarooTimeType timeType : MockarooTimeType.values())
		{
	        if(value == timeType.getTimeType())
	        {
	        	isValidFormatTime = true;
	        }
	    }
		
		if(!isValidFormatTime)
		{
			throw new MockarooExceptionFormatTime(messageException);
		}
	}
}