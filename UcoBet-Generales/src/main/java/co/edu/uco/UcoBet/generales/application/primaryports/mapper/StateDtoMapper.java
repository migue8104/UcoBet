package co.edu.uco.UcoBet.generales.application.primaryports.mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.state.ConsultStateDto;
import co.edu.uco.UcoBet.generales.domain.country.CountryDomain;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;

@Mapper
public interface StateDtoMapper {
	
	StateDtoMapper INSTANCE = Mappers.getMapper(StateDtoMapper.class);

    // Mapeo de ConsultStateDto a StateDomain
    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountry")
    StateDomain toDomain(ConsultStateDto dto);

    // Mapeo de StateDomain a ConsultStateDto
    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountryToUUID")
    ConsultStateDto toDTO(StateDomain domain);
    
    // Mapeo de colección de ConsultStateDto a colección de StateDomain
    List<StateDomain> toDomainCollection(List<ConsultStateDto> dtoList);
    
    // Mapeo de colección de StateDomain a colección de ConsultStateDto
    List<ConsultStateDto> toDTOCollection(List<StateDomain> domainCollection);

    // Método personalizado para mapear UUID a CountryDomain, anotado con @Named
    @Named("mapCountry")
    default CountryDomain mapCountry(UUID countryId) {
        return CountryDomain.create(countryId, null);
    }

    // Método personalizado para mapear CountryDomain a UUID, anotado con @Named
    @Named("mapCountryToUUID")
    default UUID mapCountryToUUID(CountryDomain country) {
        return country != null ? country.getId() : null;
    }
}
