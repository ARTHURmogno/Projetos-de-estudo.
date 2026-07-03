package com.UMBRELLA.inforHub_API.Animes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.UMBRELLA.inforHub_API.Animes.model.Anime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ArrayList;

@RestController
public class ControllerAnime {
    private List<Anime> animes = new ArrayList<>();

    Long proximalId = 1L;

    @PostMapping("/anime")
    public ResponseEntity<Anime> adicionarAnime(@RequestBody Anime anime) {

        anime.setId(proximalId);
        proximalId++;

        animes.add(anime);

        return ResponseEntity.ok(anime);
    }

    @GetMapping("/animes")
    public ResponseEntity<List<Anime>> listarTodos() {
        return ResponseEntity.ok(animes);
    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<Anime> mostrarPorId(@PathVariable Long id) {

        for (Anime anime : animes) {
            if (anime.getId().equals(id)) {
                return ResponseEntity.ok(anime);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // animes por atributo especifico, busca por: genero e plataforma de streaming.
    @GetMapping("/animes/{especifico}")
    public ResponseEntity<List<Anime>> animesEspecificos(@PathVariable String especifico) {
        List<Anime> animesEncontrados = new ArrayList<>();

        for (Anime anime : animes) {
            if (anime.getGenero().equalsIgnoreCase(especifico) || anime.getOndeAssistir().equalsIgnoreCase(especifico)) {
                animesEncontrados.add(anime);
            }
        }

        return ResponseEntity.ok(animesEncontrados);

    }

    @PutMapping("/animeAlterar/{id}")
    public ResponseEntity<Anime> alterarAnime(@RequestBody Anime novoAnime, @PathVariable Long id) {

        for (Anime anime : animes) {
            if (anime.getId().equals(id)) {

                anime.setNome(novoAnime.getNome());
                anime.setGenero(novoAnime.getGenero());
                anime.setSinopse(novoAnime.getSinopse());
                anime.setOndeAssistir(novoAnime.getOndeAssistir());
                anime.setAnoDeLancamento(novoAnime.getAnoDeLancamento());
                anime.setEpisodios(novoAnime.getEpisodios());
                anime.setTemporada(novoAnime.getTemporada());

                return ResponseEntity.ok(anime);
            }
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/animeDeletar/{id}")
    public ResponseEntity<Anime> deletarPorId(@PathVariable Long id) {
        Anime encontrado = null;

        for (Anime anime : animes) {
            if (anime.getId().equals(id)) {
                encontrado = anime;
            }
        }
        if (encontrado == null) {
            return ResponseEntity.notFound().build();
        }
        
        animes.remove(encontrado);

        return ResponseEntity.ok(encontrado);

    }



}
