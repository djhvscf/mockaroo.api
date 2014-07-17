package com.mockaroo.api.helpers;

import java.net.HttpURLConnection;
import java.net.URL;

import com.mockaroo.api.exceptions.MockarooExceptionPing;

/**
 * Class to ping Mockaroo.com
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 17/July/2014
 */
public class MockarooPingHelper {
	
	private static final String urlMockaroo = "http://www.mockaroo.com/";
	private static final String messageExceptionPing = "The mockaroo site is down. We can't connect";
	
	/**
	 * Ping to mockaroo site
	 * @return True if the mockaroo site is up
	 * @throws MockarooExceptionPing
	 */
	public static boolean pingStatus() throws MockarooExceptionPing
	{
		boolean result = false;
        try 
        {
            HttpURLConnection connection = (HttpURLConnection) new URL(urlMockaroo).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() == 200) 
            {
                result = true;
            }else
            {
            	throw new MockarooExceptionPing(messageExceptionPing);
            }
            
        } 
        catch (Exception e) 
        {
        	throw new MockarooExceptionPing(messageExceptionPing);
        }
        
        return result;
	}

}
