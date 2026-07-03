package com.UMBRELLA.inforHub_API.Animes.model;

public class Anime{

    private Long id;
    private String nome;
    private String genero;
    private String sinopse;
    private String ondeAssistir;
    private int anoDeLancamento;
    private int episodios;
    private int temporada;

    public Anime() {

    }

    public Anime(Long id, String nome, String genero, String sinopse, String ondeAssistir, int anoDeLancamento, int episodios, int temporada) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("nome não pode ser nulo ou vazio.");
        }
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("genero não pode ser nulo nem vazio.");
        }
        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("sinopse não pode ser nulo nem vazio.");
        }
        if (ondeAssistir == null || ondeAssistir.isBlank()) {
            throw new IllegalArgumentException("ondeAssistir não pode ser nulo nem vazio.");
        }
        if (anoDeLancamento < 1000 || anoDeLancamento > 3000) {
            throw new IllegalArgumentException("ano de lançamento não; pode ser 0 nem menor que 1500.");
        }
        if (episodios <= 0) {
            throw new IllegalArgumentException("episodios não pode ser negativo nem 0.");
        }
        if (temporada <= 0) {
            throw new IllegalArgumentException("temporada não pode ser nullo nem negativo.");
        }
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.ondeAssistir = ondeAssistir;
        this.anoDeLancamento = anoDeLancamento;
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

    public int getAnoDeLancamento() {
        return anoDeLancamento;
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
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório:");
        }

        this.nome = nome;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("Genero obrigatório:");
        }

        this.genero = genero;
    }
    
    public void setSinopse(String sinopse) {
        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("Sinopse obrigatírio:");
        }

        this.sinopse = sinopse;
    }

    public void setOndeAssistir(String ondeAssistir) {
        if (ondeAssistir == null || ondeAssistir.isBlank()) {
            throw new IllegalArgumentException("ondeAssistir obrigatório:");
        }

        this.ondeAssistir = ondeAssistir;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        if (anoDeLancamento < 1000 || anoDeLancamento > 3000) {
            throw new IllegalArgumentException("Ano de lançamento inválido:");
        }

        this.anoDeLancamento = anoDeLancamento;
    }

    public void setEpisodios(int episodios) {
        if (episodios <= 0) {
            throw new IllegalArgumentException("Episodios não pode ser 0 ou negativo:");
        }

        this.episodios = episodios;
    }

    public void setTemporada(int temporada) {
        if (temporada <= 0) {
            throw new IllegalArgumentException("Temporada não pode ser 0 ou negativo:");
        }
        
        this.temporada = temporada;
    }
}

