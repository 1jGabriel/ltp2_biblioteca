package br.com.projeto.biblioteca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String login = "root";
	private static final String senha = "";
	
	public static Connection getConnection() {  
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/ltp2_biblioteca", login, senha);
		}
		catch(SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return con;

	}
}

