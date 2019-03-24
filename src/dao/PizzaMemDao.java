package dao;

import fr.pizzeria.model.Pizza;
import java.io.Serializable;
import fr.pizzeria.model.*;

public class PizzaMemDao implements IPizzaDao {

	private Pizza[] pizzas;

	// 1 Instanciation des pizzas, on créer un tableau avec 100 entréees, pour ajouter les pizzas que l'on veut

	public PizzaMemDao() {
		Pizza p1 = new Pizza(0,"PEP","Pepperoni",12.50,CategoriePizza.SANS_VIANDE);
		Pizza p2 = new Pizza(1,"MAR","Margherita",14.00,CategoriePizza.SANS_VIANDE);
		Pizza p3 = new Pizza(2,"REI","La Reine",11.50,CategoriePizza.VIANDE);
		Pizza p4 = new Pizza(3,"FRO","La 4 fromages",12.00,CategoriePizza.SANS_VIANDE);
		Pizza p5 = new Pizza(4,"CAN","La Cannibale",12.50,CategoriePizza.VIANDE);
		Pizza p6 = new Pizza(5,"SAV","La Savoyarde",13.00,CategoriePizza.VIANDE);
		Pizza p7 = new Pizza(6,"ORI","L'Orientale",13.50,CategoriePizza.VIANDE);
		Pizza p8 = new Pizza(7,"IND","L'Indienne",14.00,CategoriePizza.VIANDE); 
		pizzas = new Pizza[100];
		pizzas[0]=p1;pizzas[1]=p2;pizzas[2]=p3;pizzas[3]=p4;pizzas[4]=p5;pizzas[5]=p6;pizzas[6]=p7;pizzas[7]=p8;
	}
	//2 Méthode qui va retourner la liste de pizzas
	@Override
	public Pizza[] findAllNewPizzas() {

		return pizzas;
	}

	//3 Méthode qui va sauvegarder une nouvelle pizza

	@Override
	public void saveNewPizza(Pizza pizza) {
		int idx =  premierNull(pizzas);
		pizzas[idx]=pizza;
		}

	
	// 4 Méthode qui va mettre à jour une pizza dans la liste.
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for(int j=0; j<pizzas.length; j++) {
			if(pizzas[j].getCode().equals(codePizza)) {
				pizzas[j].setCode(pizza.getCode());
				pizzas[j].setLibelle(pizza.getLibelle());
				pizzas[j].setPrix(pizza.getPrix());
				break;
			}


		} 
	}
	// 5 Méthode qui va supprimer la pizza
	@Override
	public void deletePizza(String codePizza) {
		for (int j = 0; j < pizzas.length; j++) {
			if (pizzas[j].getCode().equals(codePizza)) {
				pizzas[j] = null;
				break;
			}
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for(Pizza pi : pizzas) {
			if(pi != null && pi.getCode().equals(codePizza)) {
				return pi;
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		boolean b =false;
		for(Pizza pi : pizzas) {
			if(pi != null && pi.getCode().equals(codePizza)) {
				b = true;
				break;
			}


		}
		return b;
	}
	private static int premierNull(Pizza [] pizza) {
		for(int i = 0; i<pizza.length;i++) {
			if(pizza[i] == null) {
				return i;
			}
		}
		return -1;
	}
}