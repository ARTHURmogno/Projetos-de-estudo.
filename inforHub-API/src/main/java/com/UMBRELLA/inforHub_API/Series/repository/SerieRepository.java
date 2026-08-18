package com.UMBRELLA.inforHub_API.Series.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.UMBRELLA.inforHub_API.Series.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    boolean existsByNome(String nome);
    boolean existsById(Long id);

    Page<Serie> findAllByOrderByNome(Pageable pageable);

    Page<Serie> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Page<Serie> findByGeneroContainingIgnoreCase(String genero, Pageable pageable);
    Page<Serie> findByLancamentoContainingIgnoreCase(String lancamento, Pageable pageable);
    Page<Serie> findByOndeAssistirContainingIgnoreCase(String ondeAssistir, Pageable pageable);



}
