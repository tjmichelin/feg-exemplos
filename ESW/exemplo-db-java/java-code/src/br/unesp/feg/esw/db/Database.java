package br.unesp.feg.esw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Database {
	private String dbUrl;
	private Connection conn;

	protected void init(String url, String user, String password) throws SQLException {
		this.dbUrl = url;
		this.connect(user, password);
	}

	public void connect(String user, String password) throws SQLException {
		this.conn = DriverManager.getConnection(dbUrl, user, password);
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() {
		try {
			this.conn.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
