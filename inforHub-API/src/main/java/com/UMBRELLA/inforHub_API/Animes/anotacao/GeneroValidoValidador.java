package com.UMBRELLA.inforHub_API.Animes.anotacao;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GeneroValidoValidador implements ConstraintValidator<GeneroValido, String> {

    @Override 
    public boolean isValid(String genero, ConstraintValidatorContext context) {
        
        if (genero == null) {
            return true;
        }

        return generosValidos.contains(genero);
    }
}
