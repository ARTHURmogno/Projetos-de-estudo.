package com.UMBRELLA.inforHub_API.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErroResponse {

    private int status;
    private String mensagem;
    //private String timestamp;

}
