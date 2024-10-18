package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityIdIsNullException extends RuleUcoBetException {

	private static final long serialVersionUID = 1L;

	public CityIdIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);

	}
	
	public static final CityIdIsNullException create() {
		var userMessage = "El id de la ciudad es nulo";
		return new CityIdIsNullException(userMessage, userMessage, new Exception());
	}

}
