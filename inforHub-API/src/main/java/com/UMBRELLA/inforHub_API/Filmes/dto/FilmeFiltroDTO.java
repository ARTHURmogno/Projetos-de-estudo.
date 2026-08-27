package com.UMBRELLA.inforHub_API.Filmes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeFiltroDTO {

    private String nome;
    private String genero;
    private String ondeAssistir;
    
}
