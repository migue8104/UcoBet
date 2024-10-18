package co.edu.uco.UcoBet.generales.domain.city.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityNameIsEmptyExcpetion extends RuleUcoBetException {


	private static final long serialVersionUID = 1L;

	public CityNameIsEmptyExcpetion(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityNameIsEmptyExcpetion create() {
		var userMessage = "El nombre de la ciudad esta vacio....";
		return new CityNameIsEmptyExcpetion(userMessage, userMessage, new Exception());
	}

}
