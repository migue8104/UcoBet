package co.edu.uco.UcoBet.generales.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.CountryEntity;
import co.edu.uco.UcoBet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.UcoBet.generales.domain.country.CountryDomain;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;

@Mapper
public interface StateEntityMapper {
	
	StateEntityMapper INSTANCE = Mappers.getMapper(StateEntityMapper.class);

	   @Mapping(source = "country", target = "country", qualifiedByName = "mapCountryToEntity")
		StateEntity toEntity(StateDomain domain);
		
		List<StateEntity> toEntityCollection(List<StateDomain> domainCollection);
		
	    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountryToDomain")
		StateDomain toDomain(StateEntity entity);
		
		List<StateDomain> toDomainCollection(List<StateEntity> entityCollection);

	    // Método personalizado para mapear CountryEntity a CountryDomain
	    @Named("mapCountryToDomain")
	    default CountryDomain mapCountryToDomain(CountryEntity countryEntity) {
	        return countryEntity != null ? CountryDomain.create(countryEntity.getId(), countryEntity.getName()) : null;
	    }

	    // Método personalizado para mapear CountryDomain a CountryEntity
	    @Named("mapCountryToEntity")
	    default CountryEntity mapCountryToEntity(CountryDomain countryDomain) {
	        return countryDomain != null ? new CountryEntity(countryDomain.getId(), countryDomain.getName()) : null;
	    }


}
