package com.UMBRELLA.inforHub_API.Series.repository;

import java.util.List;

import com.UMBRELLA.inforHub_API.Series.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    boolean existsByNome(String nome);
    
    boolean existsById(Long id);

    List<Serie> findByGenero(String genero);

    List<Serie> findByLancamento(String lancamento);

    List<Serie> findByOndeAssistir(String ondeAssistir);



}
