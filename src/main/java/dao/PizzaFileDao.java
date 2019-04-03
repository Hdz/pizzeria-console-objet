package dao;

import java.io.Serializable;

import fr.pizzeria.model.*;

public class PizzaFileDao implements IPizzaDao{

	private Pizza[] pizzas;
	
	public PizzaFileDao() {
		Pizza p1 = new Pizza(0,"PEP","Pépéroni",12.50,CategoriePizza.VIANDE);
		Pizza p2 = new Pizza(1,"MAR","Margherita",14.00,CategoriePizza.SANS_VIANDE);
		Pizza p3 = new Pizza(2,"REIN","La Reine",11.50,CategoriePizza.SANS_VIANDE);
		Pizza p4 = new Pizza(3,"FRO","La 4 fromages",12.00,CategoriePizza.SANS_VIANDE);
		Pizza p5 = new Pizza(4,"CAN","La cannibale",12.50,CategoriePizza.VIANDE);
		Pizza p6 = new Pizza(5,"SAV","La savoyarde",13.00,CategoriePizza.SANS_VIANDE);
		Pizza p7 = new Pizza(6,"ORI","L'orientale",13.50,CategoriePizza.VIANDE);
		Pizza p8 = new Pizza(7,"IND","L'indienne",14.00,CategoriePizza.VIANDE); 
		pizzas = new Pizza[100];
		pizzas[0]=p1;pizzas[1]=p2;pizzas[2]=p3;pizzas[3]=p4;pizzas[4]=p5;pizzas[5]=p6;pizzas[6]=p7;pizzas[7]=p8;
	}
	
	@Override
	public Pizza[] findAllNewPizzas() {
		return this.pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		int idx =  premierNull(pizzas);
		pizzas[idx]=pizza;
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for(Pizza pi : pizzas) {
			if(pi != null && pi.getCode().equals(codePizza)) {
				pi = pizza;
			}
		}
		
	}

	@Override
	public void deletePizza(String codePizza) {
		for(Pizza pi : pizzas) {
			if(pi != null && pi.equals(findPizzaByCode(codePizza))){
				pi=null;
			}
		}
		System.out.println("pizza supprimé !");
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		for(Pizza pi : pizzas) {
			if(pi != null && pi.getCode().equals(codePizza)) {
				return pi;
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		boolean b =false;
		for(Pizza pi : pizzas) {
			if(pi != null && pi.getCode().equals(codePizza)) {
				b = true;
				break;
			}
		}
		System.out.println("Aucune pizza ne correpond à ce code !");
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