package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.UcoBet.generales.application.secondaryports.mapper.CountryEntityMapper;
import co.edu.uco.UcoBet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityNameForStateDoesExistsException;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityStateIsNotValidException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityStateIsValidRule;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;

@Service
public class CityStateIsValidRuleImpl implements CityStateIsValidRule {

	private StateRepository stateRepositorY;

	public CityStateIsValidRuleImpl(StateRepository stateRepositorY) {
		this.stateRepositorY = stateRepositorY;
	}

	@Override
	public void execute(StateDomain data) {
		var stateEntity = StateEntity.create().setId(data.getId()).setName(data.getName())
				.setCountry(CountryEntityMapper.INSTANCE.toEntity(data.getCountry()));

		var resultado = stateRepositorY.findByFilter(stateEntity);

		if (!resultado.isEmpty()) {
			throw CityStateIsNotValidException.create();
		}
	}

}
