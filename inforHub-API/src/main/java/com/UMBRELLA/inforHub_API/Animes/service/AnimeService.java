package com.UMBRELLA.inforHub_API.Animes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeResponseDTO;

import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import com.UMBRELLA.inforHub_API.Animes.repository.AnimeRepository;
import com.UMBRELLA.inforHub_API.Exception.ResourceNotFoundException;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    private AnimeResponseDTO converterParaAnimeResponseDTO(Anime anime) {
         AnimeResponseDTO response = new AnimeResponseDTO();

         response.setId(anime.getId());
         response.setNome(anime.getNome());
         response.setGenero(anime.getGenero());
         response.setSinopse(anime.getSinopse());
         response.setOndeAssistir(anime.getOndeAssistir());
         response.setAnoDeLancamento(anime.getAnoDeLancamento());
         response.setEpisodios(anime.getEpisodios());
         response.setTemporada(anime.getTemporada());

        return response;

    }

    private void copiarDadosDoDTO(Anime anime, AnimeRequestDTO dto) {

                anime.setNome(dto.getNome());
                anime.setGenero(dto.getGenero());
                anime.setSinopse(dto.getSinopse());
                anime.setOndeAssistir(dto.getOndeAssistir());
                anime.setAnoDeLancamento(dto.getAnoDeLancamento());
                anime.setEpisodios(dto.getEpisodios());
                anime.setTemporada(dto.getTemporada());

    }

    public AnimeResponseDTO adicionarAnime(AnimeRequestDTO dto) {
        Anime anime = new Anime();

        copiarDadosDoDTO(anime, dto);

        if (animeRepository.existsByNome(anime.getNome())) {
            throw new IllegalArgumentException("Anime já cadastrado.");
        }

        Anime novoAnime = animeRepository.save(anime);

        return converterParaAnimeResponseDTO(novoAnime);
    }

    public Long todosAnime() {
        return animeRepository.count();
    }

    public Page<Anime> mostrarAnimes(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public Anime buscarPorId(Long id) {
        return animeRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Nada encontrado."));
    }

    public Page<AnimeResponseDTO> buscarPorGenero(String genero, Pageable pageable) {
        Page<Anime> paginaAnime = animeRepository.findByGeneroContainingIgnoreCaseOrderByNome(genero, pageable);

        if (paginaAnime.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return paginaAnime.map(this::converterParaAnimeResponseDTO);
    }

    public Page<Anime> buscarPorPlataforma(String ondeAssistir, Pageable pageable) {
        Page<Anime> lista = animeRepository.findByOndeAssistirContainingIgnoreCaseOrderByNome(ondeAssistir, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return lista;
    }

    public Page<Anime> buscarPorNome(String nome, Pageable pageable) {
        Page<Anime> listaNomes = animeRepository.findByNomeContainingIgnoreCaseOrderByNomeDesc(nome, pageable);

        if (listaNomes.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum registro encontrado para a busca informada.");
        }

        return listaNomes;
    }

     public AnimeResponseDTO alterarAnimePorId(AnimeRequestDTO dto, Long id) {
        Anime anime = buscarPorId(id);

        copiarDadosDoDTO(anime, dto);

        Anime novoAnime = animeRepository.save(anime);

        return converterParaAnimeResponseDTO(novoAnime);

    }

    public Long deletarPorId(Long id) {
        buscarPorId(id);

        animeRepository.deleteById(id);
        return id;
    }

    
    
}
