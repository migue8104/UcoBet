package co.edu.uco.UcoBet.generales.application.secondaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;

@Mapper
public interface CityEntityMapper {
	
	CityEntityMapper INSTANCE = Mappers.getMapper(CityEntityMapper.class);

	CityEntity toEntity(CityDomain domain);

	CityDomain toDomain(CityEntity entity);

	List<CityEntity> toEntityCollection(List<CityDomain> domainCollection);

	List<CityDomain> toDomainCollection(List<CityEntity> entityCollection);
	

}
