package fr.pizzeria.service;
import java.util.ArrayList;
import java.util.Scanner;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, IPizzaDao Pizzabdd) {
		// TODO Auto-generated method stub
		System.out.println("Liste pizzas"); 	
		ArrayList<Pizza> pizzas = Pizzabdd.findAllNewPizzas();
		System.out.println("ici2");
		affiche(pizzas);
	}

	private static void affiche(ArrayList<Pizza> pizzas) {
		for (Pizza pi : pizzas) {
			if (pi != null) {
				System.out.println(pi);
			}

		}
	}

}