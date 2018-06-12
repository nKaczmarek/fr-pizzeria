package dev;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizza.dao.PizzaMemDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.service.AjouterPizzaService;

public class AjouterPizzaServiceTest {

	private AjouterPizzaService service;
	private PizzaMemDao pDao;
	private Scanner scan;
	
	@Rule
	public TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();
	
	@Before
	public void setUp()
	{
		service = new AjouterPizzaService();
		pDao = new PizzaMemDao();
		scan = new Scanner(System.in);
	}
	
	@Test
	public void testExecuteUC() {
		try {
			systemInMock.provideLines("TEST", "TESTJUNIT", "12.00", "1");
			service.executeUC(scan, pDao);
			assertTrue(pDao.findPizzaByCode("TEST") != null);
		} catch (SavePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test (expected=NumberFormatException.class)
	public void testExecuteUCExceptionPrixNotNumber() {
		try {
			systemInMock.provideLines("TEST", "TESTJUNIT", "fdsss", "1");
			service.executeUC(scan, pDao);
		} catch (SavePizzaException e) {

		}
	}
	
	@Test (expected=SavePizzaException.class)
	public void testExecuteUCExceptionPrixInferieurZero() throws SavePizzaException {

			systemInMock.provideLines("TEST", "TESTJUNIT", "-5", "1");
			service.executeUC(scan, pDao);


	}
	
}
