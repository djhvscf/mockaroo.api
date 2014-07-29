/**
 * 
 */
package com.mockaroo.api.objects;

import org.json.JSONObject;

import com.mockaroo.api.enums.MockarooType;
import com.mockaroo.api.exceptions.MockarooExceptionName;
import com.mockaroo.api.interfaces.IMockarooObject;

/**
 * URL mockaroo object
 * @author Dennis Hernández Vargas
 * @version 2.0.0 - 27/07/2014
 * @since 2.0.0
 */
public class URL implements IMockarooObject {

	private static URL instance = null;
	private String columnName;
	private boolean includeProtocol;
	private boolean includeHost;
	private boolean includePath;
	private boolean includeQueryString;

	/**
	 * Constructor
	 * @param columnName Column name
	 * @param includeProtocol True to include a protocol in the url
	 * @param includeHost True to include a hostname in the url
	 * @param includePath True to include a path in the url
	 * @param includeQueryString True to include a query string in the url
	 */
	private URL(String columnName, boolean includeProtocol, boolean includeHost, boolean includePath, 
			boolean includeQueryString) {
		this.setColumnName(columnName);
		this.setIncludeProtocol(includeProtocol);
		this.setIncludeHost(includeHost);
		this.setIncludePath(includePath);
		this.setIncludeQueryString(includeQueryString);
	}

	/**
	 * Get the {@link URL} object
	 * @param columnName Column name
	 * @param includeProtocol True to include a protocol in the url
	 * @param includeHost True to include a hostname in the url
	 * @param includePath True to include a path in the url
	 * @param includeQueryString True to include a query string in the url
	 * @return {@link URL} object
	 * @throws MockarooExceptionName 
	 */
	public static URL getInstance(String columnName, boolean includeProtocol, boolean includeHost, boolean includePath, 
			boolean includeQueryString)
			throws MockarooExceptionName {
		VALIDATOR.validateColumnName(columnName, messageExceptionName);
		
		if (instance == null) {
			instance = new URL(columnName, includeProtocol, includeHost, includePath, includeQueryString);
		}

		return instance;
	}

	/**
	 * Get the columnName
	 * @return the columnName
	 */
	private String getColumnName() {
		return columnName;
	}

	/**
	 * Set the columnName
	 * @param columnName the columnName to set
	 */
	private void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * Get the includeProtocol
	 * @return the includeProtocol
	 */
	private boolean isIncludeProtocol() {
		return includeProtocol;
	}

	/**
	 * Get the includeHost
	 * @return the includeHost
	 */
	private boolean isIncludeHost() {
		return includeHost;
	}

	/**
	 * Get the includePath
	 * @return the includePath
	 */
	private boolean isIncludePath() {
		return includePath;
	}

	/**
	 * Get the includeQueryString
	 * @return the includeQueryString
	 */
	private boolean isIncludeQueryString() {
		return includeQueryString;
	}

	/**
	 * Set the includeProtocol
	 * @param includeProtocol the includeProtocol to set
	 */
	private void setIncludeProtocol(boolean includeProtocol) {
		this.includeProtocol = includeProtocol;
	}

	/**
	 * Set the includeHost
	 * @param includeHost the includeHost to set
	 */
	private void setIncludeHost(boolean includeHost) {
		this.includeHost = includeHost;
	}

	/**
	 * Set the includePath
	 * @param includePath the includePath to set
	 */
	private void setIncludePath(boolean includePath) {
		this.includePath = includePath;
	}

	/**
	 * Set the includeQueryString
	 * @param includeQueryString the includeQueryString to set
	 */
	private void setIncludeQueryString(boolean includeQueryString) {
		this.includeQueryString = includeQueryString;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getJSONObject()
	 */
	@Override
	public JSONObject getJSONObject() {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(NAME, this.getColumnName());
		jsonObject.put(TYPE, this.getType());
		jsonObject.put(INCLUDEPROTOCOL, this.isIncludeProtocol());
		jsonObject.put(INCLUDEHOST, this.isIncludeHost());
		jsonObject.put(INCLUDEPATH, this.isIncludePath());
		jsonObject.put(INCLUDEQUERYSTRING, this.isIncludeQueryString());
		
		return jsonObject;
	}

	/* (non-Javadoc)
	 * @see com.mockaroo.api.dataTypes.IMockarooObject#getType()
	 */
	@Override
	public String getType() {
		return MockarooType.URL.toString();
	}
}
