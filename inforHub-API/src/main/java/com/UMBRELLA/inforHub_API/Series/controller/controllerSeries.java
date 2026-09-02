package com.UMBRELLA.inforHub_API.Series.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.UMBRELLA.inforHub_API.Series.dto.SerieFiltroDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieRequestDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieResponseDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieUpdateDTO;
import com.UMBRELLA.inforHub_API.Series.service.SerieService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

@RestController
public class controllerSeries {


    private final SerieService serieService;

    public controllerSeries(SerieService serieService)  {
        this.serieService = serieService;
    }

    
    @PostMapping("/series")
    public ResponseEntity<SerieResponseDTO> adicionarSerie(@RequestBody @Valid SerieRequestDTO dto) {
        return ResponseEntity.ok(serieService.adicionarSerie(dto));

    }

    @GetMapping("/series")
    public ResponseEntity<Page<SerieResponseDTO>> seriePorFiltro(@ModelAttribute SerieFiltroDTO filtro,
        @PageableDefault(
            page = 0,
            size = 10,
            sort = "nome",
            direction = Sort.Direction.DESC) Pageable pageable) {

                return ResponseEntity.ok(serieService.buscarSeriesPorFiltro(filtro, pageable));
            }

    @GetMapping("/series/count")
    public ResponseEntity<Long> seriesQuantidade() {
        return ResponseEntity.ok(serieService.contarSeries());
    }

    // buscar uma serie especifica pelo seu id;
    @GetMapping("/series/{id}")
    public ResponseEntity<SerieResponseDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(serieService.buscarPorId(id));
    }

    @PatchMapping("/series/{id}")
    public ResponseEntity<SerieResponseDTO> atualizarPorId(@PathVariable Long id, @RequestBody SerieUpdateDTO dto) {
        return ResponseEntity.ok(serieService.alterarSerie(dto, id));

    }

    @DeleteMapping("/series/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.deletarPorId(id));

    }
    
}
