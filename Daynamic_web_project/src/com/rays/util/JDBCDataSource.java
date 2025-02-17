package com.rays.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSource {
	private static JDBCDataSource dataSource;
	
	private ComboPooledDataSource cpds = null;
	private static ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
	private JDBCDataSource() {
		// TODO Auto-generated constructor stub
	}
	
	public static JDBCDataSource getInstance() throws Exception { 
		if(dataSource == null) {
			
			dataSource = new JDBCDataSource();
			dataSource.cpds = new ComboPooledDataSource();
		try {
		
		dataSource.cpds.setDriverClass(rb.getString("driver"));
		dataSource.cpds.setJdbcUrl(rb.getString("url"));
		dataSource.cpds.setUser(rb.getString("username"));
		dataSource.cpds.setPassword(rb.getString("password"));
		dataSource.cpds.setInitialPoolSize(Integer.parseInt(rb.getString("Min")));
		dataSource.cpds.setMaxPoolSize(Integer.parseInt(rb.getString("Max")));
		dataSource.cpds.setAcquireIncrement(Integer.parseInt(rb.getString("Ai")));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		}
		return dataSource;
		
	}
	public static Connection getConnection() throws SQLException, Exception {
		return getInstance().cpds.getConnection();
	}
	
	
       
	

}