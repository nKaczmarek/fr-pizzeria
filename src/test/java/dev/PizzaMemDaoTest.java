package dev;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fr.pizza.dao.PizzaMemDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {

	private PizzaMemDao pDao;
	
	@Before
	public void setUp()
	{
		pDao = new PizzaMemDao();
	}
	
	@Test
	public void testPizzaMemDao() {
		assertFalse(pDao.findAllPizzas().isEmpty());
	}

	@Test
	public void testFindAllPizzas() {
		assertTrue(pDao.findAllPizzas().size() == 8);
	}

	@Test
	public void testSaveNewPizza() {
		int nbPizza = pDao.findAllPizzas().size();
		pDao.saveNewPizza(new Pizza("TEST","test test", 12.2, CategoriePizza.SANS_VIANDE));
		assertTrue(nbPizza < pDao.findAllPizzas().size());
	}

	@Test
	public void testUpdatePizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePizza() {
		int nbPizza = pDao.findAllPizzas().size();
		pDao.deletePizza("PEP");
		assertTrue(nbPizza > pDao.findAllPizzas().size());
	}

	@Test
	public void testFindPizzaByCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testPizzaExists() {
		assertTrue(pDao.pizzaExists("PEP"));
		assertFalse(pDao.pizzaExists(""));
	}

}
