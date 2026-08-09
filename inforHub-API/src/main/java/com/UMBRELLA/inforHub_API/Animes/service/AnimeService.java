package com.UMBRELLA.inforHub_API.Animes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeResponseDTO;
import com.UMBRELLA.inforHub_API.Animes.mapper.AnimeMapper;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import com.UMBRELLA.inforHub_API.Animes.repository.AnimeRepository;
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

    public Long todosAnime() {
        return animeRepository.count();
    }

    public Page<AnimeResponseDTO> mostrarAnimes(Pageable pageable) {
        Page<Anime> animeList = animeRepository.findAllByOrderByNomeAsc(pageable);

        return animeList.map(animeMapper::toResponseDTO);
    }

    public AnimeResponseDTO buscarPorId(Long id) {
        Anime anime = buscarAnimePorId(id);

        return animeMapper.toResponseDTO(anime);
    }

    private Anime buscarAnimePorId(Long id) {
        return animeRepository.findById(id).
        orElseThrow(() -> new ResourceNotFoundException("Nada encontrado."));
    }

    public Page<AnimeResponseDTO> buscarPorGenero(String genero, Pageable pageable) {
        Page<Anime> paginaAnime = animeRepository.findByGeneroContainingIgnoreCaseOrderByNome(genero, pageable);

        if (paginaAnime.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return paginaAnime.map(animeMapper::toResponseDTO);
    }

    public Page<AnimeResponseDTO> buscarPorPlataforma(String ondeAssistir, Pageable pageable) {
        Page<Anime> lista = animeRepository.findByOndeAssistirContainingIgnoreCaseOrderByNome(ondeAssistir, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return lista.map(animeMapper::toResponseDTO);
    }

    public Page<AnimeResponseDTO> buscarPorNome(String nome, Pageable pageable) {
        Page<Anime> listaNomes = animeRepository.findByNomeContainingIgnoreCaseOrderByNomeDesc(nome, pageable);

        if (listaNomes.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum registro encontrado para a busca informada.");
        }

        return listaNomes.map(animeMapper::toResponseDTO);
    }

     public AnimeResponseDTO alterarAnimePorId(AnimeRequestDTO dto, Long id) {
        Anime anime = buscarAnimePorId(id);

        //copiarDadosDoDTO(anime, dto);
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
