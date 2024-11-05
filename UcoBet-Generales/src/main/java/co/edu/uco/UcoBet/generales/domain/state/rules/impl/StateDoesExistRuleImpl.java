package co.edu.uco.UcoBet.generales.domain.state.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;


import co.edu.uco.UcoBet.generales.application.secondaryports.repository.StateRepository;
import co.edu.uco.UcoBet.generales.domain.state.exception.StateDoesNotExistException;
import co.edu.uco.UcoBet.generales.domain.state.rules.StateDoesExistRule;

@Service
public class StateDoesExistRuleImpl implements StateDoesExistRule {

	private StateRepository stateRepository;

	public StateDoesExistRuleImpl(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public void execute(UUID data) {

		if (!stateRepository.existsById(data)) {
			var mensajeUsuario = "El estado al que quiere asociar la ciudad no existe";
			throw StateDoesNotExistException.create(mensajeUsuario);
		}

	}

}
