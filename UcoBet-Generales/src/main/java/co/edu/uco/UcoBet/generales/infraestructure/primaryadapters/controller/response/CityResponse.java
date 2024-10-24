package co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.response;

import java.util.ArrayList;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;

public class CityResponse extends Response<RegisterNewCityDto> {

	public CityResponse() {
		setMensajes(new ArrayList<>());
		setDatos(new ArrayList<>());
	}

}
