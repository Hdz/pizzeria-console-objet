/**
 * 
 */
package fr.pizzeria.exception;

public class PersonnalSqlException extends RuntimeException
{
	private static final long serialVersionUID = -8898974333236523950L;
	
	public PersonnalSqlException(String msg) 
	{
		super(msg);
	}
	
	public PersonnalSqlException(Exception e) 
	{
		super(e);
	}

	public PersonnalSqlException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonnalSqlException(String arg0, Throwable arg1)
	{
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public PersonnalSqlException(Throwable arg0)
	{
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	

}