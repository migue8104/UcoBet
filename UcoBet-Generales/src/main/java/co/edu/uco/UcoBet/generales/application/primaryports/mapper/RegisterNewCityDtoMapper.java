package co.edu.uco.UcoBet.generales.application.primaryports.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;

@Mapper
public interface RegisterNewCityDtoMapper {
	
	RegisterNewCityDtoMapper INSTANCE = Mappers.getMapper(RegisterNewCityDtoMapper.class);
	
    // Mapeo de RegisterNewCityDto a CityDomain
    @Mapping(source = "state", target = "state", qualifiedByName = "mapState")
    CityDomain toDomain(RegisterNewCityDto dto);

    // Método personalizado para mapear UUID a StateDomain, anotado con @Named
    @Named("mapState")
    default StateDomain mapState(UUID stateId) {
        // Crear un StateDomain usando solo el UUID, otros valores pueden ser nulos o por defecto
        return StateDomain.create(stateId, null, null);
    }
    
}
