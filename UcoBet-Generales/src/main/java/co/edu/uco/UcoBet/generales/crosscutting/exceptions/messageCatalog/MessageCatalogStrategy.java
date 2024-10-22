package co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog;


import co.edu.uco.UcoBet.generales.crosscutting.exceptions.CrosscutingUcoBetException;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.data.Mensaje;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.impl.MessageCatalogBase;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.impl.MessageCatalogExternalService;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;

public class MessageCatalogStrategy {

	private static final MessageCatalog base = new MessageCatalogBase();
	private static final MessageCatalog externalService = new MessageCatalogExternalService();

	static {
		inicializar();
	}

	private MessageCatalogStrategy() {
		super();
	}

	public static void inicializar() {
		base.inicializar();
		externalService.inicializar();

	}

	private static final MessageCatalog getStrategy(final boolean isBase) {
		return isBase ? base : externalService;
	}

	private static final Mensaje getMensaje(final CodigoMensaje codigo, final String... parametros) {
		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var userMessage = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var technicalMessage = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw CrosscutingUcoBetException.create(userMessage, technicalMessage);
		}

		return getStrategy(codigo.isBase()).obtenerMensaje(codigo, parametros);

	}

	public static final String getContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return getMensaje(codigo, parametros).getContenido();

	}

}
