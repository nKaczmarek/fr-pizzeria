package fr.pizza.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizza.jdbc.DatabaseProvider;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaJpaDao implements IPizzaDao {

	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public PizzaJpaDao() {
		entityManager = DatabaseProvider.getDatabaseProvider().getEntityManager();
		entityTransaction = DatabaseProvider.getDatabaseProvider().getEntityTransaction();
	}

	@Override
	public List<Pizza> findAllPizzas() {
		TypedQuery<Pizza> pizzas = entityManager.createQuery("FROM Pizza p", Pizza.class);
		return pizzas.getResultList();
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		if (pizzaExists(pizza.getCode())) {
			entityTransaction.begin();
			Pizza p = new Pizza();
			p.setCode(pizza.getCode());
			p.setLibelle(pizza.getLibelle());
			p.setPrix(pizza.getPrix());
			p.setCategoriePizza(pizza.getCategoriePizza());

			entityManager.persist(p);
			entityTransaction.commit();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		if (pizzaExists(codePizza)) {
			entityTransaction.begin();
			Pizza p = findPizzaByCode(codePizza);
			p.setCode(pizza.getCode());
			p.setLibelle(pizza.getLibelle());
			p.setPrix(pizza.getPrix());
			p.setCategoriePizza(pizza.getCategoriePizza());

			entityManager.persist(p);
			entityTransaction.commit();
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		if (pizzaExists(codePizza)) {
			entityTransaction.begin();
			Query query = entityManager.createQuery("DELETE FROM Pizza p WHERE p.code = :code");
			query.setParameter("code", codePizza);
			query.executeUpdate();
			entityTransaction.commit();
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		TypedQuery<Pizza> pizzas = entityManager.createQuery("FROM Pizza p WHERE p.code = :code", Pizza.class);
		pizzas.setParameter("code", codePizza);
		return pizzas.getSingleResult();
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		if (findPizzaByCode(codePizza) != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void initPizza() {
		entityTransaction.begin();
		Query query = entityManager.createNativeQuery("TRUNCATE TABLE pizzas");
		query.executeUpdate();
		entityTransaction.commit();
		
		entityTransaction.begin();
		Pizza p1 = new Pizza();
		p1.setCode("PEP");
		p1.setLibelle("Peperoni");
		p1.setPrix(12.0);
		p1.setCategoriePizza(CategoriePizza.SANS_VIANDE);
		entityManager.persist(p1);
		
		Pizza p2 = new Pizza();
		p2.setCode("PEP2");
		p2.setLibelle("Peperoni");
		p2.setPrix(12.0);
		p2.setCategoriePizza(CategoriePizza.SANS_VIANDE);
		entityManager.persist(p2);
		
		Pizza p3 = new Pizza();
		p3.setCode("PEP3");
		p3.setLibelle("Peperoni");
		p3.setPrix(12.0);
		p3.setCategoriePizza(CategoriePizza.SANS_VIANDE);
		entityManager.persist(p3);
		
		Pizza p4 = new Pizza();
		p4.setCode("PEP4");
		p4.setLibelle("Peperoni");
		p4.setPrix(12.0);
		p4.setCategoriePizza(CategoriePizza.SANS_VIANDE);
		entityManager.persist(p4);
		
		Pizza p5 = new Pizza();
		p5.setCode("PEP5");
		p5.setLibelle("Peperoni");
		p5.setPrix(12.0);
		p5.setCategoriePizza(CategoriePizza.SANS_VIANDE);
		entityManager.persist(p5);
		
		Pizza p6 = new Pizza();
		p6.setCode("PEP6");
		p6.setLibelle("Peperoni");
		p6.setPrix(12.0);
		p6.setCategoriePizza(CategoriePizza.SANS_VIANDE);
		entityManager.persist(p6);
		
		entityTransaction.commit();	
		
		
	}

}
