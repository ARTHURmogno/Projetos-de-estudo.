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
    public ResponseEntity<Anime> adicionarAnime(@RequestBoty Anime anime) {

        anime.setId(proximalId);
        proximalId++;

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

}
