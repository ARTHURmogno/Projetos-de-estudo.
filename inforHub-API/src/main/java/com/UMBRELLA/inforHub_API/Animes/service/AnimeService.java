package com.UMBRELLA.inforHub_API.Animes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import com.UMBRELLA.inforHub_API.Animes.repository.AnimeRepository;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime adicionarAnime(Anime novoAnime) {
        if (animeRepository.existsByNome(novoAnime.getNome())) {
            throw new IllegalArgumentException("Anime já cadastrado.");
        }

        return animeRepository.save(novoAnime);
    }

    public Long todosAnime() {
        return animeRepository.count();
    }

    public Anime buscarPorId(Long id) {
        return animeRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Nada encontrado."));
    }

    public List<Anime> buscarPorGenero(String genero) {
        List<Anime> lista = animeRepository.findByGenero(genero);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return lista;
    }

    public List<Anime> buscarPorPlataforma(String ondeAssistir) {
        List<Anime> lista = animeRepository.findByOndeAssistir(ondeAssistir);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return lista;
    }

    public Anime alterarAnimePorId(Anime novoAnime, Long id) {
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
        }

    public Long deletarPorId(Long id) {
        buscarPorId(id);

        animeRepository.deleteById(id);
        return id;
    }

    
    
}
