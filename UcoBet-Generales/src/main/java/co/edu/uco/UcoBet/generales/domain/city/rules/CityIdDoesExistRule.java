package co.edu.uco.UcoBet.generales.domain.city.rules;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.domain.DomainRule;


@Service
public interface CityIdDoesExistRule extends DomainRule<UUID>{

}
