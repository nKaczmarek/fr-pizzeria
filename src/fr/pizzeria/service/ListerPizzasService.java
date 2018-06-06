package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizza.dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService{

	public ListerPizzasService()
	{
		super();
	}
	
	@Override
	public void executeUC(Scanner scan, PizzaMemDao pizzaMemDao) {
		List<Pizza> p = pizzaMemDao.findAllPizzas();
		for(int i = 0; i < p.size(); i++)
		{
			if(p.get(i) != null)
				System.out.println(p.get(i).getPizza());
		}
			
	}

}
