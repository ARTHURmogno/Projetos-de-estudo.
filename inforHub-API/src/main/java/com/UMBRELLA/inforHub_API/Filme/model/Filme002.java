package com.UMBRELLA.inforHub_API.model;


public class Filme002 {

    private Long id;
    private String titulo;
    private String sinopse;
    private String genero;
    private int duracao;
    private String ondeAssistir;

    public Filme002() {

    }

    public Filme002(Long id, String titulo, String sinopse, String genero, int duracao, String ondeAssistir) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.duracao = duracao;
        this.ondeAssistir = ondeAssistir;

    }
    // getters

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getOndeAssistir() {
        return ondeAssistir;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setOndeAssistir(String ondeAssistir) {
        this.ondeAssistir = ondeAssistir;
    }

    
}
