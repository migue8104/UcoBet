package co.edu.uco.UcoBet.generales.domain.state;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.domain.Domain;
import co.edu.uco.UcoBet.generales.domain.country.CountryDomain;

public class StateDomain extends Domain {

	private String name;
	private CountryDomain country;

	public StateDomain(UUID id, String name, CountryDomain country) {
		super(id);
		setCountry(country);
		setName(name);
	}

	public static final StateDomain create(UUID id, String name, CountryDomain country) {
		return new StateDomain(id, name, country);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public CountryDomain getCountry() {
		return country;
	}

	private void setCountry(CountryDomain country) {
		this.country = country;
	}

}
