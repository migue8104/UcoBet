package co.edu.uco.UcoBet.generales.domain.state.exception;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class StateDoesNotExistException extends RuleUcoBetException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StateDoesNotExistException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final StateDoesNotExistException create() {
		var userMessage = "El estadod no existe";
		return new StateDoesNotExistException(userMessage, userMessage, new Exception());
	}

}
