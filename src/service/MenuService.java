package service;
import java.util.Scanner;
import dao.PizzaMemDao;
import fr.pizzeria.model.Pizza;


public abstract class MenuService {
public abstract	void executeUC(Scanner scanner, PizzaMemDao pizza);

}
