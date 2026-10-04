package com.UMBRELLA.inforHub_API.Animes.anotacao;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeFiltroDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnoMinimoMenorQueMaximoValidador implements ConstraintValidator<AnoMinimoMenorQueMaximo, AnimeFiltroDTO> {

    public boolean isValid(AnimeFiltroDTO filtro, ConstraintValidatorContext context) {

        if (filtro.getAnoMinimo() == null) {
            return true;
        }

        if (filtro.getAnoMaximo() == null) {
            return true;
        }

        if (filtro.getAnoMinimo() <= filtro.getAnoMaximo()) {
            return true;
        }

        return false;

    }

}
