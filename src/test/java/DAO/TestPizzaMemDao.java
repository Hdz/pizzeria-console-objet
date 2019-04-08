package DAO;

import org.junit.Assert;
import org.junit.Test;

import dao.PizzaMemDao;

import java.util.ArrayList;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class TestPizzaMemDao {

	@Test
	public void testSavenewPizza() {
		PizzaMemDao pMemdao = new PizzaMemDao();
		ArrayList<Pizza> list1 = new ArrayList<Pizza>();
		list1 = pMemdao.findAllNewPizzas();
		Pizza pizza = new Pizza(8, "VEZ", "VEZUVIO", 12.50, CategoriePizza.SANS_VIANDE);
		pMemdao.saveNewPizza(pizza);
		int i1 = list1.size();
		Assert.assertEquals(i1, list1.size());
	}

	@Test
	public void testupdatenewPizza() {
		PizzaMemDao pMemdao = new PizzaMemDao();
		ArrayList<Pizza> list2 = pMemdao.findAllNewPizzas();
		pMemdao.saveNewPizza(new Pizza(8, "VEZ", "VEZUVIO", 12.50, CategoriePizza.SANS_VIANDE));
		pMemdao.updatePizza("VEZ", new Pizza(3,"FRO","La 4 fromages",12.00,CategoriePizza.SANS_VIANDE));
		for (Pizza p : list2) {
			if (p != null && p.getCode().equals("FRO")) {
				Assert.assertTrue(p.getLibelle().equals("La 4 fromages"));
				Assert.assertTrue(p.getPrix() == 12.00);
				Assert.assertTrue(p.getcP() == CategoriePizza.SANS_VIANDE);
			}
		}
	}


	@Test
	public void testdeletenewPizza() {
		PizzaMemDao pMemdao = new PizzaMemDao();
		ArrayList<Pizza> list2 = pMemdao.findAllNewPizzas();
		int tint = list2.size();
		pMemdao.deletePizza("FRO");
		// PAS FINI



	}
}
