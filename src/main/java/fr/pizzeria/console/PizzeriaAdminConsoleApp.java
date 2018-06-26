package fr.pizzeria.console;

import fr.pizza.jdbc.DatabaseProvider;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.factory.MenuServiceFactory;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		try {
			DatabaseProvider.load();	
			
			MenuServiceFactory menuServiceFactory = new MenuServiceFactory();
			menuServiceFactory.start();
		} catch (StockageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//DbProvider.closeConnection();
			DatabaseProvider.getDatabaseProvider().closeConnection();
		}

	}

}
