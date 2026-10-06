package com.UMBRELLA.inforHub_API.Animes.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//import org.hibernate.annotations.TargetEmbeddable;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GeneroValidoValidador.class)
public @interface GeneroValido {

    String message() default "Gênero inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
