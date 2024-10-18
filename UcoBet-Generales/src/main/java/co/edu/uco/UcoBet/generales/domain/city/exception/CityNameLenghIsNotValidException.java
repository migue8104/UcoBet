package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityNameLenghIsNotValidException extends RuleUcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityNameLenghIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityNameLenghIsNotValidException create() {
		var userMessage = "la longitud del nombre de la ciudad no es valido";
		return new CityNameLenghIsNotValidException(userMessage, userMessage, new Exception());
	}

}
