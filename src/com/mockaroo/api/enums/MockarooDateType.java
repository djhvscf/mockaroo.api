package com.mockaroo.api.enums;

/**
 * Enum that provide the mockaroo date type
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 16/July/2014
 * @since 0.1.0
 */
public enum MockarooDateType {

		/**
		 * Year with century (can be negative, 4 digits at least)
		 * 0001, 0000, 1995, 2009, 14292, etc.
		 */
		Y("%Y"),
	  
	  /**
	   * year / 100 (round down.  20 in 2009)
	   */
	  C("%C"),
      
      /**
       *  year % 100 (00..99)
       */
      y("%y"),
      
      /**
       *  Month of the year, zero-padded (01..12)
       *  %_m  blank-padded ( 1..12)
       *  %-m  no-padded (1..12)
       */
      m("%m"),
      
      /**
       * The full month name (``January'')
       * %^B  uppercased (``JANUARY'')
       */
      B("%B"),

      /**
       * The abbreviated month name (``Jan'')
       * %^b  uppercased (``JAN'')
       */
      b("%b"),
 
      /**
       * Equivalent to %b
       */
      h("%h"),

      /**
       * Day of the month, zero-padded (01..31)
       * %-d  no-padded (1..31)
       */
      d("%d"),
      
      /**
       * Day of the month, blank-padded ( 1..31)
       */
      e("%e"),

      /**
       * Day of the year (001..366)
       */
      j("%j");
	  
	  	private String dateType;
		
		/**
		 * Constructor
		 * @param DateType Date type in the mockaroo format
		 */
		private MockarooDateType(final String dateType)
		{
			this.dateType = dateType;
		}
		
		/**
		 * Gets the dateType String
		 * @return Date type
		 */
		public String getDateType()
		{
			return this.dateType;
		}
}
