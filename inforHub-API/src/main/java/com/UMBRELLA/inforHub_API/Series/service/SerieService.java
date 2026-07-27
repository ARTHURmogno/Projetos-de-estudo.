package com.UMBRELLA.inforHub_API.Series.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.UMBRELLA.inforHub_API.Exception.ResourceNotFoundException;
import com.UMBRELLA.inforHub_API.Series.model.Serie;
import com.UMBRELLA.inforHub_API.Series.repository.SerieRepository;

@Service
public class SerieService {

    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public Serie adicionarSerie(Serie novaSerie) {

            if (serieRepository.existsByNome(novaSerie.getNome())) {
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

    public Page<Serie> buscarPorNome(String nome, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByNomeContainingIgnoreCaseOrderByNomeDesc(nome, pageable);

        if (lista.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum registro encontrado para a busca informada.");
        }

        return serieRepository.findByNomeContainingIgnoreCaseOrderByNomeDesc(nome, pageable);
    }

    public Page<Serie> buscarPorGenero(String genero, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByGeneroContainingIgnoreCaseOrderByNomeDesc(genero, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Gênero não encontrado.");
        }

        return lista;
    }

    public Page<Serie> buscarPorLancamento(String lancamento, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByLancamentoContainingIgnoreCaseOrderByNomeDesc(lancamento, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Lançâmento não encontrado.");
        }

        return lista;
    }

    public Page<Serie> buscarPorPlataforma(String ondeAssistir, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByOndeAssistirContainingIgnoreCaseOrderByNomeDesc(ondeAssistir, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Busca por plataforma, nada encontrado.");
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
