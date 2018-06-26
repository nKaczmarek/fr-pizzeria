package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService{

	public AjouterPizzaService()
	{
		super();
	}

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaDao) throws StockageException {
		System.out.println("Entrez le code de la pizza :");
		String code = scan.next();
		System.out.println("Entrez le libellé de la pizza (sans espace) :");
		String libelle = scan.next();
		System.out.println("Entrez le prix de la pizza :");
		String sPrix = scan.next();
		double prix = 0;
		try {
			prix = Double.parseDouble(sPrix);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
		if(prix < 0)
			throw new SavePizzaException("prix inférieur à 0");
		System.out.println("Entrez la catégorie de la pizza (1.viande/2.poisson/3.sans viande)");
		int categorie = scan.nextInt();
		CategoriePizza cat;
		switch(categorie)
		{
			case 1:
				cat = CategoriePizza.VIANDE;
			break;
			case 2:
				cat = CategoriePizza.POISSON;
			break;
			case 3:
				cat = CategoriePizza.SANS_VIANDE;
			break;
			default:
				cat = CategoriePizza.SANS_VIANDE;
			break;
		}
		
		Pizza p = new Pizza(code, libelle, prix, cat);
		pizzaDao.saveNewPizza(p);
	}
	
}
