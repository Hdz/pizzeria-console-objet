package service;
import java.util.Scanner;
import dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.exception.*;

public class AjouterPizzaService extends MenuService{
	@Override
	public void executeUC(Scanner scanner, PizzaMemDao pizza) throws SavePizzaException {
		Scanner sc = new Scanner(System.in);
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("Veuillez saisir le code :");
		String coderecup = sc.nextLine();
		System.out.println(coderecup.length());
		if (coderecup.length() < 3 || coderecup.length() > 3) {
			throw new SavePizzaException("Veuillez rentrer un bon code") ;
		}
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nomrecup = sc.nextLine();

		if (nomrecup.length() < 0 && nomrecup.length() > 30) {
			throw new SavePizzaException("Veuillez rentrer un bon nom") ;
		}

		System.out.println("Veuillez saisir le prix :");
		String prixrecup = sc.nextLine();
		Double prixrecup2 = Double.parseDouble(prixrecup);
		Pizza nouv = new Pizza(coderecup,nomrecup,prixrecup2);

		if (prixrecup2 < 0 && prixrecup2 > 30) {
			throw new SavePizzaException("Veuillez rentrer un bon prix") ;
		}
		pizza.saveNewPizza(nouv);
		
	}

}
