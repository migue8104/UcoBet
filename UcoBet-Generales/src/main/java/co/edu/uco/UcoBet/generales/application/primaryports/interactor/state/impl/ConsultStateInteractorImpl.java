package co.edu.uco.UcoBet.generales.application.primaryports.interactor.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.state.ConsultStateDto;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.state.ConsultStateInteractor;
import co.edu.uco.UcoBet.generales.application.primaryports.mapper.StateDtoMapper;
import co.edu.uco.UcoBet.generales.application.usecase.state.ConsultState;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.DataUcoBetException;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.UcoBetException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsultStateInteractorImpl implements ConsultStateInteractor {

	private ConsultState consultStateUseCase;
	
	public ConsultStateInteractorImpl (ConsultState consultStateUseCase) {
		this.consultStateUseCase=consultStateUseCase;
	}

	@Override
	public List<ConsultStateDto> execute(ConsultStateDto data) {

		try {
			var stateDomain = StateDtoMapper.INSTANCE.toDomain(data);
			var resultado = consultStateUseCase.execute(stateDomain);
			return StateDtoMapper.INSTANCE.toDTOCollection(resultado);
		} catch (UcoBetException exception) {
			var mensajeUsuario = "Se ha presentado un problema al consultar la información de los estados";
			throw DataUcoBetException.create(mensajeUsuario);
		}
	}

}
