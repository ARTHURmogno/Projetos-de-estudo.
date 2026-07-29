package com.UMBRELLA.inforHub_API.Animes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "Animes")
public class Anime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 500)
    private String nome;

    @NotBlank
    private String genero;

    @NotBlank
    @Size(min = 20, max = 500)
    private String sinopse;

    @NotBlank
    private String ondeAssistir;

    @Positive
    @Min(1900)
    @Max(2100)
    private int anoDeLancamento;

    @Positive
    private int episodios;
    
    @Positive
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

