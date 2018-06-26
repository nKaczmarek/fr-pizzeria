package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pizzas")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "code")
	private String code;
	@Column(name = "libelle")
	private String libelle;
	@Column(name = "prix", precision = 2)
	private double prix;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "categorie")
	private CategoriePizza categoriePizza;

	private static int id_inc = 0;

	public Pizza() {

	}

	public Pizza(String code, String libelle, double prix, CategoriePizza categoriePizza) {

		this.setId(id_inc);
		this.setCode(code);
		this.setLibelle(libelle);
		this.setPrix(prix);
		this.setCategoriePizza(categoriePizza);
		id_inc++;
	}

	public Pizza(int id, String code, String libelle, double prix, CategoriePizza categoriePizza) {
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

	public String getPizza() {
		return getId() + " " + getCode() + " -> " + getLibelle() + " (" + getPrix() + ")";
	}

	public CategoriePizza getCategoriePizza() {
		return categoriePizza;
	}

	public void setCategoriePizza(CategoriePizza categoriePizza) {
		this.categoriePizza = categoriePizza;
	}

}
