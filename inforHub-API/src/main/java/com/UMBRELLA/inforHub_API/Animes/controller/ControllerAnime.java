package com.UMBRELLA.inforHub_API.Animes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeFiltroDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeResponseDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeUpdateDTO;
import com.UMBRELLA.inforHub_API.Animes.service.AnimeService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @PostMapping("/animes")
    public ResponseEntity<AnimeResponseDTO> adicionarAnime(@RequestBody @Valid AnimeRequestDTO dto) {

        return ResponseEntity.ok(animeService.adicionarAnime(dto));
    }

    @GetMapping("/animes")
    public ResponseEntity<Page<AnimeResponseDTO>> buscaPorSpecification(
        @ModelAttribute AnimeFiltroDTO filtro,
        @PageableDefault(
            page = 0,
            size = 10,
            sort = "nome",
            direction = Sort.Direction.DESC) Pageable pageable) {

                return ResponseEntity.ok(animeService.buscarPorFiltro(filtro, pageable));
            }

    @GetMapping("/animes/count")
    public ResponseEntity<Long> contarTodos() {

        return ResponseEntity.ok(animeService.contarAnimes());
    }

    @GetMapping("/animes/{id}")
    public ResponseEntity<AnimeResponseDTO> mostrarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(animeService.buscarPorId(id));

    }
    
    @PatchMapping("/animes/{id}")
    public ResponseEntity<AnimeResponseDTO> alterarAnimePorId(@RequestBody AnimeUpdateDTO dto, @PathVariable Long id) {

        return ResponseEntity.ok(animeService.alterarAnimePorId(dto, id));
    }

    @DeleteMapping("/animes/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(animeService.deletarPorId(id));

    }



}
