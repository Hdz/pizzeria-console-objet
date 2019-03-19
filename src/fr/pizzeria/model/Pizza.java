package fr.pizzeria.model;

/**
 * @author DROUAUD
 *
 */
public class Pizza {
	Pizza pizza;
	private int id;
	private String code;
	private String libelle;
	private double prix;
	private static int cpt;


	/**
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza (String code, String libelle, double prix) {
	Pizza.cpt++;
	this.id=Pizza.cpt;
	this.code=code;
	this.libelle=libelle;
	this.prix=prix;	
}

	/**
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, double prix) {
	this.id=id;
	this.code=code;
	this.libelle=libelle;
	this.prix=prix;
	}



	


/**
 * @return
 */
public int getId() {
	return id;
}

/**
 * @param id
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @param code
 */
public void setCode(String code) {
	this.code = code;
}

/**
 * @param libelle
 */
public void setLibelle(String libelle) {
	this.libelle = libelle;
}

/**
 * @param prix
 */
public void setPrix(double prix) {
	this.prix = prix;
}

/**
 * @return code
 */
public String getCode() {
	return code;
}

/**
 * @return libelle
 */
public String getLibelle() {
	return libelle;
}
/**
 * @return prix
 */
public double  getPrix() {
	return prix;

}
}