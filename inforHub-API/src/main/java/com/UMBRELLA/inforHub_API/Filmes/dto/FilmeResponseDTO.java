package com.UMBRELLA.inforHub_API.Filmes.dto;

public class FilmeResponseDTO {

    private Long id;
    private String nome;
    private String sinopse;
    private String genero;
    private int duracao;
    private String ondeAssistir;

    public FilmeResponseDTO() {

    }

    public FilmeResponseDTO(Long id, String nome, String sinopse, String genero, int duracao, String ondeAssistir) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.genero = genero;
        this.duracao = duracao;
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

    public void setNome(String nome) {
        this.nome = nome;
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
