package com.UMBRELLA.inforHub_API.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErroResponse {

    private int status;
    private String mensagem;
    private Map<String, List<String>> erros;
    //private String timestamp; 

   
    public ErroResponse(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public ErroResponse(int status, Map<String, List<String>> erros) {
        this.status = status;
        this.erros = erros;
    }

}

