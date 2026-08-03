package com.UMBRELLA.inforHub_API.Series.controller;

import com.UMBRELLA.inforHub_API.Series.repository.SerieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.UMBRELLA.inforHub_API.Series.dto.SerieRequestDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieResponseDTO;
import com.UMBRELLA.inforHub_API.Series.model.Serie;
import com.UMBRELLA.inforHub_API.Series.service.SerieService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

@RestController
public class controllerSeries {

    private final SerieService serieService;

    public controllerSeries(SerieService serieService) {
        this.serieService = serieService;
    }

    
    @PostMapping("/serie/save")
    public ResponseEntity<SerieResponseDTO> adicionarSerie(@RequestBody @Valid SerieRequestDTO dto) {
        return ResponseEntity.ok(serieService.adicionarSerie(dto));

    }

    @GetMapping("/series/quantidade")
    public ResponseEntity<Long> seriesQuantidade() {
        return ResponseEntity.ok(serieService.contarSeries());
    }

    // buscar uma serie especifica pelo seu id;
    @GetMapping("/Serie/buscar/{id}")
    public ResponseEntity<SerieResponseDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(serieService.buscarPorId(id));
    }

    @GetMapping("/serie/buscarPorNome/{nome}")
    public ResponseEntity<Page<SerieResponseDTO>> buscarPorNome(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String nome, Pageable pageable) {
        return ResponseEntity.ok(serieService.buscarPorNome(nome, pageable));
    }

    // busca por informacoes especifica, pode-se por: lancamento, genero e plataforma;
    @GetMapping("/serie/genero/{genero}")
    public ResponseEntity<Page<SerieResponseDTO>> buscarPorGenero(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String genero, Pageable pageable) {
        return ResponseEntity.ok(serieService.buscarPorGenero(genero, pageable));
    }

    @GetMapping("/serie/lancamento/{lancamento}")
    public ResponseEntity<Page<SerieResponseDTO>> buscarPorLancamento(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String lancamento, Pageable pageable) {
        return ResponseEntity.ok(serieService.buscarPorLancamento(lancamento, pageable));
    }

    @GetMapping("/serie/plataforma/{ondeAssistir}")
    public ResponseEntity<Page<SerieResponseDTO>> buscaPorPlataforma(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String ondeAssistir, Pageable pageable) {
        return ResponseEntity.ok(serieService.buscarPorPlataforma(ondeAssistir, pageable));
    }

    @PutMapping("/serie/update/{id}")
    public ResponseEntity<SerieResponseDTO> atualizarPorId(@PathVariable Long id, @RequestBody @Valid SerieRequestDTO dto) {
        return ResponseEntity.ok(serieService.alterarSerie(dto, id));

    }

    @DeleteMapping("/serie/delete/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.deletarPorId(id));

    }
    
}
