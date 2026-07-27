package com.UMBRELLA.inforHub_API.Series.controller;

import com.UMBRELLA.inforHub_API.Series.repository.SerieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.UMBRELLA.inforHub_API.Series.model.Serie;
import com.UMBRELLA.inforHub_API.Series.service.SerieService;

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
    public ResponseEntity<Serie> adicionarSerie(@RequestBody Serie serie) {
        return ResponseEntity.ok(serieService.adicionarSerie(serie));

    }

    @GetMapping("/series/quantidade")
    public ResponseEntity<Long> seriesQuantidade() {
        return ResponseEntity.ok(serieService.contarSeries());
    }

    // buscar uma serie especifica pelo seu id;
    @GetMapping("/Serie/buscar/{id}")
    public ResponseEntity<Serie> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(serieService.buscarPorId(id));

    }

    @GetMapping("/serie/buscar/{nome}")
    public ResponseEntity<Page<Serie>> buscarPorNome(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String nome, Pageable pageable) {
        return ResponseEntity.ok(serieService.buscarPorNome(nome, pageable));
    }

    // busca por informacoes especifica, pode-se por: lancamento, genero e plataforma;
    @GetMapping("/serie/{genero}")
    public ResponseEntity<Page<Serie>> buscarPorGenero(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String genero, Pageable pageable) {
        return ResponseEntity.ok(serieService.buscarPorGenero(genero, pageable));
    }

    @GetMapping("/serie/{lancamento}")
    public ResponseEntity<Page<Serie>> buscarPorLancamento(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String lancamento, Pageable pageable) {
        return ResponseEntity.ok(serieService.buscarPorLancamento(lancamento, pageable));
    }

    @GetMapping("/serie/{plataforma}")
    public ResponseEntity<Page<Serie>> buscaPorPlataforma(@PageableDefault(
             size = 10,
             sort = "nome",
             direction = Sort.Direction.DESC)
             @PathVariable String ondeAssistir, Pageable pageable) {
        return ResponseEntity.ok(serieService.buscarPorPlataforma(ondeAssistir, pageable));
    }

    @PutMapping("/serie/update/{id}")
    public ResponseEntity<Serie> atualizarPorId(@PathVariable Long id, @RequestBody Serie novaSerie) {
        return ResponseEntity.ok(serieService.alterarSerie(novaSerie, id));

    }

    @DeleteMapping("/serie/delete/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.deletarPorId(id));

    }
    
}
