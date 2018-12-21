package br.com.marlan.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.marlan.db.DBConnectERP;

public class Dao {
	
	private Connection conn = null;
	
	public Dao() {
		try {
			this.setConn(DBConnectERP.getInstance());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
