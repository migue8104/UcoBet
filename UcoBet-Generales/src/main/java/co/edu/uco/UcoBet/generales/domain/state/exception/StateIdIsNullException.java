package co.edu.uco.UcoBet.generales.domain.state.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class StateIdIsNullException extends RuleUcoBetException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StateIdIsNullException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final StateIdIsNullException create() {
		var userMessage = "El id del estado es nulo";
		return new StateIdIsNullException(userMessage, userMessage, new Exception());
	}

}
