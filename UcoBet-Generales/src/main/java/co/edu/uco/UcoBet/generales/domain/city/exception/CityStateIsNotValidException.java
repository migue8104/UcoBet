package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityStateIsNotValidException extends RuleUcoBetException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityStateIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityNameFormatIsNotValidException create() {
		var userMessage = "El estado de la ciudad no es valido...";
		return new CityNameFormatIsNotValidException(userMessage, userMessage, new Exception());
	}
}
