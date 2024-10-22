package co.edu.uco.UcoBet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.usecase.city.RegisterNewCityRuleValidator;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdDoesNotExistRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdFormatIsValidRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdIsNotEmptyRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameIsUniqueForStateRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityStateIsValidRule;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;


@Service
public final class RegisterNewCityRuleValidatorImpl implements RegisterNewCityRuleValidator {

	@Autowired
	private CityIdDoesNotExistRule cityIdDoesNotExistRule;
	@Autowired
	private CityIdFormatIsValidRule cityIdFormatIsValidRule;
	@Autowired
	private CityIdIsNotEmptyRule cityIdIsNotEmptyRule;
	@Autowired
	private CityNameIsUniqueForStateRule cityNameIsUniqueForStateRule;
	@Autowired
	private CityStateIsValidRule cityStateIsValidRule;

	
	@Override
	public void validate(CityDomain data) {
		validateRulesRelatedWithId(data.getId());
		validateRulesRelatedWithName(data);
		validateRulesRelatedWithState(data.getState());
		cityNameIsUniqueForStateRule.execute(data);
		
	}
	
	private void validateRulesRelatedWithId(final UUID id) {
		cityIdDoesNotExistRule.execute(id);
		cityIdFormatIsValidRule.execute(id);
		cityIdIsNotEmptyRule.execute(id);
		
	}
	
	
	private void validateRulesRelatedWithName(final CityDomain data) {
		cityNameIsUniqueForStateRule.execute(data);
	
		
	}
	
	private void validateRulesRelatedWithState(final StateDomain state) {
		cityStateIsValidRule.execute(state);

		
	}

}
