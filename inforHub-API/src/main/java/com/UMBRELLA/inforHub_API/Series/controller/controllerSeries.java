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

    // busca por informacoes especifica, pode-se por: lancamento, genero e plataforma;
    @GetMapping("/serie/{genero}")
    public ResponseEntity<List<Serie>> buscarPorGenero(@PathVariable String genero) {
        return ResponseEntity.ok(serieService.buscarPorGenero(genero));
    }

    @GetMapping("/serie/{lancamento}")
    public ResponseEntity<List<Serie>> buscarPorLancamento(@PathVariable String lancamento) {
        return ResponseEntity.ok(serieService.buscarPorLancamento(lancamento));
    }

    @GetMapping("/serie/{plataforma}")
    public ResponseEntity<List<Serie>> buscaPorPlataforma(@PathVariable String ondeAssistir) {
        return ResponseEntity.ok(serieService.buscarPorPlataforma(ondeAssistir));
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
