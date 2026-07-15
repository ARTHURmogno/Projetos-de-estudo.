package com.UMBRELLA.inforHub_API.Series.repository;

import com.UMBRELLA.inforHub_API.Series.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    boolean exisexistsByNome(String nome);
    
    boolean exiexistsById(Long id);



}
