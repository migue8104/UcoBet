package co.edu.uco.UcoBet.generales.application.primaryports.interactor.city.impl;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.UcoBet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;

public class RegisterNewCityInteractorImlp implements RegisterNewCityInteractor{
	
	private RegisterNewCity registerNewCityUseCase;
	
	public RegisterNewCityInteractorImlp(final RegisterNewCity registerNewCityUseCase) {
		this.registerNewCityUseCase=registerNewCityUseCase;
	}

	@Override
	public void execute(RegisterNewCityDto data) {
		// convertir dto to domain
		CityDomain domain=CityDomain.create(null, null, null);
		
		
		//llmar el uso de caso
		registerNewCityUseCase.execute(domain);
		
	}

}
