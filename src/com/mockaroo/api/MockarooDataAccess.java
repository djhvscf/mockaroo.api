package com.mockaroo.api;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Data access layer
 * @author Dennis Hernández Vargas
 * @version 0.1.0
 * @since 16/July/2014
 */
public class MockarooDataAccess {

	private Connection connect = null;
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
    
    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
    	Class.forName(this.getDriverClassName());
        return DriverManager.getConnection(this.getUrl(),this.getUsername(), this.getPassword());
    }

	public Connection getConnect() {
		return connect;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	private void setConnect(Connection connect) {
		this.connect = connect;
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
}
