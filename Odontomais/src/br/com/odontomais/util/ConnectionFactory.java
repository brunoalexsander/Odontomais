package br.com.odontomais.util;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/odontomais";
			String user = "root";
			String password = "vertrigo";
			return DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}