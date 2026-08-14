package com.UMBRELLA.inforHub_API.Animes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnimeUpdateDTO {

    private String nome;
    private String genero;
    private String sinopse;
    private String ondeAssistir;
    private Integer anoDeLancamento;
    private Integer episodios;
    private Integer temporada;

}
