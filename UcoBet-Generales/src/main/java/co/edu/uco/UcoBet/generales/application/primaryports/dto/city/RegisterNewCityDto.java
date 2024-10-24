package co.edu.uco.UcoBet.generales.application.primaryports.dto.city;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;

public class RegisterNewCityDto {
	private String name;

	private UUID state;

	public RegisterNewCityDto() {
		setName(TextHelper.EMPTY);
		setState(UUIDHelper.getDefault());
	}

	public RegisterNewCityDto(final String name, final UUID state) {
		setName(name);
		setState(state);
	}

	public static final RegisterNewCityDto create(final String name, final UUID state) {
		return new RegisterNewCityDto(name, state);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public UUID getState() {
		return state;
	}

	public void setState(final UUID state) {
		this.state = UUIDHelper.getDefault(state, UUIDHelper.getDefault());
	}
}
