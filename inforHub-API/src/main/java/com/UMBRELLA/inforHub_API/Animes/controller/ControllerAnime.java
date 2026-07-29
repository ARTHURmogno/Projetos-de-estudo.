package com.UMBRELLA.inforHub_API.Animes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import com.UMBRELLA.inforHub_API.Animes.service.AnimeService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class ControllerAnime {

    private final AnimeService animeService;

    public ControllerAnime(AnimeService animeService) {
        this.animeService = animeService;
    }

    @PostMapping("/anime")
    public ResponseEntity<AnimeRequestDTO> adicionarAnime(@RequestBody @Valid AnimeRequestDTO dto) {

        return ResponseEntity.ok(animeService.adicionarAnime(dto));
    }

    @GetMapping("/animes/count")
    public ResponseEntity<Long> listarTodos() {

        return ResponseEntity.ok(animeService.todosAnime());
    }

    @GetMapping("/anime/mostrar")
    public ResponseEntity<Page<Anime>> mostrarAnimes(
        @PageableDefault(
            size = 10,
            sort = "nome",
            direction = Sort.Direction.DESC)
          Pageable pageable) {

        return ResponseEntity.ok(animeService.mostrarAnimes(pageable));
    } 

    @GetMapping("/anime/{id}")
    public ResponseEntity<Anime> mostrarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(animeService.buscarPorId(id));

    }

    @GetMapping("/anime/buscar/{nome}")
    public ResponseEntity<Page<Anime>> buscarPorNome(@PathVariable String nome, Pageable pageable) {

        return ResponseEntity.ok(animeService.buscarPorNome(nome, pageable));
    }

    // animes por atributo especifico, busca por: genero e plataforma de streaming.
    @GetMapping("/animes/{genero}")
    public ResponseEntity<Page<Anime>> buscarPorGenero(@PathVariable String genero, Pageable pageable) {

        return ResponseEntity.ok(animeService.buscarPorGenero(genero, pageable));
    }

    @GetMapping("/anime/Plataforma/{ondeAssistir}")
    public ResponseEntity<Page<Anime>> buscarPorPlatadorma(@PathVariable String ondeAssistir, Pageable pageable) {

        return ResponseEntity.ok(animeService.buscarPorPlataforma(ondeAssistir, pageable));
    }

    @PutMapping("/anime/{id}")
    public ResponseEntity<AnimeRequestDTO> alterarAnime(@RequestBody @Valid AnimeRequestDTO dto, @PathVariable Long id) {

        return ResponseEntity.ok(animeService.alterarAnimePorId(dto, id));
    }

    @DeleteMapping("/anime/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(animeService.deletarPorId(id));

    }



}
