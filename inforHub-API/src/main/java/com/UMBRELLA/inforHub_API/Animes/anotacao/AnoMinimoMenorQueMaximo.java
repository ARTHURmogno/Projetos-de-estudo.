package com.UMBRELLA.inforHub_API.Animes.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target (ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AnoMinimoMenorQueMaximoValidador.class)
public @interface AnoMinimoMenorQueMaximo {


    String message() default "anoMinimo deve ser menor ou igual a anoMaximo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


