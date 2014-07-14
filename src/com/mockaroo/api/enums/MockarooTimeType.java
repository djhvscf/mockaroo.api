package com.mockaroo.api.enums;

public enum MockarooTimeType {

	H("%H"),//Hour of the day, 24-hour clock, zero-padded (00..23)
	K("%K"),//Hour of the day, 24-hour clock, blank-padded ( 0..23)
	T("%T"),//Hour of the day, 12-hour clock, zero-padded (01..12)
	l("%l"),//Hour of the day, 12-hour clock, blank-padded ( 1..12)
	P("%P"),//Meridian indicator, lowercase (``am'' or ``pm'')
	p("%p"),//Meridian indicator, uppercase (``AM'' or ``PM'')
	M("%M"),//Minute of the hour (00..59)
	S("%S"),//Second of the minute (00..60)
	L("%L"),//Millisecond of the second (000..999)
	N("%N");//Fractional seconds digits, default is 9 digits (nanosecond)
	          /*%3N  millisecond (3 digits)
	          %6N  microsecond (6 digits)
	          %9N  nanosecond (9 digits)
	          %12N picosecond (12 digits)*/

	private String timeType;
	
	private MockarooTimeType(final String Timetype)
	{
		this.timeType = Timetype;
	}
	
	public String getTimeType()
	{
		return this.timeType;
	}
}