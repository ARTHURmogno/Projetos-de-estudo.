package com.UMBRELLA.inforHub_API.Animes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import com.UMBRELLA.inforHub_API.Animes.service.AnimeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class ControllerAnime {
    private AnimeService animeService = new AnimeService();

    Long proximalId = 1L;

    @PostMapping("/anime")
    public ResponseEntity<Anime> adicionarAnime(@RequestBody Anime anime) {

        animeService.adicionarAnime(anime);

        return ResponseEntity.ok(anime);
    }

    @GetMapping("/animes")
    public ResponseEntity<List<Anime>> listarTodos() {

        return ResponseEntity.ok(animeService.listarTodos());
        
    }

    @GetMapping("/anime/{id}")
    public ResponseEntity<Anime> mostrarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(animeService.buscarPorId(id));

    }

    // animes por atributo especifico, busca por: genero e plataforma de streaming.
    @GetMapping("/animes/{especifico}")
    public ResponseEntity<List<Anime>> animesEspecificos(@PathVariable String especifico) {

        return ResponseEntity.ok(animeService.buscarPorEspecifico(especifico));

    }

    @PutMapping("/animeAlterar/{id}")
    public ResponseEntity<Anime> alterarAnime(@RequestBody Anime novoAnime, @PathVariable Long id) {

        return ResponseEntity.ok(animeService.alterarAnimePorId(novoAnime, id));

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
