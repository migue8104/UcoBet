package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityIsNotUsedRule;


@Service
public class CityIsNotUsedRuleImpl implements CityIsNotUsedRule{
	
	private CityRepository cityRepository;
	

	public CityIsNotUsedRuleImpl(final CityRepository cityRepository) {
		this.cityRepository= cityRepository;
	}


	@Override
	public void execute(UUID data) {
		
		
	}

}
