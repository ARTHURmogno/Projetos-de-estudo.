package com.UMBRELLA.inforHub_API.Animes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeResponseDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeUpdateDTO;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import com.UMBRELLA.inforHub_API.Animes.service.AnimeService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ControllerAnime {

    private final AnimeService animeService;

    public ControllerAnime(AnimeService animeService) {
        this.animeService = animeService;
    }

    @PostMapping("/anime")
    public ResponseEntity<AnimeResponseDTO> adicionarAnime(@RequestBody @Valid AnimeRequestDTO dto) {

        return ResponseEntity.ok(animeService.adicionarAnime(dto));
    }

    @GetMapping("/animes/count")
    public ResponseEntity<Long> listarTodos() {

        return ResponseEntity.ok(animeService.todosAnime());
    }

    @GetMapping("/anime/mostrar")
    public ResponseEntity<Page<AnimeResponseDTO>> mostrarAnimes(
        @PageableDefault(
            page = 0,
            size = 10,
            sort = "nome",
            direction = Sort.Direction.DESC)
          Pageable pageable) {

        return ResponseEntity.ok(animeService.mostrarAnimes(pageable));
    } 

    @GetMapping("/anime/{id}")
    public ResponseEntity<AnimeResponseDTO> mostrarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(animeService.buscarPorId(id));

    }

    @GetMapping("/anime/buscar/{nome}")
    public ResponseEntity<Page<AnimeResponseDTO>> buscarPorNome(@PageableDefault (
        page = 0, 
        size = 10, 
        sort = "nome", 
        direction = Sort.Direction.DESC)@PathVariable String nome, Pageable pageable) {

        return ResponseEntity.ok(animeService.buscarPorNome(nome, pageable));
    }

    // animes por atributo especifico, busca por: genero e plataforma de streaming.
    @GetMapping("/animes/{genero}")
    public ResponseEntity<Page<AnimeResponseDTO>> buscarPorGenero( @PageableDefault(
            page = 0,
            size = 10,
            sort = "nome",
            direction = Sort.Direction.DESC)@PathVariable String genero, Pageable pageable) {

        return ResponseEntity.ok(animeService.buscarPorGenero(genero, pageable));
    }

    
           
    @GetMapping("/anime/Plataforma/{ondeAssistir}")
    public ResponseEntity<Page<AnimeResponseDTO>> buscarPorPlataforma( @PageableDefault(
            page = 0,
            size = 10,
            sort = "nome",
            direction = Sort.Direction.DESC)@PathVariable String ondeAssistir, Pageable pageable) {

        return ResponseEntity.ok(animeService.buscarPorPlataforma(ondeAssistir, pageable));
    }

    @PatchMapping("/anime/atualizar/{id}")
    public ResponseEntity<AnimeResponseDTO> alterarAnimePorId(@RequestBody AnimeUpdateDTO dto, @PathVariable Long id) {

        return ResponseEntity.ok(animeService.alterarAnimePorId(dto, id));
    }

    @DeleteMapping("/anime/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(animeService.deletarPorId(id));

    }



}
