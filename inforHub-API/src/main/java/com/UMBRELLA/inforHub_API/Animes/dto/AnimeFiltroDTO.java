package com.UMBRELLA.inforHub_API.Animes.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnimeFiltroDTO {

    private String nome;
    private String genero;
    private String ondeAssistir;
    private Integer anoDeLancamento;

    @Positive 
    private Integer anoMinimo;
    
    @Positive
    private Integer anoMaximo;
    
}
