package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityNameIsNullException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameIsNotNullRule;


@Service
public class CityNameIsNotNullRuleImpl implements CityNameIsNotNullRule {

	@Override
	public void execute(String data) {
		if(TextHelper.isNull(data)) {
			throw CityNameIsNullException.create();
		}
		
	}

}
