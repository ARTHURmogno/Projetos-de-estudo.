package com.UMBRELLA.inforHub_API.Series.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SerieRequestDTO {

    @NotBlank(message = "Nome não pose ser nulo nem vazio.")
    @Size(min = 2, max = 50)
    private String nome;
    @NotBlank(message = "Sinopse não pose ser nulo nem vazio.")
    @Size(min = 20, max = 500)
    private String sinopse;
    @NotBlank(message = "Gênero não pose ser nulo nem vazio.")
    @Size(min = 2, max = 500)
    private String genero;
    @Positive(message = "Temporada não pode ser negativo nem 0.")
    @Min(1)
    private Integer temporada;
    @Positive(message = "Episódio não pose ser negativo nem 0.")
    @Min(1)
    private Integer episodios;
    @Positive(message = "Lançamento não pose ser nulo nem vazio.")
    @Min(1900)
    @Max(2100)
    private Integer lancamento;
    @NotBlank(message = "Onde Assistir não pode ser nulo nem vazio.")
    @Size(min = 2, max = 20)
    private String ondeAssistir;

    public SerieRequestDTO() {

    }

    public SerieRequestDTO(String nome, String sinopse, String genero, Integer temporada, Integer episodios, Integer lancamento, String ondeAssistir) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.genero = genero;
        this.temporada = temporada;
        this.episodios = episodios;
        this.lancamento = lancamento;
        this.ondeAssistir = ondeAssistir;
    }

}
