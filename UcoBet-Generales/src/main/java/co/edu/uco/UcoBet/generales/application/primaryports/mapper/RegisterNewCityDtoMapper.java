package co.edu.uco.UcoBet.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;

@Mapper
public interface RegisterNewCityDtoMapper {
	
	RegisterNewCityDtoMapper INSTANCE = Mappers.getMapper(RegisterNewCityDtoMapper.class);

	RegisterNewCityDto toDto(CityDomain domain);

	CityDomain toDomain(RegisterNewCityDto dto);

	List<RegisterNewCityDto> toDTOCollection(List<CityDomain> domainCollection);

	List<CityDomain> toDomainCollection(List<RegisterNewCityDto> dtoCollection);

}
