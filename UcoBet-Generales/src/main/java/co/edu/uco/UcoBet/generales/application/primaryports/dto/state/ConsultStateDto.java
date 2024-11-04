package co.edu.uco.UcoBet.generales.application.primaryports.dto.state;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.application.primaryports.dto.country.CountryDto;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;

public class ConsultStateDto {
	
	private UUID id;
	
	private String name;

	private CountryDto country;

	public ConsultStateDto(UUID id, String name, CountryDto country) {
		setId(id);
		setName(name);
		setCountry(country);
	}
	
	public ConsultStateDto() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setCountry(CountryDto.create());
	}
	
	public static final ConsultStateDto create(UUID id, String name, CountryDto country) {
		return new ConsultStateDto(id,name,country);
	}
	
	public static final ConsultStateDto create() {
		return new ConsultStateDto();
	}
	
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id,UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public CountryDto getCountry() {
		return country;
	}

	public void setCountry(CountryDto country) {
		this.country = ObjectHelper.getObjectHelper().getDefault(country, CountryDto.create());
	}

	
	
	

}
