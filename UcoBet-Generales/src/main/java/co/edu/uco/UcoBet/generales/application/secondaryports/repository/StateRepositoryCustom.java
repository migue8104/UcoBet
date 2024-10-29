package co.edu.uco.UcoBet.generales.application.secondaryports.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.StateEntity;
@Repository
public interface StateRepositoryCustom {
	
	List<StateEntity> findByFilter(StateEntity filter);
	

}
