package com.mockaroo.api;

import com.mockaroo.api.classes.MockarooCreateJSONObject;
import com.mockaroo.api.classes.MockarooUrl;
import com.mockaroo.api.interfaces.IUrl;

/**
 * Class base to MockarooApi
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 16/July/2014
 */
public class MockarooApi {

	private final IUrl url;
	private String key;
	private String contentType;
	private final MockarooCreateJSONObject creater;
	
	public MockarooApi(String key, String contentType)
	{
		this.setKey(key);
		this.setContentType(contentType);
		url = MockarooUrl.getInstance(key, contentType);
		creater = new MockarooCreateJSONObject();
	}
	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getKey() {
		return key;
	}

	private void setKey(String key) {
		this.key = key;
	}
	
	public IUrl getUrl() {
		return url;
	}

	public MockarooCreateJSONObject getCreater() {
		return creater;
	}
}
