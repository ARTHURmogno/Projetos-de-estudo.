package com.UMBRELLA.inforHub_API.Animes.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeResponseDTO;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    boolean existsByNome(String nome);
    boolean existsById(Long id);

    Page<Anime> findByGeneroContainingIgnoreCase(String genero, Pageable pageable);
    Page<Anime> findByOndeAssistirContainingIgnoreCase(String ondeAssistir, Pageable pageable);
    Page<Anime> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

    Page<Anime> findAllByOrderByNomeAsc(Pageable pageable);

    List<Anime> findAllByOrderByAnoDeLancamentoAsc(); //n
    List<Anime> findAllByOrderByAnoDeLancamentoDesc(); //n


}
