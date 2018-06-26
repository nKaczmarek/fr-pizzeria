package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	public ModifierPizzaService() {
		super();
	}

	@Override
	public void executeUC(Scanner scan, IPizzaDao pizzaDao) throws StockageException {
		// TODO Auto-generated method stub
		System.out.println("Entrez le code de la pizza � modifier :");
		String code = scan.next();
		System.out.println("Entrez le nouveau code :");
		String nCode = scan.next();
		System.out.println("Entrez le nouveau libelle :");
		String nLibelle = scan.next();
		System.out.println("Entrez le nouveau prix :");
		String newPrix = scan.next();
		double nPrix = Double.parseDouble(newPrix);
		System.out.println("Entrez la cat�gorie de la pizza (1.viande/2.poisson/3.sans viande)");
		int categorie = scan.nextInt();
		CategoriePizza nCat;
		switch (categorie) {
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
		pizzaDao.updatePizza(code, new Pizza(nCode, nLibelle, nPrix, nCat));

	}

}
