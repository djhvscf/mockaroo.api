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
public class MockarooUrl implements IUrl{

	private static MockarooUrl instance = null;
	private String key;
	private String contentType;
	
	/**
	 * Default constructor.
	 * Applying singleton
	 */
	private MockarooUrl(String key, String contentType)
	{
		this.setKey(key);
		this.setContentType(contentType);
	}
	
	/**
	 * Method that help with creation of url object
	 * @return {@link MockarooUrl} Object
	 */
	public static MockarooUrl getInstance(String key, String contentType) 
	{
      if(instance == null) 
      {
         instance = new MockarooUrl(key, contentType);
      }
      return instance;
	}
	
	public String getKey() {
		return key;
	}

	public String getContentType() {
		return contentType;
	}

	private void setKey(String key) {
		this.key = key;
	}

	private void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public HttpURLConnection openConnecion() throws MalformedURLException, Exception, IOException 
	{
		if(this.getKey().isEmpty())
		{
			throw new NullPointerException("Api key is null; please provide Mackroo API key");
		}
		
		if(this.getContentType().isEmpty())
		{
			throw new NullPointerException("Content type is null; please provide content type");
		}
		
		return createConnection(this.getKey(), this.getContentType());
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