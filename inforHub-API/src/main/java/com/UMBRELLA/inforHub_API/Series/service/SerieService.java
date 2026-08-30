package com.UMBRELLA.inforHub_API.Series.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.UMBRELLA.inforHub_API.Series.dto.SerieFiltroDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieRequestDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieResponseDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieUpdateDTO;
import com.UMBRELLA.inforHub_API.Series.mapper.SerieMapper;
import com.UMBRELLA.inforHub_API.Series.model.Serie;
import com.UMBRELLA.inforHub_API.Series.repository.SerieRepository;
import com.UMBRELLA.inforHub_API.Series.specification.SerieSpecification;

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

    public Page<SerieResponseDTO> buscarSeriesPorFiltro(SerieFiltroDTO filtro, Pageable pageable) {
        Specification<Serie> specification = SerieSpecification.filtroDeSerie(filtro);

        Page<Serie> filtroDeSerie = serieRepository.findAll(specification, pageable);

        return filtroDeSerie.map(serieMapper::toResponseDTO);
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

     public SerieResponseDTO alterarSerie(SerieUpdateDTO dto, Long id) {
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
