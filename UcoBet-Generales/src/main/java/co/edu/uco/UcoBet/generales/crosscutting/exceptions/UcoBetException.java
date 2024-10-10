package co.edu.uco.UcoBet.generales.crosscutting.exceptions;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.enums.Layer;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;

public class UcoBetException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userMessage;
	private Layer layer;
	
	public UcoBetException(String technicalMessage,
			String userMessage,Layer layer,
			Exception rootException) {
		
		super(ObjectHelper.getDefault(technicalMessage, TextHelper.applyTrim(userMessage)),ObjectHelper.getDefault(rootException, new Exception()));
		
				setLayer(layer);
		setUserMessage(userMessage);
	}

	public String getUserMessage() {
		return userMessage;
	}

	private final  void setUserMessage(String userMessage) {
		this.userMessage = TextHelper.applyTrim(userMessage);
	}

	public Layer getLayer() {
		return layer;
	}

	private final void setLayer(Layer layer) {
		this.layer = ObjectHelper.getDefault(layer, Layer.GENERAL);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public static  UcoBetException create(final String technicalMessage,final  String userMessage, 
			final Exception rootException) {
		
		return new UcoBetException(technicalMessage, userMessage, Layer.GENERAL, rootException);
		
	}
	
	public static  UcoBetException create(final  String userMessage, 
			final Exception rootException) {
		
		return new UcoBetException(userMessage, userMessage, Layer.GENERAL, rootException);
		
	}
	
	public static  UcoBetException create(final String technicalMessage,final  String userMessage) {
		
		return new UcoBetException(technicalMessage, userMessage, Layer.GENERAL, new Exception());
		
	}
	
	public static UcoBetException create(final  String userMessage) {
		
		return new UcoBetException(userMessage,userMessage, Layer.GENERAL, new Exception());
		
	}
	
	

}
