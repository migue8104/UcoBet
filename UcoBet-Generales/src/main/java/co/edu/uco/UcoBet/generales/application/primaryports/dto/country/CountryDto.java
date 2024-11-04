package co.edu.uco.UcoBet.generales.application.primaryports.dto.country;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;

import co.edu.uco.UcoBet.generales.domain.country.CountryDomain;

public class CountryDto {

	private UUID id;

	private String name;

	public CountryDto(final UUID id, final String name) {
		setId(id);
		setName(name);
	}

	public CountryDto() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}

	public static final CountryDto create(final UUID id, final String name) {
		return new CountryDto(id, name);
	}

	public static final CountryDto create() {
		return new CountryDto();
	}

	public final String getName() {
		return name;
	}

	private final void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

}
