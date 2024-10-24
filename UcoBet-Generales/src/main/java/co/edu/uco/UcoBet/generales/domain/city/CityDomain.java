package co.edu.uco.UcoBet.generales.domain.city;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.domain.Domain;
import co.edu.uco.UcoBet.generales.domain.state.StateDomain;

public class CityDomain extends Domain {

	private String name;
	private StateDomain state;

	public CityDomain(UUID id, String name, StateDomain state) {
		super(id);
		setState(state);
		setName(name);
	}

	public static final CityDomain create(UUID id, String name, StateDomain state) {
		return new CityDomain(id, name, state);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public StateDomain getState() {
		return state;
	}

	private void setState(StateDomain state) {
		this.state = state;
	}

}
