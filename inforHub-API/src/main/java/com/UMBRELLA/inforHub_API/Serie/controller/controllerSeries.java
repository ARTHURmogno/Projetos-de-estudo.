package com.UMBRELLA.inforHub_API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.ArrayList;
import com.UMBRELLA.inforHub_API.model.Serie;

@RestController
public class controllerSeries {
    private List<Serie> series = new ArrayList<>();

    Long proximalId;

    @PostMapping("/Serie")
    public ResponseEntity<Serie> adicionarSerie(@RequestBody Serie serie) {

       series.setId(proximalId);
       proximalId++;

       series.add(serie);

       return ResponseEntity.ok(Serie);

    }

    @GetMapping("/Series")
    public ResponseEntity<Serie> litarTodasAsSeries() {
        ResponseEntity.ok(Serie);
    }

    @GetMapping("/Serie/{id}")
    public ResponseEntity<Serie> buscarPorId(@PathVariable Long id) {

        for (Serie serie : series) {
            if (serie.getId().equals(id)) {
                return ResponseEntity.ok(serie);
            }
        }

        return ResponseEntity.notFound().build();
    }
    
}
