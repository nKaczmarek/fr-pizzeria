package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizza.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {
	
	public abstract void executeUC(Scanner s, PizzaMemDao pizzaMemDao) throws StockageException;
	
}
