package co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.state.ConsultStateDto;

public class StateResponse  extends Response<ConsultStateDto>{
	
	public StateResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}


}
