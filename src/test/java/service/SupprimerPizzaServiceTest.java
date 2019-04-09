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
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.SupprimerPizzaService;

public class SupprimerPizzaServiceTest {
	
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Test
	public void executeUC() {
		IPizzaDao dao = new PizzaMemDao();
		List<Pizza> l0 = dao.findAllNewPizzas();
		systemInMock.provideLines("PEP");
		int tailleInit = l0.size();
		SupprimerPizzaService supprimerPizzaService = new SupprimerPizzaService();
		supprimerPizzaService.executeUC(new Scanner(System.in), dao);
		Assert.assertTrue(dao.findAllNewPizzas().size() == (tailleInit - 1));
	}
}