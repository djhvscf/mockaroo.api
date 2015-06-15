package com.mockaroo.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mockaroo.api.exceptions.MockarooExceptionValue;
import com.mockaroo.api.helpers.MockarooDataAccessHelper;
import com.mockaroo.api.helpers.MockarooValidatorHelper;
import com.mockaroo.api.interfaces.IMockarooDataAccessHelper;
import com.mockaroo.api.interfaces.IMockarooValidatorHelper;

/**
 * Data access layer
 * @author Dennis Hernández Vargas
 * @version 1.0.0 - 19/July/2014
 * @since 1.0.0
 */
public class MockarooDataAccess {

	private String driverClassName;
    private String url;
    private String username; 
    private String password;
    private IMockarooValidatorHelper validator = MockarooValidatorHelper.getInstance();
    private IMockarooDataAccessHelper mockarooDataAccessHelper;
	public static final String messageExceptionDriver = "The driver class name can't be empty";
	public static final String messageExceptionUrl = "The url server can't be empty";
	public static final String messageExceptionUsername = "The password can't be empty";
	public static final String messageExceptionPassword = "The password can't be empty";
    
    /**
     * Default constructor
     * @param driverClassName Driver class name
     * @param url Server url
     * @param username User name
     * @param password User password
     * @throws MockarooExceptionValue 
     */
    public MockarooDataAccess(String driverClassName, String url, String username, String password) 
    		throws MockarooExceptionValue
    {
    	validator.validateString(driverClassName, messageExceptionDriver);
    	validator.validateString(url, messageExceptionUrl);
    	validator.validateString(username, messageExceptionUsername);
    	validator.validateString(password, messageExceptionPassword);
    	
    	mockarooDataAccessHelper = MockarooDataAccessHelper.getInstance();
    	this.setDriverClassName(driverClassName);
    	this.setUrl(url);
    	this.setUsername(username);
    	this.setPassword(password);
    }
    
    /**
     * Create a Connection with database
     * @return {@link Connection}
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    protected Connection getConnection() throws ClassNotFoundException, SQLException
    {
    	Class.forName(this.getDriverClassName());
        return DriverManager.getConnection(this.getUrl(),this.getUsername(), this.getPassword());
    }
    
    /**
     * Return driver class name
     * @return Driver class name
     */
    private String getDriverClassName() {
		return driverClassName;
	}

    /**
     * Return the url server
     * @return Url server
     */
    private String getUrl() {
		return url;
	}

    /**
     * Return the user name
     * @return User name
     */
    private String getUsername() {
		return username;
	}

    /**
     * Return the user password
     * @return User password
     */
    private String getPassword() {
		return password;
	}

    /**
     * Set the drvier class name
     * @param driverClassName The fully qualified name of the desired class 
     */
    private void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

    /**
     * Set the url
     * @param url Server url
     */
    private void setUrl(String url) {
		this.url = url;
	}

    /**
     * Set the user name
     * @param username User name
     */
    private void setUsername(String username) {
		this.username = username;
	}

    /**
     * Set the user password
     * @param password User password
     */
    private void setPassword(String password) {
		this.password = password;
	}
	
    /**
     * Insert a JSONObject into a database
     * @param tableName Table name 
     * @param jsonObject {@link JSONObject}
     * @param values Columns
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	public void Insert(String tableName, JSONObject jsonObject, String[] values) 
			throws ClassNotFoundException, SQLException
	{
		mockarooDataAccessHelper.Insert(tableName, jsonObject, values, this.getConnection());
	}
	
	/**
     * Insert a JSONArray into a database
     * @param tableName Table name 
     * @param jsonArray {@link JSONArray}
     * @param values Columns
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	public void Insert(String tableName, JSONArray jsonArray, String[] values)
			throws ClassNotFoundException, SQLException
	{
		mockarooDataAccessHelper.Insert(tableName, jsonArray, values, this.getConnection());
	}
}