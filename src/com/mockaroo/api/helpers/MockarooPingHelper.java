package com.mockaroo.api.helpers;

import java.net.HttpURLConnection;
import java.net.URL;

import com.mockaroo.api.exceptions.MockarooExceptionPing;
import com.mockaroo.api.interfaces.IMockarooPingHelper;

/**
 * Class to ping Mockaroo.com
 * @author Dennis Hernández Vargas
 * @version 0.1.0 - 17/July/2014
 * @since 0.1.0
 */
public class MockarooPingHelper implements IMockarooPingHelper {
	
	
	private static MockarooPingHelper instance = null;
	
	/**
	 * Default constructor
	 * Applying singleton
	 */
	private MockarooPingHelper(){}
	
	/**
	 * Get a {@link MockarooPingHelper} object
	 * @return {@link MockarooPingHelper}
	 */
	public static MockarooPingHelper getInstance()
	{
		if(instance == null)
		{
			instance = new MockarooPingHelper();
		}
		
		return instance;
	}
	
	
	@Override
	public void ping() throws MockarooExceptionPing
	{
        try 
        {
            HttpURLConnection connection = (HttpURLConnection) new URL(urlMockaroo).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() != correctResponseCode) 
            {
            	throw new MockarooExceptionPing(messageExceptionPing);
            }
        } 
        catch (Exception e) 
        {
        	throw new MockarooExceptionPing(messageExceptionPing);
        }
	}
}