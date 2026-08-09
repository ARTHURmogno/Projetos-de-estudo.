package com.UMBRELLA.inforHub_API.Filmes.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FilmeResponseDTO {

    private Long id;
    private String nome;
    private String sinopse;
    private String genero;
    private int duracao;
    private String ondeAssistir;

    public FilmeResponseDTO() {

    }

    public FilmeResponseDTO(Long id, String nome, String sinopse, String genero, int duracao, String ondeAssistir) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.genero = genero;
        this.duracao = duracao;
        this.ondeAssistir = ondeAssistir;
    }

}