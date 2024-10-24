package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.domain.city.CityDomain;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityNameForStateDoesExistsException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;

@Service
public class CityNameForStateDoesNotExistsRuleImpl implements CityNameForStateDoesNotExistsRule{

	
	
	@Override
	public void execute(CityDomain data) {
		throw CityNameForStateDoesExistsException.create();
		
	}

}
