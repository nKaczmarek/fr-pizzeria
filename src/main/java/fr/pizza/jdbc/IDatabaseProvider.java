package fr.pizza.jdbc;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public interface IDatabaseProvider {

	public void closeConnection();
	public Connection getConnection();
	public EntityManager getEntityManager();
	public EntityTransaction getEntityTransaction();
	
}
