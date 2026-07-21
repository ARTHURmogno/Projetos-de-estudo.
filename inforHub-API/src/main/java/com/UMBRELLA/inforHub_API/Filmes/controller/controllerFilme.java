package com.UMBRELLA.inforHub_API.Filmes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.UMBRELLA.inforHub_API.Filmes.model.Filme;
import com.UMBRELLA.inforHub_API.Filmes.service.FilmeService;

@RestController
public class controllerFilme {

    private final FilmeService filmeService;

    public controllerFilme(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping("/filme")
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme filme) {

        return ResponseEntity.ok(filmeService.adicionarFilme(filme));
    
    }

    @GetMapping("/filmes")
    public ResponseEntity<Long> listarFilmes() {
        return ResponseEntity.ok(filmeService.todosOsFilmes());
    }

    @GetMapping("/filme/genero/{genero}")
    public ResponseEntity<List<Filme>> buscarPorGenero(@PathVariable String genero) {

        return ResponseEntity.ok(filmeService.buscarPorGenero(genero));
    }

    @GetMapping("/filme/Plataforma/{ondeAssistir}")
    public ResponseEntity<List<Filme>> buscarPorPlataforma(@PathVariable String ondeAssistir) {

        return ResponseEntity.ok(filmeService.buscarPorPlataforma(ondeAssistir));
    }

    @GetMapping("/filme/{id}")
    public ResponseEntity<Filme> mostrarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filmeService.buscarPorId(id));
    }

    @PutMapping("/filme/{id}")
    public ResponseEntity<Filme> atualizar(@RequestBody Filme novoFilme, @PathVariable Long id) {
        return ResponseEntity.ok(filmeService.alterarPorId(novoFilme, id));
    }

    @DeleteMapping("/filme/{id}")
    public ResponseEntity<Long> deletarFilme(@PathVariable Long id) {
        return ResponseEntity.ok(filmeService.deletarPorId(id));
    }
    
}
