package co.edu.uco.UcoBet.generales.application.usecase.city.impl;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.UcoBet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.UcoBet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.UcoBet.generales.application.usecase.city.RegisterNewCityRuleValidator;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;

public final class RegisterNewCityImpl implements RegisterNewCity{
	
	private CityRepository cityRepository;
	private RegisterNewCityRuleValidator registerNewCityRuleValidator;
	
	
	public RegisterNewCityImpl(CityRepository cityRepository,
			RegisterNewCityRuleValidator registerNewCityRuleValidator) {
		this.cityRepository=cityRepository;
		this.registerNewCityRuleValidator=registerNewCityRuleValidator;
		
	}
	
	@Override
	public void execute(final CityDomain data) {
		//validar reglas de negocio
		registerNewCityRuleValidator.validate(data);
		
		//mapper de domain a entity
		CityEntity cityEntity= CityEntity.create();
		
		//Registar la ciudad
		cityRepository.save(cityEntity);
		
		//TODO: challenge for you:send notification to administrator when city is created!Email information 
		//is saved in key vault.......You must retrieve email from your key vault configuration.....
		
		//TODO:the last challenge is:i should  be able to change the subject and body of email dinamically!(Parameters building block)
		
	}

}
