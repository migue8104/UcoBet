package co.edu.uco.UcoBet.generales.application.secondaryports.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.CityEntity;
@Repository
public interface CityRepositoryCustom {
	
	List<CityEntity> findByFilter(CityEntity filter);
	

}
