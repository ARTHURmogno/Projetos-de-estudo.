package com.UMBRELLA.inforHub_API.Series.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import com.UMBRELLA.inforHub_API.Exception.ResourceNotFoundException;
import com.UMBRELLA.inforHub_API.Series.dto.SerieRequestDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieResponseDTO;
import com.UMBRELLA.inforHub_API.Series.model.Serie;
import com.UMBRELLA.inforHub_API.Series.repository.SerieRepository;

@Service
public class SerieService {

    private final SerieRepository serieRepository;

    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    private SerieResponseDTO converterParaSerieResponseDTO(Serie serie) {
        SerieResponseDTO response = new SerieResponseDTO();

        response.setId(serie.getId());
        response.setNome(serie.getNome());
        response.setSinopse(serie.getSinopse());
        response.setGenero(serie.getGenero());
        response.setTemporada(serie.getTemporada());
        response.setEpisodios(serie.getEpisodios());
        response.setLancamento(serie.getLancamento());
        response.setOndeAssistir(serie.getOndeAssistir());

        return response;
    }

    private void copiarDadosDoDTO(Serie serie, SerieRequestDTO dto) {

        serie.setNome(dto.getNome());
         serie.setSinopse(dto.getSinopse());
          serie.setGenero(dto.getGenero());
           serie.setTemporada(dto.getTemporada());
            serie.setEpisodios(dto.getEpisodios());
             serie.setLancamento(dto.getLancamento());
              serie.setOndeAssistir(dto.getOndeAssistir());
    }
 

    public SerieResponseDTO adicionarSerie(SerieRequestDTO dto) {
        Serie serie = new Serie();

        copiarDadosDoDTO(serie, dto);

            if (serieRepository.existsByNome(serie.getNome())) {
                throw new IllegalArgumentException("Serie já cadastrada.");
            }

            Serie novaSerie = serieRepository.save(serie);

            return converterParaSerieResponseDTO(novaSerie);
    }

    public Long contarSeries() {
        Long quantidade = serieRepository.count();

        return quantidade;
    }

    public SerieResponseDTO buscarPorId(Long id) {
        Serie serie = buscarSeriePorId(id);

        return converterParaSerieResponseDTO(serie);
    }

    private Serie buscarSeriePorId(Long id) {
        Serie serie = serieRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id não encontrado: " + id));

        return serie;
    }

    public Page<SerieResponseDTO> buscarPorNome(String nome, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByNomeContainingIgnoreCaseOrderByNomeDesc(nome, pageable);

        if (lista.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum registro encontrado para a busca informada.");
        }

        return lista.map(this::converterParaSerieResponseDTO);
    }    

    public Page<SerieResponseDTO> buscarPorGenero(String genero, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByGeneroContainingIgnoreCaseOrderByNomeDesc(genero, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Gênero não encontrado.");
        }

        return lista.map(this::converterParaSerieResponseDTO);
    }

    public Page<SerieResponseDTO> buscarPorLancamento(String lancamento, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByLancamentoContainingIgnoreCaseOrderByNomeDesc(lancamento, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Lançâmento não encontrado.");
        }

        return lista.map(this::converterParaSerieResponseDTO);
    }

    public Page<SerieResponseDTO> buscarPorPlataforma(String ondeAssistir, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByOndeAssistirContainingIgnoreCaseOrderByNomeDesc(ondeAssistir, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Busca por plataforma, nada encontrado.");
        }

        return lista.map(this::converterParaSerieResponseDTO);
    }

     public SerieResponseDTO alterarSerie(SerieRequestDTO dto, Long id) {
        Serie serie = buscarSeriePorId(id);

        copiarDadosDoDTO(serie, dto);

        Serie novaSerie = serieRepository.save(serie);

        return converterParaSerieResponseDTO(novaSerie);
    }

    
    public Long deletarPorId(Long id) {

        buscarPorId(id);

        serieRepository.deleteById(id);
        return id;

    }

    
}
