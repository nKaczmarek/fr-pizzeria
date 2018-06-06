package fr.pizzeria.console;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.factory.MenuServiceFactory;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		MenuServiceFactory menuServiceFactory = new MenuServiceFactory();

		try {
			menuServiceFactory.start();
		} catch (StockageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
