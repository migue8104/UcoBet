package co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.CrosscutingUcoBetException;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.MessageCatalog;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.data.Mensaje;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;



public class MessageCatalogExternalService implements MessageCatalog {
	
	private final Map<String,Mensaje> mensajes = new HashMap<>();

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00007.getIdentificador(),
				new Mensaje(CodigoMensaje.M00007,"la transaccion se a completado de forma satisfactoria..."));
		
	}

	@Override
	public String obtenerContenidoMensaje(CodigoMensaje codigo, String... parametros) {
		// TODO Auto-generated method stub
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public Mensaje obtenerMensaje(CodigoMensaje codigo, String... parametros) {
		// TODO Auto-generated method stub
		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw CrosscutingUcoBetException.create(mensajeTecnico, mensajeUsuario);
			
		}
		
		if (codigo.isBase()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,codigo.getIdentificador());
			throw CrosscutingUcoBetException.create(mensajeTecnico, mensajeUsuario);
		}
		
		if (!mensajes.containsKey(codigo.getIdentificador()) ){
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006,codigo.getIdentificador());
			throw CrosscutingUcoBetException.create(mensajeTecnico, mensajeUsuario);
		}
		return mensajes.get(codigo.getIdentificador());
	}
	
	
	
}
