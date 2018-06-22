package fr.pizzeria.factory;

import java.util.Scanner;

import fr.pizza.dao.IPizzaDao;
import fr.pizza.dao.PizzaJdbcDao;
import fr.pizza.dao.PizzaMemDao;
import fr.pizza.jdbc.Config;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.InitPizzaService;
import fr.pizzeria.service.ListerPizzasService;
import fr.pizzeria.service.ModifierPizzaService;
import fr.pizzeria.service.SupprimerPizzaService;

public class MenuServiceFactory {

	Scanner scan;
	IPizzaDao pizzaDao;
	ListerPizzasService listerPizza;
	AjouterPizzaService ajouterPizza;
	ModifierPizzaService modifierPizza;
	SupprimerPizzaService supprimerPizza;
	InitPizzaService initPizzaService;

	public MenuServiceFactory() {
		scan = new Scanner(System.in);
		if (Config.use.equals("jdbc") || Config.use.equals("cleverCloud")) {
			pizzaDao = new PizzaJdbcDao();
		}
		else {
			pizzaDao = new PizzaMemDao();
		}
		listerPizza = new ListerPizzasService();
		initPizzaService = new InitPizzaService();
		ajouterPizza = new AjouterPizzaService();
		modifierPizza = new ModifierPizzaService();
		supprimerPizza = new SupprimerPizzaService();
	}

	public void askMenu() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("5. Initialiser la base de données (des données peuvent être perdu)");
		System.out.println("99. Sortir");
	}

	public void start() throws StockageException {
		askMenu();
		useFactory(scan.nextInt());
	}

	public void useFactory(int menu) throws StockageException {

		switch (menu) {
		case 1:
			listerPizza.executeUC(scan, pizzaDao);
			start();
			break;
		case 2:
			ajouterPizza.executeUC(scan, pizzaDao);
			start();
			break;
		case 3:
			modifierPizza.executeUC(scan, pizzaDao);
			start();
			break;
		case 4:
			listerPizza.executeUC(scan, pizzaDao);
			supprimerPizza.executeUC(scan, pizzaDao);
			start();
			break;
		case 5:
			initPizzaService.executeUC(scan, pizzaDao);
			start();
			break;
		case 99:
			System.out.println("Oh non :( Au revoir");
			System.exit(0);
			break;
		default:
			System.out.println("Entrez une valeur correct !");
			break;
		}
	}
}
