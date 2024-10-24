package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityIdIsEmptyException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdIsNotEmptyRule;
@Service
public class CityIdIsNotEmptyRuleImpl implements CityIdIsNotEmptyRule {

	@Override
	public final void execute(final UUID data) {
		if(ObjectHelper.isNull(data)) {
			throw CityIdIsEmptyException.create();
		}
		
	}

}
