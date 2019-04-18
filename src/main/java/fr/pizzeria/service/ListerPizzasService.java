package fr.pizzeria.service;
import java.util.List;
import java.util.Scanner;

import dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, IPizzaDao Pizzabdd) {

		System.out.println("Liste pizzas"); 	
		List<Pizza> pizzas = Pizzabdd.findAllNewPizzas();
		affiche(pizzas);
	}

	private static void affiche(List<Pizza> pizzas) {
		for (Pizza pi : pizzas) {
			if (pi != null) {
				System.out.println(pi);
			}

		}
	}

}