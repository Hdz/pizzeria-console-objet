package fr.pizzeria.service;
import java.io.*;
import java.util.Scanner;
import dao.IPizzaDao;

public class SauvegarderPizzasService extends MenuService{

	@Override
	public void executeUC(Scanner scanner, IPizzaDao memPizza) {
		// TODO Auto-generated method stub
		
		System.out.println("Donner un nom de fichier");
		String nomFile = scanner.nextLine();
		FileOutputStream fos = null;
		
		
	}
}