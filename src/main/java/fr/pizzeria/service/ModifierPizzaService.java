package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizza.dao.PizzaMemDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService{

	public ModifierPizzaService()
	{
		super();
	}
	
	@Override
	public void executeUC(Scanner scan, PizzaMemDao pizzaMemDao) {
		// TODO Auto-generated method stub
		System.out.println("Entrez le code de la pizza à modifier :");
		String code = scan.next();
		System.out.println("Entrez le nouveau code :");
		String nCode = scan.next();
		System.out.println("Entrez le nouveau libelle :");
		String nLibelle = scan.next();
		System.out.println("Entrez le nouveau prix :");
		double nPrix = scan.nextDouble();
		System.out.println("Entrez la catégorie de la pizza (1.viande/2.poisson/3.sans viande)");
		int categorie = scan.nextInt();
		CategoriePizza nCat;
		switch(categorie)
		{
			case 1:
				nCat = CategoriePizza.VIANDE;
			break;
			case 2:
				nCat = CategoriePizza.POISSON;
			break;
			case 3:
				nCat = CategoriePizza.SANS_VIANDE;
			break;
			default:
				nCat = CategoriePizza.SANS_VIANDE;
			break;
		}
		pizzaMemDao.updatePizza(code, new Pizza(nCode, nLibelle, nPrix, nCat));

	}

}
