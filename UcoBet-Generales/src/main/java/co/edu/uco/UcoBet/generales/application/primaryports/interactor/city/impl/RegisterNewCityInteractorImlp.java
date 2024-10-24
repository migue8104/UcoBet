package co.edu.uco.UcoBet.generales.application.primaryports.interactor.city.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.UcoBet.generales.application.primaryports.mapper.RegisterNewCityDtoMapper;
import co.edu.uco.UcoBet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegisterNewCityInteractorImlp implements RegisterNewCityInteractor{
	
	private RegisterNewCity registerNewCityUseCase;
	
	public RegisterNewCityInteractorImlp(final RegisterNewCity registerNewCityUseCase) {
		this.registerNewCityUseCase=registerNewCityUseCase;
	}

	@Override
	public void execute(RegisterNewCityDto data) {
		// convertir dto to domain
		var cityDomain = RegisterNewCityDtoMapper.INSTANCE.toDomain(data);
		
		
		//llmar el uso de caso
		registerNewCityUseCase.execute(cityDomain);
		
	}

}
