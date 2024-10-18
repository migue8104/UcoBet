package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityNameIsNotUniqueForStateException extends RuleUcoBetException{

	private static final long serialVersionUID = 1L;

	public CityNameIsNotUniqueForStateException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityNameIsNotUniqueForStateException create() {
		var userMessage = "El nombre de la ciudad no es unico para el estado";
		return new CityNameIsNotUniqueForStateException(userMessage, userMessage, new Exception());
	}

}
