package fr.pizzeria.model;

public class Pizza {

	private int id;
	private String code;
	private String libelle;
	private double prix;
	private CategoriePizza categoriePizza;
	
	private static int id_inc = 0;
	public Pizza(String code, String libelle, double prix, CategoriePizza categoriePizza)
	{
		
		this.setId(id_inc);
		this.setCode(code);
		this.setLibelle(libelle);
		this.setPrix(prix);
		this.setCategoriePizza(categoriePizza);
		id_inc++;
	}
	
	public Pizza(int id,String code, String libelle, double prix, CategoriePizza categoriePizza)
	{
		id_inc = id;
		this.setId(id);
		this.setCode(code);
		this.setLibelle(libelle);
		this.setPrix(prix);
		this.setCategoriePizza(categoriePizza);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String getPizza()
	{
		return getId() + " " + getCode() + " -> " + getLibelle() + " (" + getPrix() + ")";
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}
	
}
