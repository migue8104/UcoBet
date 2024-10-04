package co.edu.uco.UcoBet.generales.domain;

import java.util.UUID;

public class Domain {
	
	private UUID id;
	
	protected Domain(final UUID id) {
		setId(id);
	}

	public UUID getId() {
		return id;
	}

	private void setId(final UUID id) {
		this.id = id;
	}

}
