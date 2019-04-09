package service;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.ModifierPizzaService;

public class ModifierPizzaServiceTest {

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Test
	public void executeUC() {
		IPizzaDao dao = new PizzaMemDao();
		systemInMock.provideLines("CAN", "IOP", "yoplay", "12.00", "SANS_VIANDE");
		ModifierPizzaService ModifierPizzasService = new ModifierPizzaService();
		try {
			ModifierPizzasService.executeUC(new Scanner(System.in), dao);
		} catch (StockageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pizza pi = dao.findPizzaByCode("IOP");
		
		Assert.assertTrue(pi.getLibelle().equals("yoplay"));
		Assert.assertTrue(pi.getPrix() == 12.00);
		Assert.assertTrue(pi.getcP().equals(CategoriePizza.SANS_VIANDE));
	}
}