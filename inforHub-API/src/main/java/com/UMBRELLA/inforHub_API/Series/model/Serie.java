package com.UMBRELLA.inforHub_API.Series.model;

public class Serie {

    private Long id;
    private String nome;
    private String sinopse;
    private String genero;
    private int temporada;
    private int episodios;
    private String lancamento;
    private String ondeAssistir;

    public Serie() {

    }

    public Serie(Long id, String nome, String sinopse, String genero, int temporada, int episodios, String lancamento, String ondeAssistir) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pose ser nulo nem vazio.");
        }
        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("Sinopse não pose ser nulo nem vazio.");
        }
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("Gênero não pose ser nulo nem vazio.");
        }
        if (temporada <= 0) {
            throw new IllegalArgumentException("Temporada não pode ser negativo nem 0.");
        }
        if (episodios <= 0) {
            throw new IllegalArgumentException("Episódio não pose ser negativo nem 0.");
        }
        if (lancamento == null || lancamento.isBlank()) {
            throw new IllegalArgumentException("Lançamento não pose ser nulo nem vazio.");
        }
        if (ondeAssistir == null || ondeAssistir.isBlank()) {
            throw new IllegalArgumentException("Onde Assistir não pode ser nulo nem vazio.");
        }
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

    public String getLancamento() {
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
         if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pose ser nulo nem vazio.");
        }

        this.nome = nome;
    }

    public void setSinopse(String sinopse) {
        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("Sinopse não pose ser nulo nem vazio.");
        }

        this.sinopse = sinopse;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("Gênero não pose ser nulo nem vazio.");
        }

        this.genero = genero;
    }

    public void setTemporada(int temporada) {
        if (temporada <= 0) {
            throw new IllegalArgumentException("Temporada não pode ser negativo nem 0.");
        }

        this.temporada = temporada;
    }

    public void setEpisodios(int episodios) {
         if (episodios <= 0) {
            throw new IllegalArgumentException("Episódio não pose ser negativo nem 0.");
        }

        this.episodios = episodios;
    }

    public void setOndeAssistir(String ondeAssistir) {
        if (ondeAssistir == null || ondeAssistir.isBlank()) {
            throw new IllegalArgumentException("Onde Assistir não pode ser nulo nem vazio.");
        }

        this.ondeAssistir = ondeAssistir;
    }

}
