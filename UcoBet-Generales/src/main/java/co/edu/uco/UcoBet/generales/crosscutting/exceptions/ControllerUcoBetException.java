package co.edu.uco.UcoBet.generales.crosscutting.exceptions;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.enums.Layer;

public final class ControllerUcoBetException extends UcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControllerUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.CONTROLLER, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final ControllerUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new ControllerUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final ControllerUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new ControllerUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final ControllerUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new ControllerUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final ControllerUcoBetException create(final  String userMessage) {
		
		return new ControllerUcoBetException(userMessage,userMessage, new Exception());
		
	}
	
	

}
