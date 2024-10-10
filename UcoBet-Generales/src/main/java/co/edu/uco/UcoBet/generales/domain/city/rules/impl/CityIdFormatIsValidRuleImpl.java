package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityIdFormatIsNotValidException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdFormatIsValidRule;

public class CityIdFormatIsValidRuleImpl implements CityIdFormatIsValidRule{

	@Override
	public void execute(UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw CityIdFormatIsNotValidException.create();
		}
		
	}

}
