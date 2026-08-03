package com.UMBRELLA.inforHub_API.Series.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class SerieRequestDTO {

    @NotBlank(message = "Nome não pose ser nulo nem vazio.")
    @Size(min = 2, max = 50)
    private String nome;
    @NotBlank(message = "Sinopse não pose ser nulo nem vazio.")
    @Size(min = 20, max = 500)
    private String sinopse;
    @NotBlank(message = "Gênero não pose ser nulo nem vazio.")
    @Size(min = 2, max = 500)
    private String genero;
    @Positive(message = "Temporada não pode ser negativo nem 0.")
    @Min(1)
    private int temporada;
    @Positive(message = "Episódio não pose ser negativo nem 0.")
    @Min(1)
    private int episodios;
    @Positive(message = "Lançamento não pose ser nulo nem vazio.")
    @Min(1900)
    @Max(2100)
    private int lancamento;
    @NotBlank(message = "Onde Assistir não pode ser nulo nem vazio.")
    @Size(min = 2, max = 20)
    private String ondeAssistir;

    public SerieRequestDTO() {

    }

    public SerieRequestDTO(String nome, String sinopse, String genero, int temporada, int episodios, int lancamento, String ondeAssistir) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.genero = genero;
        this.temporada = temporada;
        this.episodios = episodios;
        this.lancamento = lancamento;
        this.ondeAssistir = ondeAssistir;
    }

    // getters

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public int getTemporada() {
        return temporada;
    }

    public int getEpisodios() {
        return episodios;
    }

    public int getLancamento() {
        return lancamento;
    }

    public String getOndeAssistir() {
        return ondeAssistir;
    }

    // setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public void setLancamento(int lancamento) {
        this.lancamento = lancamento;
    }

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
    }

}
