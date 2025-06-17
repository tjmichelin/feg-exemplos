package br.unesp.feg.esw.db;

import java.sql.SQLException;

public class PostgresqlDB extends Database {
	private final String jdbc = "jdbc:postgresql";
	
	/**
	 * Instruções sobre como se conectar ao banco de dados utilizando o conector para PostgreSQL estão
	 * disponíveis na documentação oficial: https://jdbc.postgresql.org/documentation/use/
	 */
	public PostgresqlDB (String host, int port, String dbName, String dbuser, String dbPassword) throws SQLException {
		String dbUrl = String.format("%s://%s:%d/%s", this.jdbc, host, port, dbName);
		this.init(dbUrl, dbuser, dbPassword);
	}
}
