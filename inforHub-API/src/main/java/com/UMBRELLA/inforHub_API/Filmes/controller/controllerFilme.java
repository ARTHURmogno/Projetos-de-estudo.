package com.UMBRELLA.inforHub_API.Filmes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import org.springframework.web.bind.annotation.PatchMapping;

import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeFiltroDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeRequestDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeResponseDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeUpdateDTO;
import com.UMBRELLA.inforHub_API.Filmes.service.FilmeService;

import jakarta.validation.Valid;

@RestController
public class controllerFilme {

    private final FilmeService filmeService;

    public controllerFilme(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping("/filmes")
    public ResponseEntity<FilmeResponseDTO> adicionarFilme(@RequestBody @Valid FilmeRequestDTO dto) {

        return ResponseEntity.ok(filmeService.adicionarFilme(dto));
    
    }

    @GetMapping("/filmes/count")
    public ResponseEntity<Long> contarFilmes() {
        return ResponseEntity.ok(filmeService.contarOsFilmes());
    }

    @GetMapping("/filmes")
    public ResponseEntity<Page<FilmeResponseDTO>> buscaPorFiltro(@ModelAttribute FilmeFiltroDTO filtro, @PageableDefault(
        size = 10,
        sort = "nome",
        direction = Sort.Direction.DESC)
        Pageable pageable) {

            return ResponseEntity.ok(filmeService.buscarFilmePorFiltro(filtro, pageable));

        }

    @GetMapping("/filmes/{id}")
    public ResponseEntity<FilmeResponseDTO> mostrarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filmeService.buscarPorId(id));
    }

    @PatchMapping("/filmes/{id}")
    public ResponseEntity<FilmeResponseDTO> atualizar(@RequestBody FilmeUpdateDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(filmeService.alterarPorId(dto, id));
    }

    @DeleteMapping("/filmes/{id}")
    public ResponseEntity<Long> deletarFilme(@PathVariable Long id) {
        return ResponseEntity.ok(filmeService.deletarPorId(id));
    }
    
}
