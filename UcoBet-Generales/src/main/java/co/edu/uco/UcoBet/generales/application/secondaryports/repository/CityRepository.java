package co.edu.uco.UcoBet.generales.application.secondaryports.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, UUID>,CityRepositoryCustom{
	

}
