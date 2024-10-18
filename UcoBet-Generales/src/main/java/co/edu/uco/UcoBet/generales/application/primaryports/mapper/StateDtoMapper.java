package co.edu.uco.UcoBet.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.state.StateDto;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;

@Mapper
public interface StateDtoMapper {
	
	StateDtoMapper INSTANCE = Mappers.getMapper(StateDtoMapper.class);

	StateDto toDto(CityDomain domain);

	CityDomain toDomain(StateDto dto);

	List<StateDto> toDTOCollection(List<StateDomain> domainCollection);

	List<StateDomain> toDomainCollection(List<StateDto> dtoCollection);

}
