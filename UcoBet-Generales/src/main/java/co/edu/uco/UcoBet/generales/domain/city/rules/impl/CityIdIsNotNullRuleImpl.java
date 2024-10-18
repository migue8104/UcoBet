package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityIdIsNullException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdIsNotNullRule;

public class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {

	
	
	@Override
	public void execute(UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw CityIdIsNullException.create();
		}
		
	}

}
