package com.mockaroo.api.classes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.mockaroo.api.interfaces.IUrl;

public class Url implements IUrl{

	private static Url instance = null;
	
	private Url()
	{}
	
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
		
		return createConnection(papiKey, pcontentType);
	}
	
	private HttpURLConnection createConnection(String papiKey, String pcontentType) throws MalformedURLException, IOException
	{
		HttpURLConnection conn = (HttpURLConnection)(new URL(urlMockaroo + papiKey)).
				openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", pcontentType);
		
		return conn;
	}
}