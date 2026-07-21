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

            if (serieRepository.sexistsByNome(novaSerie.getNome())) {
                throw new IllegalArgumentException("Serie já cadastrada.");
            }

        return serieRepository.save(novaSerie);
    }

    public Long contarSeries() {
        Long quantidade = serieRepository.count();

        return quantidade;
    }

    public Serie buscarPorId(Long id) {
        return serieRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id não encontrado: " + id));  

    }

    public List<Serie> buscarPorGenero(String genero) {
        List<Serie> lista = serieRepository.findByGenero(genero);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Gênero não encontrado.");
        }

        return lista;
    }

    public List<Serie> buscarPorLancamento(String lancamento) {
        List<Serie> lista = serieRepository.findByLancamento(lancamento);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Lançâmento não encontrado.");
        }

        return lista;
    }

    public List<Serie> buscarPorPlataforma(String ondeAssistir) {
        List<Serie> lista = serieRepository.findByOndeAssistir(ondeAssistir);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Busca por plataforma, nada encontrodo.");
        }

        return lista;
    }

     public Serie alterarSerie(Serie serieAtualizada, Long id) {
        Serie serie = serieRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("id não encontrado."));

                serie.setNome(serieAtualizada.getNome());
                serie.setSinopse(serieAtualizada.getSinopse());
                serie.setGenero(serieAtualizada.getGenero());
                serie.setTemporada(serieAtualizada.getTemporada());
                serie.setEpisodios(serieAtualizada.getEpisodios());
                serie.setOndeAssistir(serieAtualizada.getOndeAssistir());

                serieRepository.save(serieAtualizada);

            return serie;

    }

    
    public Long deletarPorId(Long id) {

        buscarPorId(id);

        serieRepository.deleteById(id);
        return id;

    }

    
}
