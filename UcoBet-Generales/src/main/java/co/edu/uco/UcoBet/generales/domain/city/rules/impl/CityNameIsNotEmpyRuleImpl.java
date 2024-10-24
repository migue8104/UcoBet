package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityNameIsEmptyExcpetion;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameIsNotEmpyRule;


@Service
public class CityNameIsNotEmpyRuleImpl implements CityNameIsNotEmpyRule{

	@Override
	public void execute(String data) {
		if(TextHelper.isEmpty(data)) {
			throw CityNameIsEmptyExcpetion.create();
		}
		
	}

}
