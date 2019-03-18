package fr.pizzeria.model;

public class Pizza {
	int id;
	String code;
	String libelle;
	double prix;
	int cpt;

public Pizza (String code, String libelle, double prix) {
	cpt++;
	this.id=cpt;
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