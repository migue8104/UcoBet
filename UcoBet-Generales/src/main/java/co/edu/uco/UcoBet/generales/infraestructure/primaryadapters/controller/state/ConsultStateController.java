package co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.state;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.state.ConsultStateDto;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.state.ConsultStateInteractor;
import co.edu.uco.UcoBet.generales.application.primaryports.interactor.state.impl.ConsultStateInteractorImpl;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.UcoBetException;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.MessageCatalogStrategy;
import co.edu.uco.UcoBet.generales.crosscutting.exceptions.messageCatalog.data.CodigoMensaje;
import co.edu.uco.UcoBet.generales.infraestructure.primaryadapters.controller.response.StateResponse;

@RestController
@RequestMapping("/generales/api/v1/states")
public class ConsultStateController {

	private ConsultStateInteractor consultStateInteractor;
	
	public ConsultStateController (ConsultStateInteractor consultStateInteractor) {
		this.consultStateInteractor =consultStateInteractor;
	}
	
	@GetMapping
	public ResponseEntity<StateResponse> consultar(){
		var httpStatusCode = HttpStatus.ACCEPTED;
		var stateResponse = new StateResponse();
		
		try {
			var consultStateDto = ConsultStateDto.create();
			
			stateResponse.setDatos(consultStateInteractor.execute(consultStateDto));
			stateResponse.getMensajes().add("estados consultados exitosamente");
		} catch (UcoBetException exception) {
			httpStatusCode = HttpStatus.BAD_REQUEST;
			stateResponse.getMensajes().add(exception.getMessage());
			exception.printStackTrace();
		}catch (Exception exception) {
			httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			var mensajeUsuario = "error al consultar los estados";
			stateResponse.getMensajes().add(mensajeUsuario);
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(stateResponse , httpStatusCode);
	}
}
