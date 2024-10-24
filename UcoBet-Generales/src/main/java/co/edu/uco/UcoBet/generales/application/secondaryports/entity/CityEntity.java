package co.edu.uco.UcoBet.generales.application.secondaryports.entity;

import java.util.UUID;

import co.edu.uco.UcoBet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.UcoBet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "City")
public class CityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "state")
	private StateEntity state;

	CityEntity() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setState(StateEntity.create());
	}

	public CityEntity(final UUID id, final String name, final StateEntity state) {
		setId(id);
		setName(name);
		setState(state);
	}

	public static final CityEntity create() {
		return new CityEntity();
	}

	public static final CityEntity create(final UUID id, final String name, final StateEntity state) {
		return new CityEntity(id, name, state);
	}

	public static final CityEntity create(final UUID id) {
		return new CityEntity(id, TextHelper.EMPTY, StateEntity.create());
	}

	public UUID getId() {
		return id;
	}

	public CityEntity setId(final UUID id) {
		this.id = UUIDHelper.getDefault();
		return this;
	}

	public String getName() {
		return name;
	}

	public CityEntity setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}

	public StateEntity getState() {
		return state;
	}

	public CityEntity setState(final StateEntity state) {
		this.state = ObjectHelper.getDefault(state, StateEntity.create());
		return this;
	}
}
