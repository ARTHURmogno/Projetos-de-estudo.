package com.UMBRELLA.inforHub_API.Animes.model;

public class Anime{

    private Long id;
    private String nome;
    private String genero;
    private String sinopse;
    private String ondeAssistir;
    private int episodios;
    private int temporada;

    public Anime() {

    }

    public Anime(Long id, String nome, String genero, String sinopse, String ondeAssistir, int episodios, int temporada) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentExecpition("nome não pode ser nulo ou vazio.");
        }
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentExecpition("genero não pode ser nulo nem vazio.");
        }
        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentExecpition("sinopse não pode ser nulo nem vazio.");
        }
        if (ondeAssistir == null || ondeAssistir.isBlock()) {
            throw new IllegalArgumentExecpition("ondeAssistir não pode ser nulo nem vazio.");
        }
        if (episodios <= 0) {
            throw new IllegalArgumentExecpition("episodios não pode ser negativo nem 0.");
        }
        if (temporada == null || temporada < 1) {
            throw new IllegalArgumentExecpition("temporada não pode ser nullo nem negativo.");
        }
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.ondeAssistir = ondeAssistir;
        this.episodios = episodios;
        this.temporada = temporada;
    }

    // getters

    
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

    public int getEpisodios() {
        return episodios;
    }

    public int getTemporada() {
        return temporada;
    }

    // setters

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

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }
}

