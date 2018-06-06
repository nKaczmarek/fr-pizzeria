package fr.pizzeria.model;

public class Pizza {

	private int id;
	private String code;
	private String libelle;
	private double prix;
	private CategoriePizza categoriePizza;
	
	private static int id_inc = 0;
	public Pizza(String _code, String _libelle, double _prix, CategoriePizza _categoriePizza)
	{
		
		this.setId(id_inc);
		this.setCode(_code);
		this.setLibelle(_libelle);
		this.setPrix(_prix);
		this.setCategoriePizza(_categoriePizza);
		id_inc++;
	}
	
	public Pizza(int _id,String _code, String _libelle, double _prix, CategoriePizza _categoriePizza)
	{
		id_inc = _id;
		this.setId(_id);
		this.setCode(_code);
		this.setLibelle(_libelle);
		this.setPrix(_prix);
		this.setCategoriePizza(_categoriePizza);
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
