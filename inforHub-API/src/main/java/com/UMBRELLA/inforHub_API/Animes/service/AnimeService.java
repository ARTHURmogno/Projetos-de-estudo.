package com.UMBRELLA.inforHub_API.Animes.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeFiltroDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeResponseDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeUpdateDTO;
import com.UMBRELLA.inforHub_API.Animes.mapper.AnimeMapper;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import com.UMBRELLA.inforHub_API.Animes.repository.AnimeRepository;
import com.UMBRELLA.inforHub_API.Animes.specification.AnimeSpecification;
import com.UMBRELLA.inforHub_API.Exception.ResourceNotFoundException;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;
    private final AnimeMapper animeMapper;

    public AnimeService(AnimeRepository animeRepository, AnimeMapper animeMapper) {
        this.animeRepository = animeRepository;
        this.animeMapper = animeMapper;
    }


    public AnimeResponseDTO adicionarAnime(AnimeRequestDTO dto) {
       Anime anime = animeMapper.toEntity(dto);

        if (animeRepository.existsByNome(anime.getNome())) {
            throw new IllegalArgumentException("Anime já cadastrado.");
        }

        Anime novoAnime = animeRepository.save(anime);

        return animeMapper.toResponseDTO(novoAnime);
    }

    public Page<AnimeResponseDTO> buscarPorFiltro(AnimeFiltroDTO filtro, Pageable pageable) {
        Specification<Anime> specification = AnimeSpecification.comFiltros(filtro);

        Page<Anime> pagina = animeRepository.findAll(specification, pageable);

        return pagina.map(animeMapper::toResponseDTO);
    }

    public Long contarAnimes() {
        return animeRepository.count();
    }

    public AnimeResponseDTO buscarPorId(Long id) {
        Anime anime = buscarAnimePorId(id);

        return animeMapper.toResponseDTO(anime);
    }

    private Anime buscarAnimePorId(Long id) {
        return animeRepository.findById(id).
        orElseThrow(() -> new ResourceNotFoundException("Nada encontrado."));
    }

     public AnimeResponseDTO alterarAnimePorId(AnimeUpdateDTO dto, Long id) {
        Anime anime = buscarAnimePorId(id);

        animeMapper.atualizarAnime(dto, anime);

        Anime animeAtualizado = animeRepository.save(anime);

        return animeMapper.toResponseDTO(animeAtualizado);

    }

    public Long deletarPorId(Long id) {
        buscarAnimePorId(id);

        animeRepository.deleteById(id);
        return id;
    }

    
    
}
