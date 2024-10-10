package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public final  class CityIdFormatIsNotValidException extends RuleUcoBetException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityIdFormatIsNotValidException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityIdFormatIsNotValidException create() {
		var userMessage = "La ciudad tiene un identificador con formato no valido correspondiente al valor por defecto";
		return new CityIdFormatIsNotValidException(userMessage,userMessage,new Exception());
	}

}
