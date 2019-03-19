package dao;

import fr.pizzeria.model.Pizza;

public class PizzaMemDao implements IPizzaDao {

	private Pizza[] pizzas;
	
// 1 Instanciation des pizzas, on créer un tableau avec 100 entrées, pour ajouter les pizzas que l'on veut
	public PizzaMemDao() {
		pizzas = new Pizza[100];
		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		pizzas[4] = new Pizza("CAN", "La cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00);
	}
	//2 Méthode qui va retourner la liste de pizzas
	@Override
	public Pizza[] findAllNewPizzas() {
		
		return pizzas;
	}

//3 Méthode qui va sauvegarder une nouvelle pizza
	
	@Override
	public void saveNewPizza(Pizza pizza) {
		for (int i = 0; i < pizzas.length; i++) {
			if (pizzas[i] == null) {
				pizzas[i] = pizza;
				break;
			}
		}

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
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		return false;
	}


}
