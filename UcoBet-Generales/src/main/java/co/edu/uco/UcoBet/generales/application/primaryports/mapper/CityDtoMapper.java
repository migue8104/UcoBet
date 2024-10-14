package co.edu.uco.UcoBet.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.CityDto;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;

@Mapper
public interface CityDtoMapper {
	
	CityDtoMapper INSTANCE = Mappers.getMapper(CityDtoMapper.class);

	CityDto toDto(CityDomain domain);

	CityDomain toDomain(CityDto dto);

	List<CityDto> toDTOCollection(List<CityDomain> domainCollection);

	List<CityDomain> toDomainCollection(List<CityDto> dtoCollection);

}
