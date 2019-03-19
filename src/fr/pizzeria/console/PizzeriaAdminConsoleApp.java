package fr.pizzeria.console;

import java.util.*;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		Pizza[] pizza = new Pizza[100];
		pizza[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizza[1] = new Pizza("MAR", "Margherita", 14.00);
		pizza[2] = new Pizza("REIN", "La Reine", 11.50);
		pizza[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		pizza[4] = new Pizza("CAN", "La cannibale", 12.50);
		pizza[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizza[6] = new Pizza("ORI", "L'orientale", 13.50);
		pizza[7] = new Pizza("IND", "L'indienne", 14.00);

		Scanner sc = new Scanner(System.in);
		int n = 0;

		while (n < 5) {
			System.out.println(
					"***PIZZA ADMINISTRATION****\n 1. Lister les pizzas\n 2. Ajouter une nouvelle pizza\n 3. Mettre à jour une pizza\n 4. Supprimer une Pizza\n 5. Sortir");
			n = sc.nextInt();
			switch (n) {

			case 1:
				System.out.println("1. Lister les pizzas");
				affiche(pizza);
				break;
			case 2:
				System.out.println("2. Ajouter une nouvelle pizza");
				ajouter(pizza);
				break;

			case 3:
				System.out.println("3. Mettre à jour une pizza");
				recup(pizza);
				break;

			case 4:
				System.out.println("4. Supprimer une Pizza");
				supp(pizza);
				break;

			case 5:
				System.out.println("5. Sortir");
				break;
			default:
				System.out.println("Merci de choisir dans le menu");
			}

		}

		sc.close();
	}

	public static void affiche(Pizza[] pizza) {
		for (Pizza pi : pizza)
			if (pi != null) {
				{
					System.out.println(pi.getCode() + " -> " + pi.getLibelle() + " (" + pi.getPrix() + ") ");
				}
			}
	}

	public static void ajouter(Pizza[] pizza) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir le code :");
		String coderecup = sc.nextLine();
		
		
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nomrecup = sc.nextLine();

		System.out.println("Veuillez saisir le prix :");
		String prixrecup = sc.nextLine();
		Double prixrecup2 = Double.parseDouble(prixrecup);
		
		for (int i=0; i<pizza.length; i++) {
			if (pizza[i]==null) {
				pizza[i] = new Pizza(coderecup, nomrecup, prixrecup2);
				break;

			}
		}
		
		
	}
	
	public static void recup(Pizza[] pizza) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel code souhaitez vous modifier ?");
		String coderecup = sc.nextLine();
			for(int j=0; j<pizza.length; j++) {
				if(pizza[j].getCode().equals(coderecup)) {
					System.out.println("Veuillez mettre à jour le code :");
					String coderecup2 = sc.nextLine();

					System.out.println("Veuillez mettre à jour le nom (sans espace)");
					String nomrecup = sc.nextLine();

					System.out.println("Veuillez mettre à jour le prix :");
					String prixrecup = sc.nextLine();
					Double prixrecup2 = Double.parseDouble(prixrecup);
					pizza[j].setCode(coderecup2);
					pizza[j].setLibelle(nomrecup);
					pizza[j].setPrix(prixrecup2);
					break;
					
				}}
			}
			public static void supp(Pizza[] pizza) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Quel code souhaitez vous supprimer ?");
				String coderecup = sc.nextLine();
					for(int j=0; j<pizza.length; j++) {
						if(pizza[j].getCode().equals(coderecup)) {
							pizza[j] = null;
							break;
						}
					}		
					sc.close();
		
		

			}
		
		
		
	}


