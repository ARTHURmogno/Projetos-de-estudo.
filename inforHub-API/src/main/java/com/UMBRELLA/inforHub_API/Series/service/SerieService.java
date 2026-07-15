package com.UMBRELLA.inforHub_API.Series.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.UMBRELLA.inforHub_API.Series.model.Serie;
import com.UMBRELLA.inforHub_API.Series.repository.SerieRepository;

@Service
public class SerieService {

    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public Serie adicionarSerie(Serie novaSerie) {

            if (serieRepository.exisexistsByNome(novaSerie.getNome())) {
                throw new IllegalArgumentException("Serie já cadastrada.");
            }

        return serieRepository.save(novaSerie);
    }

    public List<Serie> listarTodas() {
        return serieRepository.findAll();
    }

    public Serie buscarPorId(Long id) {
        return serieRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id não encontrado: " + id));  

    }

    public List<Serie> buscarPorEspecifico(String especifico) {
        List<Serie> seriesEspecificas = new ArrayList<>();

        for (Serie serie : series) {
            if (serie.getGenero().trim().equalsIgnoreCase(especifico)
                || serie.getLancamento().trim().equalsIgnoreCase(especifico)
                || serie.getOndeAssistir().trim().equalsIgnoreCase(especifico));
        }

        if (seriesEspecificas.isEmpty()) {
             throw new IllegalArgumentException("Serie não encontrada: " + especifico);
        }

        return seriesEspecificas;
    }

    public Serie alterarSerie(Serie serieAtualizada, Long id) {

        for (Serie serie : series) {
            if (serie.getId().equals(id)) {

                serie.setNome(serieAtualizada.getNome());
                serie.setSinopse(serieAtualizada.getSinopse());
                serie.setGenero(serieAtualizada.getGenero());
                serie.setTemporada(serieAtualizada.getTemporada());
                serie.setEpisodios(serieAtualizada.getEpisodios());
                serie.setOndeAssistir(serieAtualizada.getOndeAssistir());

                return serie;
            }
        }

        throw new IllegalArgumentException("Id não encontrado: " + id);

    }

    public Long deletarPorId(Long id) {

        Serie encontrodo = buscarPorId(id);
        series.remove(encontrodo);

        return id;
    }


    
}
