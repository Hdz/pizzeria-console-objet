package DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

import dao.PizzaMemDao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;



public class TestPizzaMemDao {

		private static final Logger LOG =  LoggerFactory.getLogger(PizzaMemDao.class);
		private PizzaMemDao pizzaMemDao;
		PizzaMemDao p;
		
		
	@Rule	
	public TestName pTest = new TestName();
	@Rule public ExpectedException exE = ExpectedException.none();
	
	@Before
	public void init() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao(); //Instancie de pizzaMemDao
		LOG.info("Étant donnée; une instance de PizzaMemDao");
	}
	
	@Test
	public void testFindAllPizzas() {
		
		LOG.info("Execution de la méthode {}", pTest.getMethodName());
		PizzaMemDao pizzaMemDao = new PizzaMemDao(); //Instancie de pizzaMemDao
		LOG.info("Lorsque l'on recherche la liste de pizza :");
		List<Pizza> list = pizzaMemDao.findAllNewPizzas(); //Nouveau tableau de pizza, lorsque j'invoque la méthode Findall New Pizza
		LOG.info("Alors la liste de pizza contient au moins une pizza");
		Assert.assertTrue(list.size() > 0); // Récupère la taille si > 0 alors le test est retourne vrai, alors y'a bien une pizza dans la liste
		
	}
	
	@Test()
	public void test_Save_new_Pizza() throws SavePizzaException {

		PizzaMemDao pizzaMemDao = new PizzaMemDao(); //Instancie de pizzaMemDao
		Pizza uneNouvellePizza = new Pizza(8, "VEZ", "VEZUVIO", 12.50, CategoriePizza.SANS_VIANDE);
		int size = pizzaMemDao.findAllNewPizzas().size();
		LOG.info("Lorsqu'on insère une nouvelle pizza dans la liste");
		pizzaMemDao.saveNewPizza(uneNouvellePizza);
		LOG.info("Alors on doit avoir une liste plus grande de 1");
		assertEquals(size + 1, pizzaMemDao.findAllNewPizzas().size());
		} 

	@Test
	public void test_update_new_Pizza() throws SavePizzaException {
		PizzaMemDao pMemdao = new PizzaMemDao();
		List<Pizza> list2 = pMemdao.findAllNewPizzas();
		Pizza uneNouvellePizza = new Pizza(8, "VEZ", "VEZUVIO", 12.50, CategoriePizza.SANS_VIANDE);
		pMemdao.saveNewPizza(uneNouvellePizza);
		pMemdao.updatePizza("VEZ", new Pizza(8,"FRO","La 4 fromages",12.00,CategoriePizza.SANS_VIANDE));
		for (Pizza p : list2) {
			if (p != null && p.getCode().equals("FRO")) {
				Assert.assertTrue(p.getLibelle().equals("La 4 fromages"));
				Assert.assertTrue(p.getPrix() == 12.00);
				Assert.assertTrue(p.getcP() == CategoriePizza.SANS_VIANDE);
			}
		}
	}


	@Test
	public void test_delete_new_Pizza() throws SavePizzaException {
		PizzaMemDao pizzaMemDao = new PizzaMemDao(); //Instancie de pizzaMemDao
		int tailleInit = pizzaMemDao.findAllNewPizzas().size();
		Pizza pizza = pizzaMemDao.findAllNewPizzas().get(7);
		pizzaMemDao.deletePizza(pizza.getCode());
		Assert.assertEquals(tailleInit-1, pizzaMemDao.findAllNewPizzas().size());
		}

	@Test
	public void find_Pizza_By_Code() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		List<Pizza> pizzas = pizzaMemDao.findAllNewPizzas();
		Pizza piz = pizzaMemDao.findPizzaByCode(pizzas.get(0).getCode());
		Assert.assertTrue(piz.getId() == pizzas.get(0).getId());
		Assert.assertTrue(piz.getCode().equals(pizzas.get(0).getCode()));
		Assert.assertTrue(piz.getPrix() == pizzas.get(0).getPrix());
		Assert.assertTrue(piz.getLibelle().equals(pizzas.get(0).getLibelle()));
		Assert.assertTrue(piz.getcP().equals(pizzas.get(0).getcP()));
	}


	@Test
	public void testPizzaExists() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		List<Pizza> pizzas = pizzaMemDao.findAllNewPizzas();
		boolean res = pizzaMemDao.pizzaExists(pizzas.get(0).getCode());
		Assert.assertEquals(res, true);
	}}
