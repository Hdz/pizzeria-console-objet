package fr.pizzeria.service;
import java.util.Scanner;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, IPizzaDao memPizza) {
		// TODO Auto-generated method stub
		System.out.println("Liste pizzas"); 	
		Pizza[] pizzas = memPizza.findAllNewPizzas();

		affiche(pizzas);
	}

	private static void affiche(Pizza[] pizza) {
		for (Pizza pi : pizza) {
			if (pi != null) {
				System.out.println(pi);
			}

		}
	}

}