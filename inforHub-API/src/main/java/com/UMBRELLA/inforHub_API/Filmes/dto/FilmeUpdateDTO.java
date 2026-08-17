package com.UMBRELLA.inforHub_API.Filmes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeUpdateDTO {

    private Long id;
    private String nome;
    private String sinopse;
    private String genero;
    private int duracao;
    private String ondeAssistir;

    
}
