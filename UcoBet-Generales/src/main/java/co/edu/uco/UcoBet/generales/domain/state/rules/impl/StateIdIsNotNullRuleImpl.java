package co.edu.uco.UcoBet.generales.domain.state.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.UcoBet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.UcoBet.generales.domain.city.exception.CityIdIsNullException;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;
import co.edu.uco.UcoBet.generales.domain.state.exception.StateIdIsNullException;
import co.edu.uco.UcoBet.generales.domain.state.rules.StateIdIsNotNullRule;

@Service
public class StateIdIsNotNullRuleImpl implements StateIdIsNotNullRule{
	
	private StateRepository stateRepository;
	
	public StateIdIsNotNullRuleImpl (StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public void execute(StateDomain data) {
		var stateEntity = StateEntity.create().setId(data.getId());
		var resultados = stateRepository.findByFilter(stateEntity);
		
		if(!resultados.isEmpty()) {
			throw StateIdIsNullException.create();
		}
		
	}



}
