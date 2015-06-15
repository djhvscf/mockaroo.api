package com.mockaroo.api.interfaces;

import com.mockaroo.api.exceptions.MockarooExceptionPing;

/**
 * Class to ping Mockaroo.com
 * @author Dennis Hernández Vargas
 * @version 1.0.1 - 21/July/2014
 * @since 1.0.1
 */
public interface IMockarooPingHelper {

	static final String urlMockaroo = "http://www.mockaroo.com/";
	static final String messageExceptionPing = "The mockaroo site is down. We can't connect";
	static final int correctResponseCode = 200;
	
	/**
	 * Ping to mockaroo site
	 * @return True if the mockaroo site is up
	 * @throws MockarooExceptionPing
	 */
	void ping() throws MockarooExceptionPing;
}
