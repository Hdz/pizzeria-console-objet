package fr.pizzeria.console;

import java.util.Scanner;

import dao.PizzaMemDao;
import dao.Pizzabdd;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.MenuFactory;
import fr.pizzeria.service.MenuService;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		Pizzabdd pizza = new Pizzabdd();
		MenuFactory mf = new MenuFactory();
		Scanner sc = new Scanner(System.in);
		String n = "0";

		while (!n.equals("5")) {
			try {
				System.out.println(
						"***PIZZA ADMINISTRATION****\n 1. Lister les pizzas\n 2. Ajouter une nouvelle pizza\n 3. Mettre à jour une pizza\n 4. Supprimer une Pizza\n 5. Sortir");
				n = sc.nextLine();
				switch (n) {

				case "1":
					mf.create("Lister").executeUC(sc, pizza);
					break;

				case"2":
					mf.create("Ajouter").executeUC(sc, pizza);
					break;

				case "3":
					mf.create("Modifier").executeUC(sc, pizza);
					break;

				case "4":
					mf.create("Supprimer").executeUC(sc, pizza);				
					break;

				case "5":
					System.out.println("5. Sortir");
					break;
				default:
					System.out.println("Merci de choisir dans le menu");
				}

			}
		
		catch(NumberFormatException e) {
			n = "0";
		}
		catch(SavePizzaException e) {
			System.out.println(e.getMessage());
		}
		catch(StockageException e) {
			System.out.println(e.getMessage());

		}
	}
		sc.close();
	}
}
