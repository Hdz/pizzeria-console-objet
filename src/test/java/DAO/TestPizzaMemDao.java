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
import java.util.List;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;



public class TestPizzaMemDao {

		private static final Logger LOG =  LoggerFactory.getLogger(PizzaMemDao.class);
		private PizzaMemDao pizzaMemDao;
		
	@Rule public TestName testName;	
	@Rule public ExpectedException exE = ExpectedException.none();
	
	@Before
	public void init() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao(); //Instancie de pizzaMemDao
		LOG.info("Étant donnée; une instance de PizzaMemDao");
	}
	
	@Test
	public void testFindAllPizzas() {
		
		exE.expect(NumberFormatException.class);
		exE.expectMessage("Oops");
		LOG.info("Execution de la méthode {}", testName.getMethodName());
		
		PizzaMemDao pizzaMemDao = new PizzaMemDao(); //Instancie de pizzaMemDao
		LOG.info("Lorsque l'on recherche la liste de pizza :");
		List<Pizza> list = pizzaMemDao.findAllNewPizzas(); //Nouveau tableau de pizza, lorsque j'invoque la méthode Findall New Pizza
		LOG.info("Alors la liste de pizza contient au moins une pizza");
		Assert.assertTrue(list.size() > 0); // Récupère la taille si > 0 alors le test est retourne vrai, alors y'a bien une pizza dans la liste
	}
	
	@Test(expected = SavePizzaException.class)
	public void test_Save_new_Pizza() throws SavePizzaException {
		
		LOG.info("Lorsque l'on savegarde un code avec un code de moins de 3 char");
		LOG.info("Alors une Exception est lancée");
		exE.expect(SavePizzaException.class);
		exE.expectMessage("Oops");
		pizzaMemDao.saveNewPizza(new Pizza(8, "VE", "VEZUVIO", 12.50, CategoriePizza.SANS_VIANDE));

		
		
		
	/**	PizzaMemDao pizzaMemDao = new PizzaMemDao(); //Instancie de pizzaMemDao
		List<Pizza> Listedepizza = pizzaMemDao.findAllNewPizzas(); //Nouveau tableau de pizza, lorsque j'invoque la méthode Findall New Pizza
		Pizza pizza2 = new Pizza(8, "VEZ", "VEZUVIO", 12.50, CategoriePizza.SANS_VIANDE); //Nouvelle Pizza
		pizzaMemDao.saveNewPizza(pizza2); //On save new Pizza
		int i1 = Listedepizza.size(); //on fait un compte de nombre de ligne dans le tableau pizza
		Assert.assertTrue(pizzaMemDao.findAllNewPizzas().size() == (i1 + 1));	**/
		} 

	@Test
	public void test_update_new_Pizza() throws SavePizzaException {
		PizzaMemDao pMemdao = new PizzaMemDao();
		List<Pizza> list2 = pMemdao.findAllNewPizzas();
		Pizza uneNouvellePizza = new Pizza(8, "VEZ", "VEZUVIO", 12.50, CategoriePizza.SANS_VIANDE);
		pMemdao.saveNewPizza(uneNouvellePizza);
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
	public void test_delete_new_Pizza() {
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		List<Pizza> pizzas = pizzaMemDao.findAllNewPizzas();
		int tailleInit = pizzas.size();
		Pizza pizza = pizzas.get(0);
		pizzaMemDao.deletePizza(pizza.getCode());
		Assert.assertNotEquals(pizzaMemDao.findAllNewPizzas().size(), tailleInit);
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
