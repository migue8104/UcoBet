package co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.data.Mensaje;

public interface MessageCatalog {
	
	void inicializar();
	
	String obtenerContenidoMensaje(final CodigoMensaje codigo,String ...parametros);
	Mensaje obtenerMensaje(final CodigoMensaje codigo,String ...parametros);

}
