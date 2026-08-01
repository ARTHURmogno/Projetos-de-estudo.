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

    Page<Anime> findByGeneroContainingIgnoreCaseOrderByNome(String genero, Pageable pageable);
    Page<Anime> findByOndeAssistirContainingIgnoreCaseOrderByNome(String ondeAssistir, Pageable pageable);
    Page<Anime> findByNomeContainingIgnoreCaseOrderByNomeDesc(String nome, Pageable pageable);

    List<Anime> findAllByOrderByNomeAsc(); //n

    List<Anime> findAllByOrderByAnoDeLancamentoAsc(); //n
    List<Anime> findAllByOrderByAnoDeLancamentoDesc(); //n


}
