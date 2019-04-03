package service;
import java.util.Scanner;
import dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao pizza) {
		// TODO Auto-generated method stub
		System.out.println("1. Lister les pizzas");
		Pizza[] pizzas = pizza.findAllNewPizzas();
		for (Pizza pi : pizzas) {
			if (pi != null) {
				System.out.println(pi);
			}
		}
	}

}
