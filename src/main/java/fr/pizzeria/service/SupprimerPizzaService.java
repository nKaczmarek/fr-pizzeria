package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;
import fr.pizza.dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;

public class SupprimerPizzaService extends MenuService{

	public SupprimerPizzaService()
	{
		super();
	}

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaDao) throws StockageException {
		// TODO Auto-generated method stub
		System.out.println("Saisir le code de la pizza à supprimer :");
		String code = scan.next();
		pizzaDao.deletePizza(code);
		System.out.println("Pizza Supprimé !!");
	}

}
