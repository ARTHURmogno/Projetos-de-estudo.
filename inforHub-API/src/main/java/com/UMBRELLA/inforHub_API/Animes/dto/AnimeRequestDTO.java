package com.UMBRELLA.inforHub_API.Animes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Setter
@Getter
public class AnimeRequestDTO {

    @NotBlank
    @Size(min = 2, max = 50)
    private String nome;
    @NotBlank
    private String genero;
    @NotBlank
    @Size(min = 20, max = 500)
    private String sinopse;
    @NotBlank
    @Size(min = 2, max = 50)
    private String ondeAssistir;
    @Positive
    @Min(1900)
    @Max(2100)
    private int anoDeLancamento;
    @Positive
    private int episodios;
    @Positive
    private int temporada;

    public AnimeRequestDTO() {

    }

    public AnimeRequestDTO(String nome, String genero, String sinopse, String ondeAssistir, int anoDeLancamento, int episodios, int temporada) {
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.ondeAssistir = ondeAssistir;
        this.anoDeLancamento = anoDeLancamento;
        this.episodios = episodios;
        this.temporada = temporada;
    }

}
