package service;
import java.util.Scanner;
import dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao pizza) {
		Scanner sc = new Scanner(System.in);
		String coderecup, nomrecup, prixrecup;
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("Quel code souhaitez vous modifier ?");
		coderecup = sc.nextLine();
		
		System.out.println("Veuillez mettre à jour le code :");
		String coderecup2 = sc.nextLine();
		
		System.out.println("Veuillez mettre à jour le nom (sans espace)");
		nomrecup = sc.nextLine();
		
		System.out.println("Veuillez mettre à jour le prix :");
		prixrecup = sc.nextLine();
		Double prixrecup21 = Double.parseDouble(prixrecup);
		
		Pizza nouv2 = new Pizza(coderecup2,nomrecup,prixrecup21);
		pizza.updatePizza(coderecup,nouv2);
	}

}
