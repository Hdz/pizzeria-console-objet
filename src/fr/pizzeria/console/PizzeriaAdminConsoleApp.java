package fr.pizzeria.console;
import java.util.*;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		System.out.println("***PIZZA ADMINISTRATION****\n 1. Lister les pizzas\n 2. Ajouter une nouvelle pizza\n 3. Mettre à jour une pizza\n 4. Supprimer une Pizza\n 5. Sortir" );
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();

		while(n>5){
		switch (n) {
		
			case 1 : 
				System.out.println("1. Lister les pizzas");
				
				break;
			
			case 2 : 
				System.out.println("2. Ajouter une nouvelle pizza");
				break;
			
			case 3 :
				System.out.println("3. Mettre à jour une pizza");			
				break;
			
			case 4 :
				System.out.println("4. Supprimer une Pizza");
				break;
		
			case 5 : 
				System.out.println("99. Sortir");
				break;
			default :
				System.out.println("Merci de choisir dans le menu");
				System.out.println("***PIZZA ADMINISTRATION****\n 1. Lister les pizzas\n 2. Ajouter une nouvelle pizza\n 3. Mettre à jour une pizza\n 4. Supprimer une Pizza\n 5. Sortir ☹" );
				
		}
	      n=sc.nextInt();
		}	
		sc.close();
}

	}
