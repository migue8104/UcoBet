package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityNameIsNotUniqueForStateException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameIsUniqueForStateRule;

@Service
public class CityNameIsUniqueForStateRuleImpl implements CityNameIsUniqueForStateRule {

	@Override
	public void execute(CityDomain data) {
		throw CityNameIsNotUniqueForStateException.create();

	}

}
