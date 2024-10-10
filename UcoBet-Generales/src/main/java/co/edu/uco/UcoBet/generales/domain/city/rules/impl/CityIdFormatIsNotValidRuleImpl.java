package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import co.edu.uco.UcoBet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityIdFormatIsNotValidRuleImpl extends RuleUcoBetException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CityIdFormatIsNotValidRuleImpl(String technicalMessage, String userMessage, Exception rootException) {
		super(technicalMessage, userMessage, rootException);
		// TODO Auto-generated constructor stub
	}
	
	public static final CityIdFormatIsNotValidRuleImpl create() {
		var userMessage="la ciudad tiene un identificar como formato no valido correspondiente";
		return new CityIdFormatIsNotValidRuleImpl(userMessage, userMessage, new Exception());
				
	}

}
