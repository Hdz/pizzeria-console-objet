package fr.pizzeria.service;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.IPizzaDao;
import dao.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaService extends MenuService {
	private static final Logger LOG =  LoggerFactory.getLogger(PizzaMemDao.class);
	ListerPizzasService listerPizzaService = new ListerPizzasService();
	
	@Override
	public void executeUC(Scanner scanner, IPizzaDao memPizza) throws StockageException{
		LOG.info("Mise à jour d'une pizza");
		ListerPizzasService l = new ListerPizzasService();
		l.executeUC(scanner, memPizza);
		LOG.info("Veuillez choisir le code de la pizza a modifier.");
		String code = scanner.nextLine();
		LOG.info("Veuillez saisir le nouveau code");
		String newCode = scanner.nextLine();
		LOG.info("Veuillez saisir le nouveau nom (sans espace)");
		String newNom = scanner.nextLine();
		String newPrixStr = scanner.nextLine();
		Double newPrix = Double.parseDouble(newPrixStr);
		if (memPizza.pizzaExists(code)) {
			throw new UpdatePizzaException("Le code rentre ne correspond a aucune pizza !");
		}
		LOG.info("Veuillez saisir la nouvelle categorie");
		String newCat = scanner.nextLine();
		CategoriePizza cat = CategoriePizza.valueOf(newCat);
		memPizza.updatePizza(code, new Pizza(newCode, newNom, newPrix, cat));
	}

	/**
	 * @param listerPizzaService the listerPizzaService to set
	 */
	public void setListerPizzaService(ListerPizzasService listerPizzasService) {
		this.listerPizzaService = listerPizzasService;		
	}

}
