package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public final class CityIdDoesNotExistsException extends RuleUcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CityIdDoesNotExistsException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityIdDoesNotExistsException create() {
		var userMessage = "No existe la ciudad con el identificador indicado...";
		return new CityIdDoesNotExistsException(userMessage, userMessage, new Exception());
	}

}
