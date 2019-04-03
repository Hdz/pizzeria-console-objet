package fr.pizzeria.service;
import java.util.Scanner;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao memPizza) {
		Scanner sc = new Scanner(System.in);
		String coderecup;
		System.out.println("4. Supprimer une Pizza");
		System.out.println("Quel code souhaitez vous supprimer ?");
		coderecup = sc.nextLine();
		memPizza.deletePizza(coderecup);
	}

}
