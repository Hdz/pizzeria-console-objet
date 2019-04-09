package service;



import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;



import java.util.Scanner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;
import dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.AjouterPizzaService;

public class AjouterPizzasServiceTest {

	@Rule 

	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	
	@Test

	public void executeUC() throws StockageException {

		
		// création du mock
		IPizzaDao dao = Mockito.mock(IPizzaDao.class);
		
		systemInMock.provideLines("VEZ", "VESUVIO","12.00","SANS_VIANDE");

		// définir comportement du mock
		Pizza pizza = new Pizza("VEZ", "VESUVIO", 12.00, CategoriePizza.SANS_VIANDE);
			
		// saisie utilisateur :
		Mockito.doThrow(SavePizzaException.class).when(dao).saveNewPizza(pizza);
		
		AjouterPizzaService ajouterPizzasService = new AjouterPizzaService();
		ajouterPizzasService.executeUC(new Scanner(System.in), dao);

		// vérifier que la méthode saveNewPizza du mock a été invoquée

		Mockito.verify(dao).saveNewPizza(pizza);


		

		

	}



}