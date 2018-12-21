package br.com.marlan.db;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class DBConnectERP {
	
	private static String server = "10.100.2.1";
    private static String database = "dbsystex";
    
//    private String server = "192.168.1.9";
//    String database = "TESTE";
    
    private static String user = "systextil";
    private static String passwd = "oracle";
    private static Connection con = null;
	
	public static Connection getInstance() throws SQLException {
		if(con == null || con.isClosed()) {
			OracleDataSource ods = new OracleDataSource();
			ods.setUser(user);
			ods.setPassword(passwd);
			ods.setServerName(server);
			ods.setPortNumber(1521);
			ods.setServiceName(database);
			ods.setDriverType("thin");
			con = ods.getConnection();
		}
		return con;
	}
	
	public static void closeConnection() throws SQLException {
		if (!con.isClosed()) {
			con.close();
		}
	}
	
}
