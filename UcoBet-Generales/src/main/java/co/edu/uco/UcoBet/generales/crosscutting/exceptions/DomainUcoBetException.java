package co.edu.uco.UcoBet.generales.crosscutting.exceptions;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.enums.Layer;

public final class DomainUcoBetException extends UcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DomainUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.DOMAIN, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final DomainUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new DomainUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final DomainUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new DomainUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final DomainUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new DomainUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final DomainUcoBetException create(final  String userMessage) {
		
		return new DomainUcoBetException(userMessage,userMessage, new Exception());
		
	}
	
	

}
