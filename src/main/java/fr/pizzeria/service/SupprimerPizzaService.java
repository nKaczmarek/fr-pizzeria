package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizza.dao.PizzaMemDao;

public class SupprimerPizzaService extends MenuService{

	public SupprimerPizzaService()
	{
		super();
	}
	
	@Override
	public void executeUC(Scanner scan, PizzaMemDao pizzaMemDao) {
		// TODO Auto-generated method stub
		System.out.println("Saisir le code de la pizza à supprimer :");
		String code = scan.next();
		pizzaMemDao.deletePizza(code);
		System.out.println("Pizza Supprimé !!");
	}

}
