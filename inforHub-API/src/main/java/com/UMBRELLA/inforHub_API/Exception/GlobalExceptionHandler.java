package com.UMBRELLA.inforHub_API.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.UMBRELLA.inforHub_API.dto.ErroResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResponse> tratarOIllegalArgumentException(IllegalArgumentException ex) {
        ErroResponse erro = new ErroResponse(400, ex.getMessage());

        return ResponseEntity.badRequest().body(erro);
        }
      // retorno http 404 not found com a mensagem personalizada
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResponse> tratarRecursoNaoEncontrado(ResourceNotFoundException ex) {

        ErroResponse erro = new ErroResponse(404, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }     

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErroResponse> tratarDuplicidadeDeRegistros(ResourceAlreadyExistsException ex) {
        ErroResponse erro = new ErroResponse(409, ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
}
