package com.nt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class ApacheDBCPJDBCConnectionService implements ConnectionProvider {

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("ApacheDBCPJDBCConnectionService.getConnection()");
		BasicDataSource  bds=new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("system");
		bds.setPassword("manager");
		bds.setMinIdle(10); bds.setMaxIdle(20);
		return  bds.getConnection();
	
	}

	@Override
	public void closeConnection(Connection conn) throws SQLException {
		System.out.println("CustomJDBCConnectionService.closeConnection()");
	   conn.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}
