package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityNameIsNullException extends RuleUcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityNameIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityNameIsNullException create() {
		var userMessage = "El nombre de la ciudad es nulo.....";
		return new CityNameIsNullException(userMessage, userMessage, new Exception());
	}

}
