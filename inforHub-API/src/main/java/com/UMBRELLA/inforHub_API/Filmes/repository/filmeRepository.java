package com.UMBRELLA.inforHub_API.Filmes.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.UMBRELLA.inforHub_API.Filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    boolean existsByNome(String nome);
    boolean existsById(Long id);

    Page<Filme> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
    Page<Filme> findByGeneroContainingIgnoreCase(String genero, Pageable pageable);
    Page<Filme> findByOndeAssistirContainingIgnoreCase(String ondeAssistir, Pageable pageable);

    List<Filme> findAllByOrderByGeneroDesc(String genero);

}
