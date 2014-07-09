package com.mockaroo.api.classes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.mockaroo.api.interfaces.IUrl;

/**
 * Class to create a connection to Mockaroo site
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 09/July/2014
 */
public class Url implements IUrl{

	private static Url instance = null;
	
	/**
	 * Default constructor.
	 * Applying singleton
	 */
	private Url()
	{}
	
	/**
	 * Method that help with creation of url object
	 * @return {@link Url} Object
	 */
	public static Url getInstance() 
	{
      if(instance == null) 
      {
         instance = new Url();
      }
      return instance;
	}
	
	@Override
	public HttpURLConnection openConnecion(String papiKey,  String pcontentType) 
													throws MalformedURLException, Exception, IOException 
	{
		if(papiKey.isEmpty())
		{
			throw new NullPointerException("Api key is null; please provide Mackroo API key");
		}
		
		if(pcontentType.isEmpty())
		{
			throw new NullPointerException("Content type is null; please provide content type");
		}
		
		return createConnection(papiKey, pcontentType);
	}
	
	/**
	 * Create a connection with api key and content type
	 * @param papiKey Mockaroo api key
	 * @param pcontentType Content type
	 * @return {@link HttpURLConnection}
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private HttpURLConnection createConnection(String papiKey, String pcontentType) 
			throws MalformedURLException, IOException
	{
		HttpURLConnection conn = (HttpURLConnection)(new URL(urlMockaroo + papiKey)).openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", pcontentType);
		
		return conn;
	}
}