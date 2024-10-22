package co.edu.uco.UcoBet.generales.crosscutting.exceptions;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.enums.Layer;

public final class EntityUcoBetException extends UcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityUcoBetException(final String technicalMessage,final  String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.ENTITY, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final EntityUcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new EntityUcoBetException(technicalMessage, userMessage, rootException);
		
	}
	
	public static final EntityUcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new EntityUcoBetException(userMessage, userMessage, rootException);
		
	}
	
	public static final EntityUcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new EntityUcoBetException(technicalMessage, userMessage, new Exception());
		
	}
	
	public static final EntityUcoBetException create(final  String userMessage) {
		
		return new EntityUcoBetException(userMessage,userMessage, new Exception());
		
	}
	

}
