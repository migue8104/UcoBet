package co.edu.uco.UcoBet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.UcoBet.generales.domain.city.exception.CityNameFormatIsNotValidException;
import co.edu.uco.UcoBet.generales.domain.city.rules.CityNameFormatIsValidRule;


@Service
public class CityNameFormatIsValidRuleImpl implements CityNameFormatIsValidRule {

    @Override
    public void execute(String data) {
        if (!data.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            throw CityNameFormatIsNotValidException.create();
        }
    }
}
