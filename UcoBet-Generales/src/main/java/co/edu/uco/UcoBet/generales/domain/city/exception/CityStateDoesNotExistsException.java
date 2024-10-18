package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityStateDoesNotExistsException extends RuleUcoBetException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityStateDoesNotExistsException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityStateDoesNotExistsException create() {
		var userMessage = "El estado de la ciudad no existe...";
		return new CityStateDoesNotExistsException(userMessage, userMessage, new Exception());
	}

}
