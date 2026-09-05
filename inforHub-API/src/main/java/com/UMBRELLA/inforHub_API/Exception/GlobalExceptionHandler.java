package com.UMBRELLA.inforHub_API.Exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.UMBRELLA.inforHub_API.dto.ErroResponse;

import lombok.Getter;
import lombok.Setter;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> MethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> erros = ex.getBindingResult().getFieldErrors();

        Map<String, List<String>> errosPorCampo = new HashMap<>();

        for (FieldError erro : erros) {

        String campo = erro.getField();
        String mensagem = erro.getDefaultMessage();

        List<String> mensagens = errosPorCampo.getOrDefault(campo, new ArrayList<>());

        mensagens.add(mensagem);

        errosPorCampo.put(campo, mensagens);
    }

    ErroResponse erroResponse = new ErroResponse(400, errosPorCampo);

    return ResponseEntity.badRequest().body(erroResponse);

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
