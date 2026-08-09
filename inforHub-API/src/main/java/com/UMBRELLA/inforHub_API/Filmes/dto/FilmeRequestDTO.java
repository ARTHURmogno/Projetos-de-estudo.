package com.UMBRELLA.inforHub_API.Filmes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FilmeRequestDTO {

    @NotBlank(message = "Titulo não pode ser vazio nem nulo.")
    @Size(min = 2, max = 50)
    private String nome;

    @NotBlank(message = "Sinopse não pode ser vazio nem nulo.")
    @Size(min = 20, max = 500)
    private String sinopse;

    @NotBlank(message = "Gênero não pode ser vazio nem nulo.")
    @Size(min = 2, max = 500)
    private String genero;

    @Positive(message = "Duração não pode ser menor que 0 é nem iqual a 0.")
    private int duracao;

    @NotBlank(message = "Onde Assistir não pode ser vazio nem nulo.")
    @Size(min = 2, max = 500)
    private String ondeAssistir;

    public FilmeRequestDTO() {

    }

    public FilmeRequestDTO(String nome, String sinopse, String genero, int duracao, String ondeAssistir) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.genero = genero;
        this.duracao = duracao;
        this.ondeAssistir = ondeAssistir;
    }

}
    