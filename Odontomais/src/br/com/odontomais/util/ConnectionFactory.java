package br.com.odontomais.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbName = "localhost"; // nome do banco
			String dbPort = "3306"; // porta de acesso do banco
			String dbSchema = "odontomais";
			String dbUserName = "root"; //nome do usúario do banco de dados
			String dbPassword = "root"; //senha do banco de dados
			String dbUrl = "jdbc:mysql://" + dbName + ":" + dbPort + "/" + dbSchema + "?useTimezone=true&serverTimezone=UTC"; //url do banco
			return DriverManager.getConnection(dbUrl, dbUserName, dbPassword); //variável de conexão
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}