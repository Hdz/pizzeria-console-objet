package fr.pizzeria.model;

public class Pizza {
	Pizza pizza;
	int id;
	String code;
	String libelle;
	double prix;
	static int cpt;


public Pizza (String code, String libelle, double prix) {
	Pizza.cpt++;
	this.id=Pizza.cpt;
	this.code=code;
	this.libelle=libelle;
	this.prix=prix;	
}

public Pizza(int id, String code, String libelle, double prix) {
	this.id=id;
	this.code=code;
	this.libelle=libelle;
	this.prix=prix;
	}



	


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public void setCode(String code) {
	this.code = code;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}

public void setPrix(double prix) {
	this.prix = prix;
}

public String getCode() {
	return code;
}

public String getLibelle() {
	return libelle;
}
public double  getPrix() {
	return prix;

}
}