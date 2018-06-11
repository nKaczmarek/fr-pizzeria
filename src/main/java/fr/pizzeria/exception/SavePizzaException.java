package fr.pizzeria.exception;

public class SavePizzaException extends StockageException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public SavePizzaException()
	{
		super();
	}
	
	public SavePizzaException(String msg)
	{
		super(msg);
	}

}
