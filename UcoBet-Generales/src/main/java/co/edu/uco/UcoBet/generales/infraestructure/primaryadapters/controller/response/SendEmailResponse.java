package co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.response;

import java.util.ArrayList;

public class SendEmailResponse extends Response<String>{
	
	public SendEmailResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
