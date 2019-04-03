package dao;

import fr.pizzeria.exception.Mysqlexception;
import fr.pizzeria.exception.PersonnalSqlException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties; 

public class Pizzabdd implements IPizzaDao {

	
	String jdbcUrl = null;
	String userName = null;
	String password = null;
	Connection connexionBDD = null;
	PreparedStatement st = null;
	FileInputStream fis = null;
	
	private void beginConnexionBdd ()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			GestionFichier file = new GestionFichier ("jdbc.properties");

			List <String> listString = file.lecture();
			
			jdbcUrl = listString.get(0).split(";")[1];
			userName = listString.get(1).split(";")[1];
			password = listString.get(2).split(";")[1];
			
			
			connexionBDD = DriverManager.getConnection(jdbcUrl, userName, password);
			connexionBDD.setAutoCommit(false);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			throw new Mysqlexception ("La connexion à la base de donnée ne s'est pas déroulé correctement", e);
		}

	
	
	}
	
	private void closeConnexionBdd ()
	{
		try
		{
			st.close ();
			connexionBDD.close ();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override	
	public ArrayList<Pizza> findAllNewPizzas()
	{
		ArrayList <Pizza> tabPizza = new ArrayList <> ();
		
		try
		{
			beginConnexionBdd ();
			
			st = connexionBDD.prepareStatement("SELECT * FROM pizzas");
			ResultSet result = st.executeQuery();
			System.out.println(result.getFetchSize());
			
			while(result.next()) 
			{		
				int id = result.getInt("id");
				String code = result.getString("code");
				String libelle = result.getString("libelle");
				double prix = result.getDouble("prix");
				String categorie = result.getString("categorie");
				
				tabPizza.add(new Pizza (id, code, libelle, prix, CategoriePizza.valueOf(categorie.toUpperCase())));	
				
				Pizza.setNbPizza(id);
			}
			
			closeConnexionBdd ();
		}
		catch (SQLException e)
		{
			throw new Mysqlexception ("La récupération de la liste de pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}
		
		return tabPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		try
		{
			beginConnexionBdd ();
			
			st = connexionBDD.prepareStatement("INSERT INTO pizzas (code, libelle, prix, categorie) values (?, ?, ?, ?);");
			st.setString(1, pizza.getCode());
			st.setString(2, pizza.getLibelle());
			st.setDouble(3, pizza.getPrix());
			st.setString(4, pizza.getcP().getNom());
			st.executeUpdate();
			
			connexionBDD.commit();
			
			closeConnexionBdd ();
		}
		catch (SQLException e)
		{
			throw new PersonnalSqlException ("Votre ajout d'une pizza dans la base de donnée ne s'est pas déroulé correctement", e);
		}
		finally
		{
			closeConnexionBdd ();
}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
