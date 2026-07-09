package com.UMBRELLA.inforHub_API.Animes.service;

import java.util.List;
import java.util.ArrayList;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;

public class AnimeService {
    private List<Anime> animes = new ArrayList<>();

    Long proximoId = 1L;

    public Anime adicionarAnime(Anime anime) {

        for (Anime animeNew : animes) {
            if (animeNew.getNome().trim().equalsIgnoreCase(anime.getNome().trim())) {
                throw new IllegalArgumentException("Anime já cadastrado.");
        }
    }

        anime.setId(proximoId);
        proximoId++;

        animes.add(anime);

        return anime;


    }

    public List<Anime> listarTodos() {

     return animes;
    }

    public Anime buscarPorId(Long id) {

        for (Anime anime : animes) {
            if (anime.getId().equals(id)) {
                return anime;
            }
        }

        throw new IllegalArgumentException("Nenhum anime encontrado com o id: " + id);

    }

    public List<Anime> buscarPorEspecifico(String especifico) {
        List<Anime> animesEspecificos = new ArrayList<>();

        for (Anime anime : animes) {
            if (anime.getGenero().trim().equalsIgnoreCase(especifico) || anime.getOndeAssistir().trim().equalsIgnoreCase(especifico)) {
                animesEspecificos.add(anime);
            }
        }

        if (animesEspecificos.isEmpty()) {
           throw new IllegalArgumentException("Nenhum anime encontrado com estas especificações:" + especifico);
        }

        return animesEspecificos;

    }

    public Anime alterarAnimePorId(Anime novoAnime, Long id) {

        for (Anime anime : animes) {
            if (anime.getId().equals(id)) {

                anime.setNome(novoAnime.getNome());
                anime.setGenero(novoAnime.getGenero());
                anime.setSinopse(novoAnime.getSinopse());
                anime.setOndeAssistir(novoAnime.getOndeAssistir());
                anime.setAnoDeLancamento(novoAnime.getAnoDeLancamento());
                anime.setEpisodios(novoAnime.getEpisodios());
                anime.setTemporada(novoAnime.getTemporada());

                return novoAnime;

            }
        }

        throw new IllegalArgumentException("nenhum anime encontrado com esté id." + id);

    }

    public Long deletarPorId(Long id) {

        Anime encontrado = buscarPorId(id);
        animes.remove(encontrado);
        return id;

    }

    
    
}
