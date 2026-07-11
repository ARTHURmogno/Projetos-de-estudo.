package com.UMBRELLA.inforHub_API.Series.controller;

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
    private SerieService serieService = new SerieService();

    @PostMapping("/serie")
    public ResponseEntity<Serie> adicionarSerie(@RequestBody Serie serie) {
        return ResponseEntity.ok(serieService.novaSerie(serie));

    }

    @GetMapping("/series")
    public ResponseEntity<List<Serie>> litarTodasAsSeries() {
        return ResponseEntity.ok(serieService.listarTodas());
    }

    // buscar uma serie especifica pelo seu id;
    @GetMapping("/Serie/{id}")
    public ResponseEntity<Serie> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(serieService.buscarPorId(id));

    }

    // busca por informacoes especifica, pode-se por: lancamento, genero e plataforma;
    @GetMapping("/serie/{especifico}")
    public ResponseEntity<List<Serie>> buscarPorAtributoEspecifico(@PathVariable String especifico) {
        return ResponseEntity.ok(serieService.buscarPorEspecifico(especifico));

    }

    @PutMapping("/serie/{id}")
    public ResponseEntity<Serie> atualizarPorId(@PathVariable Long id, @RequestBody Serie novaSerie) {
        return ResponseEntity.ok(serieService.alterarSerie(novaSerie, id));

    }

    @DeleteMapping("/serie/{id}")
    public ResponseEntity<Long> deletarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.deletarPorId(id));
        
    }
    
}
