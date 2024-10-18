package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityIsUsedException extends RuleUcoBetException{


	private static final long serialVersionUID = 1L;

	public CityIsUsedException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityIsUsedException create() {
		var userMessage = "la ciudad esta siendo usada...";
		return new CityIsUsedException(userMessage, userMessage, new Exception());
	}


}
