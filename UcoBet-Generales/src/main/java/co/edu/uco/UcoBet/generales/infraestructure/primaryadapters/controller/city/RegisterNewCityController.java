package co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.city;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;

@RestController
@RequestMapping("/generales/api/v1/cities")
public class RegisterNewCityController {
	
	/*private RegisterNewCityInteractor registerNewCityInteractor;
	
	 public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor) {
		 this.registerNewCityInteractor=registerNewCityInteractor;
	 }*/
	

	@GetMapping
	public RegisterNewCityDto getDummy() {
		return RegisterNewCityDto.create("rionegro", UUIDHelper.getDefault());
	}

	@PostMapping
	public RegisterNewCityDto getDummy(@RequestBody RegisterNewCityDto data) {
		return data;
	}

}
