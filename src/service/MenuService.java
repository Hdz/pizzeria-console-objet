package service;
import java.util.Scanner;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;


public abstract class MenuService {
public abstract	void executeUC(Scanner scanner, IPizzaDao memPizza)throws StockageException;

}
