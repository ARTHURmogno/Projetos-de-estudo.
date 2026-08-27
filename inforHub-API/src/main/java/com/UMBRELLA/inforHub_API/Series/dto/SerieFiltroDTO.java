package com.UMBRELLA.inforHub_API.Series.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SerieFiltroDTO {

    private String nome;
    private String genero;
    private String ondeAssistir;
    private Integer lancamento;
    
}
