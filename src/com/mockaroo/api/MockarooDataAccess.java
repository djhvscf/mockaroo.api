package com.mockaroo.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data access layer
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 16/July/2014
 */
public class MockarooDataAccess {

	private String driverClassName;
    private String url;
    private String username; 
    private String password;
    
    /**
     * Default constructor
     * @param driverClassName Driver class name
     * @param url Server url
     * @param username User name
     * @param password User password
     */
    public MockarooDataAccess(String driverClassName, String url, String username, String password)
    {
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
     * insert the data into the database
     * @param sql String with the sql statement
     * @return True -> Was inserted, False -> An error ocurred
     * @throws ClassNotFoundException
     * @throws SQLException
     */
	protected boolean Insert(String sql) throws ClassNotFoundException, SQLException
	{
		Statement statement;
		statement = this.getConnection().createStatement();
		return !statement.execute(sql);
	}
}
