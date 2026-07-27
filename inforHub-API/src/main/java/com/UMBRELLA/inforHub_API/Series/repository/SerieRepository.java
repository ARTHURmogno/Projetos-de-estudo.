package com.UMBRELLA.inforHub_API.Series.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.UMBRELLA.inforHub_API.Series.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    boolean existsByNome(String nome);
    boolean existsById(Long id);

    Page<Serie> findByNomeContainingIgnoreCaseOrderByNomeDesc(String nome, Pageable pageable);
    Page<Serie> findByGeneroContainingIgnoreCaseOrderByNomeDesc(String genero, Pageable pageable);
    Page<Serie> findByLancamentoContainingIgnoreCaseOrderByNomeDesc(String lancamento, Pageable pageable);
    Page<Serie> findByOndeAssistirContainingIgnoreCaseOrderByNomeDesc(String ondeAssistir, Pageable pageable);



}
