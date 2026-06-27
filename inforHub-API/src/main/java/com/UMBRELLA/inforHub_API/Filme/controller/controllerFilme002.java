package com.UMBRELLA.inforHub_API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.ArrayList;
import com.UMBRELLA.inforHub_API.model.Filme002;

@RestController
public class controllerFilme002 {
    private List<Filme002> filmes = new ArrayList<>();

    Long proximoId = 1L;

    @PostMapping("/filme")
    public ResponseEntity<Filme002> adicionarFilme(@RequestBody Filme002 filme) {
        
        filme.setId(proximoId);
        proximoId++;

        filmes.add(filme);

        return ResponseEntity.ok(filme);
    }

    @GetMapping("/filmes")
    public ResponseEntity<List<Filme002>> listarFilmes() {
        return ResponseEntity.ok(filmes);
    }

    @GetMapping("/filme/{genero}")
    public ResponseEntity<List<Filme002>> buscarPorGenero(@PathVariable String genero) {
        List<Filme002> filmeGenero = new ArrayList<>();

        for (Filme002 filme : filmes) {
            if (filme.getGenero().equalsIgnoreCase(genero)) {
                filmeGenero.add(filme);
            }
        }

        return ResponseEntity.ok(filmeGenero);
    }

    @GetMapping("/filmeBuscar/{id}")
    public ResponseEntity<Filme002> mostrarPorId(@PathVariable Long id) {

        Filme002 encontrado = null;

        for (Filme002 filme : filmes) {
            if (filme.getId().equals(id)) {
                encontrado = filme;
            }
        }

        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(encontrado);

    }

    @PutMapping("/filme/{id}")
    public ResponseEntity<Filme002> atualizar(@RequestBody Filme002 novoFilme, @PathVariable Long id) {

        for (Filme002 filme : filmes) {
            if (filme.getId().equals(id)) {

                filme.setTitulo(novoFilme.getTitulo());
                filme.setSinopse(novoFilme.getSinopse());
                filme.setGenero(novoFilme.getGenero());
                filme.setDuracao(novoFilme.getDuracao());
                filme.setOndeAssistir(novoFilme.getOndeAssistir());

                return ResponseEntity.ok(filme);
            }
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/filmeDeletar/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Long id) {

        for (Filme002 filme : filmes) {
            if (filme.getId().equals(id)) {
                filmes.remove(filme);
            }
        }

        return ResponseEntity.ok().build();

    }
    
}
