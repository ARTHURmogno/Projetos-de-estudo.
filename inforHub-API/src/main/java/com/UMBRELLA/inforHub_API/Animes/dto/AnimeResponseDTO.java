package com.UMBRELLA.inforHub_API.Animes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimeResponseDTO {

    private Long id;
    private String nome;
    private String genero;
    private String sinopse;
    private String ondeAssistir;
    private int anoDeLancamento;
    private int episodios;
    private int temporada;

}