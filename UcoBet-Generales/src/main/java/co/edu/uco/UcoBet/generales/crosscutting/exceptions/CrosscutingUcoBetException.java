package co.edu.uco.UcoBet.generales.crosscutting.exceptions;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.enums.Layer;

public final class CrosscutingUcoBetException extends UcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CrosscutingUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.CROSSCUTTING, rootException);
		// TODO Auto-generated constructor stub
	}
	
	
	public static  CrosscutingUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new CrosscutingUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static  CrosscutingUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new CrosscutingUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static  CrosscutingUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new CrosscutingUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static  CrosscutingUcoBetException create(final  String userMessage) {
		
		return new CrosscutingUcoBetException(userMessage,userMessage, new Exception());
		
	}
	
	

}
