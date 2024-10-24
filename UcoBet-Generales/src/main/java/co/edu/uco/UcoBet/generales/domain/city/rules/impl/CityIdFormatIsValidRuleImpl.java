package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityIdFormatIsNotValidException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdFormatIsValidRule;
@Service
public class CityIdFormatIsValidRuleImpl implements CityIdFormatIsValidRule{

	@Override
	public void execute(UUID data) {
		if(UUIDHelper.isDefault(data)) {
			throw CityIdFormatIsNotValidException.create();
		}
		
	}

}
