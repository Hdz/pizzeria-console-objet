package service;
import java.util.Scanner;
import dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;
public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao pizza) {
		Scanner sc = new Scanner(System.in);
		String coderecup;
		System.out.println("4. Supprimer une Pizza");
		System.out.println("Quel code souhaitez vous supprimer ?");
		coderecup = sc.nextLine();
		pizza.deletePizza(coderecup);
	}

}
