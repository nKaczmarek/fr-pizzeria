package fr.pizza.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizza.jdbc.DbProvider;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaJdbcDao implements IPizzaDao {

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizzas = new ArrayList<>();
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = DbProvider.getConnection().createStatement();
			result = statement.executeQuery("SELECT * FROM pizzas");
			while (result.next()) {
				pizzas.add(new Pizza(result.getInt("id"), result.getString("code"), result.getString("libelle"),
						result.getDouble("prix"), CategoriePizza.valueOf(result.getString("categorie"))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (result != null)
					result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		if (pizzaExists(pizza.getCode())) {
			PreparedStatement statement = null;
			try {
				statement = DbProvider.getConnection()
						.prepareStatement("INSERT INTO pizzas(code, libelle, prix, categorie) " + "VALUES (?,?,?,?)");
				statement.setString(1, pizza.getCode());
				statement.setString(2, pizza.getLibelle());
				statement.setDouble(3, pizza.getPrix());
				statement.setString(4, pizza.getCategoriePizza().toString());
				statement.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (statement != null) {
						statement.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		} else {
			System.out.println("La pizza avec le code " + pizza.getCode() + "existe déjà !!");
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		if (pizzaExists(codePizza)) {
			PreparedStatement statement = null;
			try {
				statement = DbProvider.getConnection()
						.prepareStatement("UPDATE pizzas SET code=?, libelle=?, prix=?, categorie=? WHERE code=?");
				statement.setString(1, pizza.getCode());
				statement.setString(2, pizza.getLibelle());
				statement.setDouble(3, pizza.getPrix());
				statement.setString(4, pizza.getCategoriePizza().toString());
				statement.setString(5, codePizza);
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else {
			System.out.println("La pizza avec le code "+ pizza.getCode() +"n'existe pas ");
		}
			
	}

	@Override
	public void deletePizza(String codePizza) {
		if (pizzaExists(codePizza)) {
			PreparedStatement statement = null;
			try {
				statement = DbProvider.getConnection().prepareStatement("DELETE FROM pizzas WHERE code = ?");
				statement.setString(1, codePizza);
				statement.executeQuery();
			} catch (SQLException e) {

			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		} 
		else {
			System.out.println("La pizza avec le code " + codePizza + " n'existe pas !!");
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		if (pizzaExists(codePizza)) {
			PreparedStatement statement = null;
			try {
				statement = DbProvider.getConnection().prepareStatement("SELECT * FROM pizzas WHERE code = ?");
				statement.setString(1, codePizza);
				statement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;

	}

	@Override
	public boolean pizzaExists(String codePizza) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = DbProvider.getConnection()
					.prepareStatement("SELECT COUNT(*) as nbPizza FROM pizzas WHERE code = ?");
			statement.setString(1, codePizza);
			rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				System.out.println("La pizza n'existe pas !");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		return false;
	}

	@Override
	public void initPizza() {
		PreparedStatement statement = null;
		List<Pizza> pizzaList = new ArrayList<>();
		pizzaList.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		pizzaList.add(new Pizza("REIN", "La reine", 11.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzaList.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
		try {
			statement = DbProvider.getConnection().prepareStatement("TRUNCATE TABLE pizzas");
			statement.executeQuery();

			for (Pizza p : pizzaList) {
				saveNewPizza(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {

			}
		}

	}

}
