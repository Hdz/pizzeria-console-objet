package fr.pizzeria.model;
import java.lang.reflect.*;
import fr.pizzeria.utils.*;
/**
 * @author DROUAUD
 *
 */
public class Pizza {
	private int id;
	@ToString(upper = true)
	private String code;
	@ToString(upper = true)
	private String libelle;
	@ToString(upper = false)
	private double prix;
	private static int cpt = 1;
	@ToString(upper = true)
private CategoriePizza catPizza;

	/**
	 * @param code
	 * @param libelle
	 * @param prix
	 * @param catPizza 
	 */
	public Pizza(String code, String libelle, double prix, CategoriePizza catPizza) {
		Pizza.cpt++;
		this.id = Pizza.cpt;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.catPizza = catPizza;
	}

	/**
	 * @param id
	 * @param code
	 * @param libelle
	 * @param prix
	 */
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza catPizza) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.catPizza = catPizza;
	}

	
	public String toString() {
		String chaine = "";
		Class classe = getClass();
		Field[] fields = classe.getDeclaredFields();

		for (Field attribut: fields){

			if (attribut.isAnnotationPresent(ToString.class)){

				

				ToString annotation = attribut.getAnnotation(ToString.class);

				

				boolean uppercase = annotation.upper();

				String before = annotation.before();

				String after = annotation.after();

				

				try {

					chaine+=before;

					if (uppercase){

						chaine+=attribut.get(this).toString().toUpperCase();

					}

					else {

						chaine+=attribut.get(this);

					}

					chaine+=after;

					

				} catch (IllegalArgumentException | IllegalAccessException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				} 

			}

		}

		return chaine;
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
	public double getPrix() {
		return prix;

	}
	
}