package com.UMBRELLA.inforHub_API.Animes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

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

    public String getNome() {
        return nome;
    }

     public String getGenero() {
        return genero;
    }

     public String getSinopse() {
        return sinopse;
    }

     public String getOndeAssistir() {
        return ondeAssistir;
    }

     public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

     public int getEpisodios() {
        return episodios;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

}
