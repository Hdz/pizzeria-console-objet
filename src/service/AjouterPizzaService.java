package service;
import java.util.Scanner;
import dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaService extends MenuService{
	@Override
	public void executeUC(Scanner scanner, PizzaMemDao pizza) {
		Scanner sc = new Scanner(System.in);
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("Veuillez saisir le code :");
		String coderecup = sc.nextLine();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String nomrecup = sc.nextLine();

		System.out.println("Veuillez saisir le prix :");
		String prixrecup = sc.nextLine();
		Double prixrecup2 = Double.parseDouble(prixrecup);
		Pizza nouv = new Pizza(coderecup,nomrecup,prixrecup2);
		pizza.saveNewPizza(nouv);
		
	}

}
