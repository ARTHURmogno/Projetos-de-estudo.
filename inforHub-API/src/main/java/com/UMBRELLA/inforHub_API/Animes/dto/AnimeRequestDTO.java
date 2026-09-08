package com.UMBRELLA.inforHub_API.Animes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Setter
@Getter
public class AnimeRequestDTO {


    @NotBlank(message = "Nome não pode ser nulo nem vazio.")
    @Size(message = "nome deve está entre 2 é 500 caracteres", min = 2, max = 500)
    private String nome;

    @NotBlank(message = "Gênero não pode ser nulo nem vazio.")
    private String genero;

    @NotBlank(message = "Sinopse não pode ser nulo nem vazio.")
    @Size(message = "sinopse deve está entre 20 é 500 caracteres", min = 20, max = 500)
    private String sinopse;

    @NotBlank(message = "Onde Assistir não pode ser nulo nem vazio.")
    private String ondeAssistir;

    @Positive(message = "ano de lancamento deve está entre 1900 é 2100")
    @Min(1900)
    @Max(2100)
    @NotNull(message = "Ano de Lancamento não pode ser nulo.")
    private Integer anoDeLancamento;

    @Positive(message = "episódios não pode ser negativo")
    @NotNull(message = "episódio não pode ser nulo.")
    private Integer episodios;

    @Positive(message = "temporada não pode ser negativo")
    @NotNull(message = "temporada não pode ser nulo.")
    private Integer temporada;

    public AnimeRequestDTO() {

    }

    public AnimeRequestDTO(String nome, String genero, String sinopse, String ondeAssistir, Integer anoDeLancamento, Integer episodios, Integer temporada) {
        this.nome = nome;
        this.genero = genero;
        this.sinopse = sinopse;
        this.ondeAssistir = ondeAssistir;
        this.anoDeLancamento = anoDeLancamento;
        this.episodios = episodios;
        this.temporada = temporada;
    }

}
