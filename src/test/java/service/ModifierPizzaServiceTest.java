package service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.mockito.Mockito;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.ListerPizzasService;
import fr.pizzeria.service.ModifierPizzaService;

public class ModifierPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() throws StockageException {
		IPizzaDao mockedDao = Mockito.mock(IPizzaDao.class);
		ListerPizzasService mockedLister = Mockito.mock(ListerPizzasService.class);
		Pizza pi = new Pizza("CAN", "Cannibale", 14.00, CategoriePizza.VIANDE);
		Mockito.when(mockedDao.pizzaExists(pi.getCode())).thenReturn(true);
		systemInMock.provideLines("VEZ", "LAR", "La Lardon", "12.00", "SANS_VIANDE");		
		ModifierPizzaService ModifierPizzasService = new ModifierPizzaService();
		ListerPizzasService listerPizzasService = new ListerPizzasService();
		listerPizzasService.executeUC(new Scanner(System.in), mockedDao);
		Mockito.verify(mockedDao).findAllNewPizzas();
		ModifierPizzasService.setListerPizzaService(listerPizzasService);
		ModifierPizzasService.executeUC(new Scanner(System.in), mockedDao);
		Pizza pizza = new Pizza("LAR", "La Lardon", 12.00, CategoriePizza.SANS_VIANDE);

		Mockito.verify(mockedDao).updatePizza("VEZ", pizza);
		
}
	}
