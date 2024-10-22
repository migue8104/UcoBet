package co.edu.uco.UcoBet.generales.crosscutting.exceptions;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.enums.Layer;

public final class DtoUcoBetException extends UcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DtoUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.DTO, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final DtoUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new DtoUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final DtoUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new DtoUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final DtoUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new DtoUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final DtoUcoBetException create(final  String userMessage) {
		
		return new DtoUcoBetException(userMessage,userMessage, new Exception());
		
	}
	
	

}
