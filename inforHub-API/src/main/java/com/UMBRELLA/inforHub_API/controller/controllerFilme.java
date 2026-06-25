package main.java.com.UMBRELLA.inforHub_API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.ArrayList;
import java.util.model.Filme;

@RestController
public class controllerFilme {
    private List<Filme> filmes = new ArrayList<>();
    private Long proximoId = 1L;


    @GetMapping("/filmess")
    public ResponseEntity<List<Filme>> listar() {

        for (Filme filmess : filmes) {
            return String.format("Titulo: %s Sinopse: %s Genero: %s Duração: %d OndeAssistir: %s" ,
            filmess.getTitulo(), filmess.getSinopse(), filmess.getGenero(), filmess.getDuracao(), filmess.getOndeAssistir());
        }

        return ResponseEntity.ok(Filme);

    }

    @GetMapping("/filmeBuscar/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable int id) {

        Filme encontrado = null;

        for (Filme filme : filmes) {
            if (filme.getId().equals(id)) {
                encontrado = filme;
            }
        }

        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Filme);


    }

    @PostMapping("/filmes")
    public ResponseEntity<Filme> adicionar(@RequestBody Filme filme) {

        filme.setId(proximoId);
        proximoId++;

        filmes.add(filme);

        return ResponseEntity.ok(filme);

    }

    @PutMapping("/filme/{id}")
    public ResponseEntity<List<Filme>> alterar(@RequestBody Filme filmeNovo, @PathVariable int id) {

        Filme filmeAtualizado = null;

        for (Filme filme : filmes) {
            if (filme.getId().equals(id)) {
                filmeAtualizado = filme;
            }
        }

        filme.SetTitulo(filmeNovo.getTitulo);
        filme.SetSinopse(filmeNovo.getSinopse);
        filme.SetGenero(filmeNovo.getGenero);
        filme.SetDuracao(filmeNovo.getDuracao);
        filme.SetOndeAssistir(filmeNovo.getOndeAssistir);

        if (filmeAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(Filme);

    } 

    @DeleteMapping("/filmeDelete/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable int id) {

        Filme encontrado = null;

       if (encontrado == null) {
        return ResponseEntity.notFound().build();
       }

        filmes.remove(encontrodo);

        return ResponseEntity.noContent().build();


    }


}
