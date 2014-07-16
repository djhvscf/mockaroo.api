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

	private String driverClassName = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/motorlinkdb";
    private String username = "root"; 
    private String password = "mtrlnk";
    
    public MockarooDataAccess(String driverClassName, String url, String username, String password)
    {
    	this.setDriverClassName(driverClassName);
    	this.setUrl(url);
    	this.setUsername(username);
    	this.setPassword(password);
    }
    
    protected Connection getConnection() throws ClassNotFoundException, SQLException
    {
    	Class.forName(this.getDriverClassName());
        return DriverManager.getConnection(this.getUrl(),this.getUsername(), this.getPassword());
    }
    
    protected String getDriverClassName() {
		return driverClassName;
	}

    protected String getUrl() {
		return url;
	}

    protected String getUsername() {
		return username;
	}

    protected String getPassword() {
		return password;
	}

	private void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	private void setUrl(String url) {
		this.url = url;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	private void setPassword(String password) {
		this.password = password;
	}
	
	protected boolean Insert(String sql) throws ClassNotFoundException, SQLException
	{
		Statement statement;
		statement = this.getConnection().createStatement();
		return !statement.execute(sql);
	}
}
