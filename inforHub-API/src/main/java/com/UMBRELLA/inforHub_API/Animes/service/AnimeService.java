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
                throw new IllegalArgumentException("Anime já essiste.");
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

    
    
}
