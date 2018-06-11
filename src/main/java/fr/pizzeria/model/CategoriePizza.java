package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE("viande"),
	POISSON("poisson"),
	SANS_VIANDE("sans viande");
	
	private String categoriePizza;
	
	private CategoriePizza(String s)
	{
		this.categoriePizza = s;
	}
	
	public CategoriePizza getCategorie(int i)
	{
		if(i == 1)
			return VIANDE;
		else if(i == 2)
			return POISSON;
		else
			return SANS_VIANDE;
	}
}
