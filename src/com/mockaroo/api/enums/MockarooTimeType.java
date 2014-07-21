package com.mockaroo.api.enums;

/**
 * Enum that provide the mockaroo type time
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 13/July/2014
 * @since 0.1.0
 */
public enum MockarooTimeType {

	/**
	 * Hour of the day, 24-hour clock, zero-padded (00..23)
	 */
	H("%H"),
	
	/**
	 * Hour of the day, 24-hour clock, blank-padded ( 0..23)
	 */
	K("%K"),
	
	/**
	 * Hour of the day, 12-hour clock, zero-padded (01..12)
	 */
	T("%T"),
	
	/**
	 * Hour of the day, 12-hour clock, blank-padded ( 1..12)
	 */
	l("%l"),
	
	/**
	 * Meridian indicator, lowercase (``am'' or ``pm'')
	 */
	P("%P"),
	
	/**
	 * Meridian indicator, uppercase (``AM'' or ``PM'')
	 */
	p("%p"),
	
	/**
	 * Minute of the hour (00..59)
	 */
	M("%M"),
	
	/**
	 * Second of the minute (00..60)
	 */
	S("%S"),
	
	/**
	 * Millisecond of the second (000..999)
	 */
	L("%L"),
	
	/**
	 * UNSOPORTED <br>
	 * Fractional seconds digits, default is 9 digits (nanosecond) <br>
	 * %3N  millisecond (3 digits) <br>
	 * %6N  microsecond (6 digits) <br>
	 * %9N  nanosecond (9 digits) <br>
	 * %12N picosecond (12 digits) <br>
	 */
	N("%N");

	private String timeType;
	
	/**
	 * Constructor
	 * @param Timetype Time type in the mockaroo format
	 */
	private MockarooTimeType(final String Timetype)
	{
		this.timeType = Timetype;
	}
	
	/**
	 * Gets the timeType String
	 * @return Time type
	 */
	public String getTimeType()
	{
		return this.timeType;
	}
}