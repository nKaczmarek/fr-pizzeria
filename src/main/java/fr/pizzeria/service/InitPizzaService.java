package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public class InitPizzaService extends MenuService{

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaDao) throws StockageException {
		pizzaDao.initPizza();
		
	}

}
