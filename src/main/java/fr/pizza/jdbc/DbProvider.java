package fr.pizza.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbProvider {

	public static Connection connection;

	public static void load(){

		Config.load();
		try {
			Class.forName(Config.driver);
			connection = DriverManager.getConnection(Config.dbUrl, Config.user, Config.pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		return connection;
	}

	public static void closeConnection()
	{
		try {
			connection.close();
		} catch( SQLException e) {
			e.printStackTrace();
		}
	}

}
