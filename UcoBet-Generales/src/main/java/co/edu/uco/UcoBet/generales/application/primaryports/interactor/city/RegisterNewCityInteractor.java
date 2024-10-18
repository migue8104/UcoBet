package co.edu.uco.UcoBet.generales.application.primaryports.interactor.city;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.InteractorWithOutReturn;
import jakarta.transaction.Transactional;


@Service
@Transactional
public interface RegisterNewCityInteractor extends InteractorWithOutReturn<RegisterNewCityDto>{
	
	

}
