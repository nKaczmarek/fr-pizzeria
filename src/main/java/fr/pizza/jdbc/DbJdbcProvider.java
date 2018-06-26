package fr.pizza.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DbJdbcProvider implements IDatabaseProvider{

	public static Connection connection;
	
	public DbJdbcProvider(){
		try {
			Class.forName(Config.driver);
			connection = DriverManager.getConnection(Config.dbUrl, Config.user, Config.pwd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityTransaction getEntityTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

}
