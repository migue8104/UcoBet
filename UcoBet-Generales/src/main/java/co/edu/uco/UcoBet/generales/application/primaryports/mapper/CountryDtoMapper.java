package co.edu.uco.UcoBet.generales.application.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.country.CountryDto;
import co.edu.uco.UcoBet.generales.domain.country.CountryDomain;


@Mapper
public interface CountryDtoMapper {
	
	CountryDtoMapper INSTANCE = Mappers.getMapper(CountryDtoMapper.class);

	CountryDto toDto(CountryDomain domain);

	CountryDomain toDomain(CountryDto dto);

	List<CountryDto> toDTOCollection(List<CountryDomain> domainCollection);

	List<CountryDomain> toDomainCollection(List<CountryDto> dtoCollection);

}
