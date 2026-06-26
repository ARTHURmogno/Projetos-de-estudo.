package main.java.com.UMBRELLA.inforHub_API.controller;

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
import main.java.com.UMBRELLA.inforHub_API.model.Filme002;

@RestController
public class controllerFilme002 {
    private List<Filme> filmes = new ArrayList<>();

    Long proximoId = 1L;

    @PostMapping("/filme")
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme filme) {
        
        filme.setId(proximoId);
        proximoId++;

        filmes.add(filme);

        return ResponseEntity.ok(filme);
    }

    @GetMapping("/filmes")
    public ResponseEntity<List<Filme>> listarFilmes() {

        for (Filme filme : filmes) {
            return String.format("Titulo: %s Sinopse: %s Genero: %s Duração: %d OndeAssistir: %s/n",
             filme.getIdfilme.getTitulo(), filme.getSinopse(), filme.getGenero(), filme.getDuracao(), filme.getOndeAssistir());
        }

        return ResponseEntity.ok(filmes);

    }

    @GetMapping("/filmeBuscar/{id}")
    public ResponseEntity<Filme> mostrarPorId(@PathVariable Long id) {

        Filme encontrado = null;

        for (Filme filme : filmes) {
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
    public ResponseEntity<Filme> atualizar(@RequestBody Filme novoFilme, @PathVariable Long id) {

        for (Filme filme : filmes) {
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

        for (Filme filme : filmes) {
            if (filme.getId().equals(id)) {
                filmes.remove(filme);
            }
        }

        return ResponseEntity.ok().build();

    }
    
}
