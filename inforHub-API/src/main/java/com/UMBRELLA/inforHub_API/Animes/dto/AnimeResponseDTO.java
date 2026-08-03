package com.UMBRELLA.inforHub_API.Animes.dto;

public class AnimeResponseDTO {

    private Long id;
    private String nome;
    private String genero;
    private String sinopse;
    private String ondeAssistir;
    private int anoDeLancamento;
    private int episodios;
    private int temporada;

    public AnimeResponseDTO() {

    }

    public AnimeResponseDTO(Long id, String nome, String genero, String sinopse, String ondeAssistir, int anoDeLancamento, int episodios, int temporada) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.ondeAssistir = ondeAssistir;
        this.anoDeLancamento = anoDeLancamento;
        this.episodios = episodios;
        this.temporada = temporada;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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