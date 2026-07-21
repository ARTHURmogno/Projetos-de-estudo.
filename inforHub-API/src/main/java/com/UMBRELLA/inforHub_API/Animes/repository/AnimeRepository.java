package com.UMBRELLA.inforHub_API.Animes.repository;

import java.util.List;

import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    boolean findByNome(String nome);
    boolean findById(Long id);

}
