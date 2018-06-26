package fr.pizza.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pizza.jdbc.DbJdbcProvider;

public class PizzaJdbcDaoTest {
	
	private PizzaJdbcDao pDao;
	
	@Before
	public void setUp()
	{
		DbJdbcProvider.load();
		pDao = new PizzaJdbcDao();
	}
	
	@After
	public void setDown()
	{
		DbJdbcProvider.closeConnection();
	}
	
	@Test
	public void testFindAllPizzas() {
		assertTrue(pDao.findAllPizzas() != null);
		
	}

	@Test
	public void testSaveNewPizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPizzaByCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testPizzaExists() {
		fail("Not yet implemented");
	}

}
