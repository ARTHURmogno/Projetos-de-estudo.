package com.UMBRELLA.inforHub_API.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

import com.UMBRELLA.inforHub_API.Exception.ErroResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResponse> tratarOIllegalArgumentException(IllegalArgumentException ex) {
        ErroResponse erro = new ErroResponse(400, ex.getMessage());

        return ResponseEntity.badRequest().body(erro);
        }

}
