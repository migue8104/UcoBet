package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityIdIsEmptyException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdIsNotEmptyRule;

public class CityIdIsNotEmptyRuleImpl implements CityIdIsNotEmptyRule {

	@Override
	public final void execute(final UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw CityIdIsEmptyException.create();
		}
		
	}

}
