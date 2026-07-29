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

    /*public AnimeRequestDTO converterParaAnimeRequestDTO(Anime anime) {
        AnimeRepository dto = new AnimeRepository();

         dto.setNome(anime.getNome());
         anime.setGenero(dto.getGenero());
         anime.setSinopse(dto.getSinopse());
         anime.setOndeAssistir(dto.getOndeAssistir());
         anime.setAnoDeLancamento(dto.getAnoDeLancamento());
         anime.setEpisodios(dto.getEpisodios());
         anime.setTemporada(dto.getTemporada());

    }*/

    public AnimeResponseDTO adicionarAnime(AnimeRequestDTO dto) {
        Anime anime = new Anime();

        anime.setNome(dto.getNome());
        anime.setGenero(dto.getGenero());
        anime.setSinopse(dto.getSinopse());
        anime.setOndeAssistir(dto.getOndeAssistir());
        anime.setAnoDeLancamento(dto.getAnoDeLancamento());
        anime.setEpisodios(dto.getEpisodios());
        anime.setTemporada(dto.getTemporada());

        if (animeRepository.existsByNome(anime.getNome())) {
            throw new IllegalArgumentException("Anime já cadastrado.");
        }

         Anime novoAnime = animeRepository.save(anime);

         AnimeResponseDTO response = new AnimeResponseDTO();

         response.setId(novoAnime.getId());
         response.setNome(novoAnime.getNome());
         response.setGenero(novoAnime.getGenero());
         response.setSinopse(novoAnime.getSinopse());
         response.setOndeAssistir(novoAnime.getOndeAssistir());
         response.setAnoDeLancamento(novoAnime.getAnoDeLancamento());
         response.setEpisodios(novoAnime.getEpisodios());
         response.setTemporada(novoAnime.getTemporada());

         return response;

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

    public Page<Anime> buscarPorGenero(String genero, Pageable pageable) {
        Page<Anime> lista = animeRepository.findByGeneroContainingIgnoreCaseOrderByNome(genero, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return lista;
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

    /*public Anime alterarAnimePorId(Anime novoAnime, Long id) {
        Anime anime = animeRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Nada encontrado: " + id));

                anime.setNome(novoAnime.getNome());
                anime.setGenero(novoAnime.getGenero());
                anime.setSinopse(novoAnime.getSinopse());
                anime.setOndeAssistir(novoAnime.getOndeAssistir());
                anime.setAnoDeLancamento(novoAnime.getAnoDeLancamento());
                anime.setEpisodios(novoAnime.getEpisodios());
                anime.setTemporada(novoAnime.getTemporada());
                
                animeRepository.save(anime);

            return anime;
        }*/

            public AnimeResponseDTO alterarAnimePorId(AnimeRequestDTO dto, Long id) {
                Anime anime = buscarPorId(id);

                 anime.setNome(dto.getNome());
                 anime.setGenero(dto.getGenero());
                 anime.setSinopse(dto.getSinopse());
                 anime.setOndeAssistir(dto.getOndeAssistir());
                 anime.setAnoDeLancamento(dto.getAnoDeLancamento());
                 anime.setEpisodios(dto.getEpisodios());
                 anime.setTemporada(dto.getTemporada());

                Anime novoAnime = animeRepository.save(anime);

                AnimeResponseDTO response = new AnimeResponseDTO();

                 response.setId(novoAnime.getId());
                 response.setNome(novoAnime.getNome());
                 response.setGenero(novoAnime.getGenero());
                 response.setSinopse(novoAnime.getSinopse());
                 response.setOndeAssistir(novoAnime.getOndeAssistir());
                 response.setAnoDeLancamento(novoAnime.getAnoDeLancamento());
                 response.setEpisodios(novoAnime.getEpisodios());
                 response.setTemporada(novoAnime.getTemporada());

                 return response;

            }

    public Long deletarPorId(Long id) {
        buscarPorId(id);

        animeRepository.deleteById(id);
        return id;
    }

    
    
}
