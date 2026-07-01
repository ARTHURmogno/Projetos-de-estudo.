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

    // buscar uma serie especifica pelo seu id;
    @GetMapping("/Serie/{id}")
    public ResponseEntity<Serie> buscarPorId(@PathVariable Long id) {

        for (Serie serie : series) {
            if (serie.getId().equals(id)) {
                return ResponseEntity.ok(serie);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // busca por informacoes especifica, pode-se por: lancamento, genero e plataforma;
    @GetMapping("/serie/{atributoExpecifico}")
    public ResponseEntity<List<Serie>> buscarPorAtributoExpecifico(@PathVariable Stirng especifico) {
        List<Serie> buscaEspecifica = new ArriyList<>();

        for (Serie serie : series) {
            if (serie.getLancamento().equalsIgnoreCase(especifico) || serie.getGenero().equalsIgnoreCase(especifico) || serie.getOndeAssistir().equalsIgnoreCase(especifico)) {
                buscaEspecifica.add(especifico);
                return ResponseEntity.ok(buscaEspecifica);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/serie/{id}")
    public ResponseEntity<Serie> atualizarPorId(@PathVariable Long id, @RequestBody Serie novaSerie) {
    
        for (Serie serie : series) {
            if (serie.getId().equals(id)) {

                serie.setNome(novaSerie.getNome());
                serie.setSinopse(novaSerie.getSinopse());
                serie.setGenero(novaSerie.getGenero());
                serie.setTemporada(novaSerie.getTemporada());
                serie.setEpisodios(novaSerie.getEpisodios());
                serie.setOndeAssistir(novaSerie.getOndeAssistir());

                return ResponseEntity.ok(novaSerie);
            }
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/serie/{id}")
    public ResponseEntity<Serie> deletarPorId(@PathVariable Ling id) {

        Serie encontrada = null;

        for (Serie serie : series) {
            if (serie.getId().equals(id)) {
                encontrada = id;
            }
        }

        if (encontrada != null) {
            series.remove(encontrada);
            return ResponseEntity.ok(encontrada);
        }

        return ResponseEntity.notFound().builde();
    }
    
}
