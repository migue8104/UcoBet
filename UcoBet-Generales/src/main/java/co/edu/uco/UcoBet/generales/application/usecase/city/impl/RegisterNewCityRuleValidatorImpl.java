package co.edu.uco.UcoBet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.usecase.city.RegisterNewCityRuleValidator;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityIdDoesExistsException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdDoesNotExistRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdFormatIsValidRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdIsNotEmptyRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIdIsNotNullRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameForStateDoesNotExistsRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameFormatIsValidRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameIsNotEmpyRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameIsNotNullRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameLenghIsValidRule;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityStateIsValidRule;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;
import co.edu.uco.UcoBet.generales.domain.state.rules.StateIdIsNotNullRule;


@Service
public final class RegisterNewCityRuleValidatorImpl implements RegisterNewCityRuleValidator {

	@Autowired
	private CityIdDoesNotExistRule cityIdDoesNotExistRule;
	@Autowired
	private CityIdFormatIsValidRule cityIdFormatIsValidRule;
	@Autowired
	private CityIdIsNotEmptyRule cityIdIsNotEmptyRule;
	@Autowired
	private CityStateIsValidRule cityStateIsValidRule;
	@Autowired
	private CityIdIsNotNullRule cityIdIsNotNullRule;
	@Autowired
	private CityNameFormatIsValidRule cityNameFormatIsValidRule;
	@Autowired
	private CityNameForStateDoesNotExistsRule cityNameForStateDoesNotExistsRule;
	@Autowired
	private CityNameIsNotEmpyRule cityNameIsNotEmpyRule;
	@Autowired
	private CityNameIsNotNullRule cityNameIsNotNullRule;
	@Autowired
	private CityNameLenghIsValidRule cityNameLenghIsValidRule;
	@Autowired
	private StateIdIsNotNullRule stateIdIsNotNullRule;

	
	@Override
	public void validate(CityDomain data) {
		
		data.generateId();
		try {
			cityIdDoesNotExistRule.execute(data.getId());
		} catch (CityIdDoesExistsException exception) {
			validate(data);
		}
		
		
		validateRulesRelatedWithId(data.getId());
		validateRulesRelatedWithName(data);
		validateRulesRelatedWithState(data.getState());
		
		

	}
	
	private void validateRulesRelatedWithId(final UUID id) {
		cityIdDoesNotExistRule.execute(id);
		cityIdFormatIsValidRule.execute(id);
		cityIdIsNotEmptyRule.execute(id);
		cityIdIsNotNullRule.execute(id);

	}
	
	
	private void validateRulesRelatedWithName(final CityDomain data) {
		cityNameFormatIsValidRule.execute(data.getName());
		cityNameForStateDoesNotExistsRule.execute(data);
		cityNameIsNotEmpyRule.execute(data.getName());
		cityNameIsNotNullRule.execute(data.getName());
		cityNameLenghIsValidRule.execute(data.getName());
	
		
	}
	
	private void validateRulesRelatedWithState(final StateDomain state) {
		cityStateIsValidRule.execute(state);
		stateIdIsNotNullRule.execute(state);

		
	}

}
