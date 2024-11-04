package co.edu.uco.UcoBet.generales.application.usecase.city.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.UcoBet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.UcoBet.generales.application.secondaryports.notificationservice.NotificationService;
import co.edu.uco.UcoBet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.UcoBet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.UcoBet.generales.application.usecase.city.RegisterNewCityRuleValidator;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.UcoBet.generales.domain.city.CityDomain;
import co.edu.uco.UcoBet.generales.infraestructure.secondaryadapters.data.MessageCatalogService;

@Service
public final class RegisterNewCityImpl implements RegisterNewCity {

	private CityRepository cityRepository;
	private RegisterNewCityRuleValidator registerNewCityRuleValidator;
	private NotificationService notificationService;
	private MessageCatalogService messageCatalogService;

	public RegisterNewCityImpl(CityRepository cityRepository, RegisterNewCityRuleValidator registerNewCityRuleValidator,
			NotificationService notificationService, MessageCatalogService messageCatalogService) {
		this.cityRepository = cityRepository;
		this.registerNewCityRuleValidator = registerNewCityRuleValidator;
		this.notificationService = notificationService;
		this.messageCatalogService = messageCatalogService;

	}

	@Override
	public void execute(final CityDomain data) {
		// validar reglas de negocio
		registerNewCityRuleValidator.validate(data);

		var id = generarIdentificadorCiudad();
		System.out.println(id);

		// mapper de domain a entity
		var cityEntity = CityEntity.create().setId(id).setName(data.getName())
				.setState(StateEntityMapper.INSTANCE.toEntity(data.getState()));

		// Registar la ciudad
		cityRepository.save(cityEntity);

		String subject = "Nueva ciudad creada";
		String content = "La ciudad " + data.getName() + " ha sido creada exitosamente.";
		notificationService.send(messageCatalogService.getMessage("M0002"), subject, content); // Reemplaza con la dirección de correo
																				// del administrador
		// TODO: challenge for you:send notification to administrator when city is
		// created!Email information
		// is saved in key vault.......You must retrieve email from your key vault
		// configuration.....

		// TODO:the last challenge is:i should be able to change the subject and body of
		// email dinamically!(Parameters building block)

	}

	private final UUID generarIdentificadorCiudad() {
		UUID id = UUIDHelper.generate();
		boolean existeId = true;

		while (existeId) {
			id = UUIDHelper.generate();
			var resultados = cityRepository.findById(id);
			existeId = !resultados.isEmpty();
		}
		return id;
	}

}
