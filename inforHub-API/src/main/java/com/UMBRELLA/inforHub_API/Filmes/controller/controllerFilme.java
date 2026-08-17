package com.UMBRELLA.inforHub_API.Filmes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import java.util.List;

import org.springframework.web.bind.annotation.PatchMapping;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeRequestDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeResponseDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeUpdateDTO;
import com.UMBRELLA.inforHub_API.Filmes.model.Filme;
import com.UMBRELLA.inforHub_API.Filmes.repository.FilmeRepository;
import com.UMBRELLA.inforHub_API.Filmes.service.FilmeService;

import jakarta.validation.Valid;

@RestController
public class controllerFilme {

    private final FilmeService filmeService;

    public controllerFilme(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping("/filme")
    public ResponseEntity<FilmeResponseDTO> adicionarFilme(@RequestBody @Valid FilmeRequestDTO dto) {

        return ResponseEntity.ok(filmeService.adicionarFilme(dto));
    
    }

    @GetMapping("/filmes/count")
    public ResponseEntity<Long> listarFilmes() {
        return ResponseEntity.ok(filmeService.todosOsFilmes());
    }

    @GetMapping("/filme/mostrar")
    public ResponseEntity<Page<FilmeResponseDTO>> mostrarFilmes(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             Pageable pageable) {
        return ResponseEntity.ok(filmeService.mostrarFilmes(pageable));
    }

    @GetMapping("filme/buscar/{nome}")
    public ResponseEntity<Page<FilmeResponseDTO>> buscarPorNome(@PathVariable String nome, Pageable pageable) {
        return ResponseEntity.ok(filmeService.buscarPorNome(nome, pageable));
    }

    @GetMapping("/filme/genero/{genero}")
    public ResponseEntity<Page<FilmeResponseDTO>> buscarPorGenero(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String genero, Pageable pageable) {

        return ResponseEntity.ok(filmeService.buscarPorGenero(genero, pageable));
    }

    @GetMapping("/filme/Plataforma/{ondeAssistir}")
    public ResponseEntity<Page<FilmeResponseDTO>> buscarPorPlataforma(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String ondeAssistir, Pageable pageable) {

        return ResponseEntity.ok(filmeService.buscarPorPlataforma(ondeAssistir, pageable));
    }

    @GetMapping("/filme/buscarPorId/{id}")
    public ResponseEntity<FilmeResponseDTO> mostrarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(filmeService.buscarPorId(id));
    }

    @PatchMapping("/filme/atualizar/{id}")
    public ResponseEntity<FilmeResponseDTO> atualizar(@RequestBody FilmeUpdateDTO dto, @PathVariable Long id) {
        return ResponseEntity.ok(filmeService.alterarPorId(dto, id));
    }

    @DeleteMapping("/filme/deletar/{id}")
    public ResponseEntity<Long> deletarFilme(@PathVariable Long id) {
        return ResponseEntity.ok(filmeService.deletarPorId(id));
    }
    
}
