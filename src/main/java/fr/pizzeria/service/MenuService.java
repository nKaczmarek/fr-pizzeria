package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {

	public abstract void executeUC(Scanner scan, IPizzaDao pizzaDao) throws StockageException;
	{
		
	}

}
