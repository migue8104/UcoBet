package co.edu.uco.UcoBet.generales.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.CountryEntity;
import co.edu.uco.UcoBet.generales.domain.country.CountryDomain;

@Mapper
public interface CountryEntityMapper {
	
	CountryEntityMapper INSTANCE = Mappers.getMapper(CountryEntityMapper.class);

	CountryEntity toEntity(CountryDomain domain);

	List<CountryEntity> toEntityCollection(List<CountryDomain> domainCollection);


}
