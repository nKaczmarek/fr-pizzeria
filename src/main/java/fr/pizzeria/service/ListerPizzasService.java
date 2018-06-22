package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;
import fr.pizza.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {

	public ListerPizzasService() {
		super();
	}

	@Override
		public void executeUC(Scanner s, IPizzaDao pizzaMemDao) throws StockageException {
			List<Pizza> pizzas = pizzaMemDao.findAllPizzas();
			
			
			for(Pizza pizza: pizzas)
			{
				System.out.println(pizza.getPizza());
			}
			
		}
}
