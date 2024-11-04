package co.edu.uco.UcoBet.generales.crosscutting.exceptions;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.enums.Layer;

public class SendgridUCOBETException extends UcoBetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SendgridUCOBETException(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, Layer.EMAIL, rootException);
		// TODO Auto-generated constructor stub
	}

	public static SendgridUCOBETException create(final String technicalMessage, final String userMessage,
			final Exception rootException) {

		return new SendgridUCOBETException(technicalMessage, userMessage, rootException);

	}

	public static SendgridUCOBETException create(final String userMessage, final Exception rootException) {

		return new SendgridUCOBETException(userMessage, userMessage, rootException);

	}

	public static SendgridUCOBETException create(final String technicalMessage, final String userMessage) {

		return new SendgridUCOBETException(technicalMessage, userMessage, new Exception());

	}

	public static SendgridUCOBETException create(final String userMessage) {

		return new SendgridUCOBETException(userMessage, userMessage, new Exception());

	}

}
