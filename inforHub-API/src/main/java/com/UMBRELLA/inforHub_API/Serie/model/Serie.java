package com.UMBRELLA.inforHub_API.model;

public class Serie {

    private Long id;
    private String nome;
    private String sinopse;
    private String genero;
    private int temporada;
    private int episodios;
    private Stirng lancamento;
    private String ondeAssistir;

    public Serie() {

    }

    public Serie(Long id, String nome, String sinopse, Stirng genero, int temporada, int episodios, String lancamento, String ondeAssistir) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.genero = genero;
        this.temporada = temporada;
        this.episodios = episodios;
        this.lancamento = lancamento;
        this.ondeAssistir = ondeAssistir;
    }

    // getters

    public Long getId() {
        return id;
    }

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

    public Stirng getLancamento() {
        return lancamento;
    }

    public String getOndeAssistir() {
        return ondeAssistir;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
    }

}
