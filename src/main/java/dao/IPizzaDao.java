package dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllNewPizzas();
	void saveNewPizza(Pizza pizza) throws SavePizzaException;
	void updatePizza(String codePizza, Pizza pizza);
	void deletePizza(String codePizza);
	Pizza findPizzaByCode(String codePizza);
	boolean pizzaExists(String codePizza);
	


}
