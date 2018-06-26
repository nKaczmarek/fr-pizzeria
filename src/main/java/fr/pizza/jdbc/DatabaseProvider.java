package fr.pizza.jdbc;

public class DatabaseProvider {

	private static IDatabaseProvider iDatabaseProvider;

	public static void load() {
		Config.load();

		try {
			Class<?> useProvider = Class.forName(Config.provider);
			setiDatabaseProvider((IDatabaseProvider) useProvider.getConstructor().newInstance());
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static IDatabaseProvider getDatabaseProvider() {
		return iDatabaseProvider;
	}

	public static void setiDatabaseProvider(IDatabaseProvider iDatabaseProvider) {
		DatabaseProvider.iDatabaseProvider = iDatabaseProvider;
	}
	
}
