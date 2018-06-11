package fr.pizza.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao{

	private List<Pizza> pizzaList;
	
	public PizzaMemDao()
	{
		pizzaList = new ArrayList<Pizza>();
		
		pizzaList.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		pizzaList.add(new Pizza("REIN", "La reine", 11.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzaList.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		pizzaList.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		return pizzaList;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		pizzaList.add(pizza);
		System.out.println("Pizza ajouté");
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		if(pizzaExists(codePizza))
		{
			int cpt = 0;
			boolean find = false;
			while(!find && cpt < pizzaList.size())
			{
				if(pizzaList.get(cpt) == findPizzaByCode(codePizza))
				{
					pizzaList.set(cpt, pizza);
					System.out.println("Pizza mis à jour");
					find = true;
				}
				cpt++;
			}	
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		boolean del = false;
		
		for(int i = 0; i < pizzaList.size(); i++)
		{
			if(!del && pizzaList.get(i) == findPizzaByCode(codePizza))
			{
				pizzaList.remove(i);
				del = true;
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		if(pizzaExists(codePizza))
		{
			int cpt = 0;
			while(cpt < pizzaList.size())
			{
				if(pizzaList.get(cpt).getCode().equals(codePizza))
					return pizzaList.get(cpt);			
				cpt++;
			}		
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean exist = false;
		int cpt = 0;
		while(!exist && cpt < pizzaList.size())
		{
			String debug = pizzaList.get(cpt).getCode();
			if(debug.equals(codePizza))
				return true;			
			cpt++;
		}
		System.out.println("La pizza n'existe pas");
		return false;
	}

}
