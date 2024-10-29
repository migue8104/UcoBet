package co.edu.uco.UcoBet.generales.application.primaryports.dto.state;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.city.RegisterNewCityDto;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;

public class ConsultStateDto {
	
	private String name;

	private UUID country;

	public ConsultStateDto() {
		setName(TextHelper.EMPTY);
		setCountry(UUIDHelper.getDefault());
	}

	public ConsultStateDto(final String name, final UUID state) {
		setName(name);
		setCountry(state);
	}

	public static final ConsultStateDto create(final String name, final UUID state) {
		return new ConsultStateDto(name, state);
	}
	
	public static final ConsultStateDto create() {
		return new ConsultStateDto();
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public UUID getCountry() {
		return country;
	}

	public void setCountry(final UUID country) {
		this.country = UUIDHelper.getDefault(country, UUIDHelper.getDefault());
	}

}
