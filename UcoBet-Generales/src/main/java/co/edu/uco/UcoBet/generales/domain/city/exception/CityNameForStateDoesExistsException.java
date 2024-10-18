package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityNameForStateDoesExistsException extends RuleUcoBetException{

	private static final long serialVersionUID = 1L;

	public CityNameForStateDoesExistsException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	
	public static final CityNameForStateDoesExistsException create() {
		var userMessage = "El nombre de la ciudad para el estado ya existe ...";
		return new CityNameForStateDoesExistsException(userMessage, userMessage, new Exception());
	}

}
