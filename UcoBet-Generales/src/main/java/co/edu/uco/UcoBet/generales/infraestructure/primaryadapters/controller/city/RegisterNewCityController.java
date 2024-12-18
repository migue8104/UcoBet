package co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.UcoBetException;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.response.CityResponse;
import co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.services.SanitizerService;
import co.edu.uco.UcoBet.generales.infraestructure.secondaryadapters.data.MessageCatalogService;

@RestController
@RequestMapping("/generales/api/v1/cities")
public class RegisterNewCityController {
	
	private RegisterNewCityInteractor registerNewCityInteractor;
	
	
	private final SanitizerService sanitizerService;

	
	@Autowired
	private MessageCatalogService messageCatalogService;
	
	 public RegisterNewCityController(final RegisterNewCityInteractor registerNewCityInteractor,SanitizerService sanitizerService) {
		 this.registerNewCityInteractor=registerNewCityInteractor;
		 this.sanitizerService = sanitizerService;
	 }
	

	@GetMapping
	public RegisterNewCityDto getDummy() {
		return RegisterNewCityDto.create("rionegro", UUIDHelper.getDefault());
	}

	@PostMapping
	public ResponseEntity<CityResponse> crear(@RequestBody RegisterNewCityDto city) {

		var httpStatusCode = HttpStatus.ACCEPTED;
		var ciudadResponse = new CityResponse();

		try {
			
	        String sanitizedName = sanitizerService.sanitize(city.getName());
	        RegisterNewCityDto citySanitized = RegisterNewCityDto.create(sanitizedName, city.getState());


			registerNewCityInteractor.execute(citySanitized);
			ciudadResponse.getMensajes().add("ciudad creada exitosamente");

		} catch (final UcoBetException excepcion) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			ciudadResponse.getMensajes().add(excepcion.getUserMessage());
			excepcion.printStackTrace();
		} catch (final Exception excepcion) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;

			var mensajeUsuario = "se ha presentado un prblema tratando de registar la nueva Ciudad";
			ciudadResponse.getMensajes().add(mensajeUsuario);
			excepcion.printStackTrace();

		}

		return new ResponseEntity<>(ciudadResponse, httpStatusCode);

	}

}
