package com.UMBRELLA.inforHub_API.Series.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SerieUpdateDTO {

    private String nome;
    private String sinopse;
    private String genero;
    private Integer temporada;
    private Integer episodios;
    private Integer lancamento;
    private String ondeAssistir;


}
