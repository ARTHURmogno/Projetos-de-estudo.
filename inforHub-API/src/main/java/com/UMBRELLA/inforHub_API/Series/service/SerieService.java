package com.UMBRELLA.inforHub_API.Series.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.UMBRELLA.inforHub_API.Exception.ResourceNotFoundException;
import com.UMBRELLA.inforHub_API.Series.dto.SerieRequestDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieResponseDTO;
import com.UMBRELLA.inforHub_API.Series.mapper.SerieMapper;
import com.UMBRELLA.inforHub_API.Series.model.Serie;
import com.UMBRELLA.inforHub_API.Series.repository.SerieRepository;

@Service
public class SerieService {

    private final SerieRepository serieRepository;
    private final SerieMapper serieMapper;

    public SerieService(SerieRepository serieRepository, SerieMapper serieMapper) {
        this.serieRepository = serieRepository;
        this.serieMapper = serieMapper;
    }
 

    public SerieResponseDTO adicionarSerie(SerieRequestDTO dto) {
        Serie serie = serieMapper.toEntity(dto);

            if (serieRepository.existsByNome(serie.getNome())) {
                throw new IllegalArgumentException("Serie já cadastrada.");
            }

            Serie novaSerie = serieRepository.save(serie);

            return serieMapper.toResponseDTO(novaSerie);
    }

    public Long contarSeries() {
        Long quantidade = serieRepository.count();

        return quantidade;
    }

    public SerieResponseDTO buscarPorId(Long id) {
        Serie serie = buscarSeriePorId(id);

        return serieMapper.toResponseDTO(serie);
    }

    private Serie buscarSeriePorId(Long id) {
        return serieRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id não encontrado: " + id));
    }

    public Page<SerieResponseDTO> buscarPorNome(String nome, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByNomeContainingIgnoreCaseOrderByNomeDesc(nome, pageable);

        if (lista.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum registro encontrado para a busca informada.");
        }

        return lista.map(serieMapper::toResponseDTO);
    }    

    public Page<SerieResponseDTO> buscarPorGenero(String genero, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByGeneroContainingIgnoreCaseOrderByNomeDesc(genero, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Gênero não encontrado.");
        }

        return lista.map(serieMapper::toResponseDTO);
    }

    public Page<SerieResponseDTO> buscarPorLancamento(String lancamento, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByLancamentoContainingIgnoreCaseOrderByNomeDesc(lancamento, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Lançâmento não encontrado.");
        }

        return lista.map(serieMapper::toResponseDTO);
    }

    public Page<SerieResponseDTO> buscarPorPlataforma(String ondeAssistir, Pageable pageable) {
        Page<Serie> lista = serieRepository.findByOndeAssistirContainingIgnoreCaseOrderByNomeDesc(ondeAssistir, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Busca por plataforma, nada encontrado.");
        }

        return lista.map(serieMapper::toResponseDTO);
    }

     public SerieResponseDTO alterarSerie(SerieRequestDTO dto, Long id) {
        Serie serie = buscarSeriePorId(id);

        serieMapper.atualizarSerie(dto, serie);

        Serie serieAtualizar = serieRepository.save(serie);

        return serieMapper.toResponseDTO(serieAtualizar);
    }

    
    public Long deletarPorId(Long id) {
        buscarSeriePorId(id);

        serieRepository.deleteById(id);
        return id;

    }

    
}
