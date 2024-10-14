package co.edu.uco.UcoBet.generales.application.secondaryports.entity;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Country")
public final class CountryEntity {
	
	@Id
	@Column(name="id")
	private UUID id;
	
	@Column(name="name")
	private String name;
	
	public CountryEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}
	
	public CountryEntity(final UUID id,final String name) {
		setId(id);
		setName(name);
		
	}
	
	public static final CountryEntity create() {
		return new CountryEntity();
	}
	
	public static final CountryEntity create(final UUID id) {
		return new CountryEntity(id,TextHelper.EMPTY);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id,UUIDHelper.getDefault());
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = TextHelper.getDefault(name,TextHelper.EMPTY);
	}


	
	
	

}