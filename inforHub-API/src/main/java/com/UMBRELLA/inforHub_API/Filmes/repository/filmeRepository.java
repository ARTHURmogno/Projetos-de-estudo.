package com.UMBRELLA.inforHub_API.Filmes.repository;

import java.util.List;

import com.UMBRELLA.inforHub_API.Filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    boolean existsByTitulo(String titulo);

    boolean existsById(Long id);

    List<Filme> findByGenero(String genero);
    
    List<Filme> findByOndeAssistir(String ondeAssistir);

}
