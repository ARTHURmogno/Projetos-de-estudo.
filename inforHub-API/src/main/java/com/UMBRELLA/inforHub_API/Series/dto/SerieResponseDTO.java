package com.UMBRELLA.inforHub_API.Series.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SerieResponseDTO {

    private Long id;
    private String nome;
    private String sinopse;
    private String genero;
    private Integer temporada;
    private Integer episodios;
    private Integer lancamento;
    private String ondeAssistir;

    public SerieResponseDTO() {

    }

    public SerieResponseDTO(Long id, String nome, String sinopse, String genero, Integer temporada, Integer episodios, Integer lancamento, String ondeAssistir) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.genero = genero;
        this.temporada = temporada;
        this.episodios = episodios;
        this.lancamento = lancamento;
        this.ondeAssistir = ondeAssistir;
    }

}

