package fr.pizzeria.service;
import java.util.Scanner;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.exception.*;

public class AjouterPizzaService extends MenuService{
	@Override
	public void executeUC(Scanner scanner, IPizzaDao memPizza) throws StockageException {
		// TODO Auto-generated method stub
				System.out.println("Ajout d'une nouvelle pizza");
				System.out.println("Veuillez saisir le code :");
				String	code = scanner.nextLine();
				System.out.println(code.length());
				if (code.length() != 3) {
					throw new SavePizzaException("Veuillez saisir un code de 3 lettres");
				}
				if(memPizza.pizzaExists(code) == true) {
					throw new SavePizzaException("Code existant, veuillez rentrez un autre code");
				}
				System.out.println("Veuillez saisir le nom :");
				String nom = scanner.nextLine();
				System.out.println("Veuillez saisir le prix :");
				String prixstr = scanner.nextLine();
				double prix = Double.parseDouble(prixstr);
				if(prix < 0 || prix > 30) {
					throw new SavePizzaException("Merci de donner un prix positif et inf�rieur � 30");
				}
				
				System.out.println("Veuillez choisir le categorie de pizza : Viande, Poisson ou Sans Viande");
				String cat = scanner.nextLine();
				CategoriePizza cate = CategoriePizza.recupCat(cat);
				Pizza nouv = new Pizza(code, nom, prix, cate);
				memPizza.saveNewPizza(nouv);
		
	}

}
