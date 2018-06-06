package fr.pizzeria.factory;

import java.util.Scanner;

import fr.pizza.dao.PizzaMemDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.ListerPizzasService;
import fr.pizzeria.service.ModifierPizzaService;
import fr.pizzeria.service.SupprimerPizzaService;

public class MenuServiceFactory {

	Scanner scan;
	PizzaMemDao pizzaMemDao;
	ListerPizzasService listerPizza;
	AjouterPizzaService ajouterPizza;
	ModifierPizzaService modifierPizza;
	SupprimerPizzaService supprimerPizza;
	
	public MenuServiceFactory()
	{
		scan = new Scanner(System.in);
		pizzaMemDao = new PizzaMemDao();
		listerPizza = new ListerPizzasService();
		ajouterPizza = new AjouterPizzaService();
		modifierPizza = new ModifierPizzaService();
		supprimerPizza = new SupprimerPizzaService();
	}
	
	public void askMenu()
	{
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}
	
	public void start() throws StockageException
	{
		askMenu();
		useFactory(scan.nextInt());
	}
	
	public void useFactory(int menu) throws StockageException
	{

			switch(menu)
			{
				case 1:
					listerPizza.executeUC(scan, pizzaMemDao);
					start();
				break;
				case 2:
					ajouterPizza.executeUC(scan, pizzaMemDao);
					start();
				break;
				case 3:
					modifierPizza.executeUC(scan, pizzaMemDao);	
					start();
				break;
				case 4:
					listerPizza.executeUC(scan, pizzaMemDao);
					supprimerPizza.executeUC(scan, pizzaMemDao);
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
