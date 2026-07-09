package com.UMBRELLA.inforHub_API.Filmes.model;


public class Filme {

    private Long id;
    private String titulo;
    private String sinopse;
    private String genero;
    private int duracao;
    private String ondeAssistir;

    public Filme() {

    }

    public Filme(Long id, String titulo, String sinopse, String genero, int duracao, String ondeAssistir) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo não pode ser vazio nem nulo.");
        }
        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("Sinopse não pode ser vazio nem nulo.");
        }
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("Gênero não pode ser vazio nem nulo.");
        }
        if (duracao <= 0) {
            throw new IllegalArgumentException("Duração não pode ser menor que 0 é nem iqual a 0.");
        }
        if (ondeAssistir == null || ondeAssistir.isBlank()) {
            throw new IllegalArgumentException("Onde Assistir não pode ser vazio nem nulo.");
        }
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
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo é obrigatório.");
        }
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        if (sinopse == null || sinopse.isBlank()) {
            throw new IllegalArgumentException("Sinopse é obrigatório.");
        }
        this.sinopse = sinopse;
    }

    public void setGenero(String genero) {
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("Gênero é obrigatório.");
        }
        this.genero = genero;
    }

    public void setDuracao(int duracao) {
        if (duracao <= 0) {
            throw new IllegalArgumentException("Duração é obrigatório."); 
        }
        this.duracao = duracao;
    }

    public void setOndeAssistir(String ondeAssistir) {
        if (ondeAssistir == null || ondeAssistir.isBlank()) {
            throw new IllegalArgumentException("Onde Assistir é obrigatório.");
        }
        this.ondeAssistir = ondeAssistir;
    }

    
}
