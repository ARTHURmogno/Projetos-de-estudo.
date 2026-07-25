package com.UMBRELLA.inforHub_API.Animes.repository;

import java.util.List;

import com.UMBRELLA.inforHub_API.Animes.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    boolean existsByNome(String nome);
    boolean existsById(Long id);

    List<Anime> findByGenero(String genero);
    List<Anime> findByOndeAssistir(String ondeAssistir);
    List<Anime> findByNomeContainingIgnoreCaseOrden(String nome);

    List<Anime> findAllByOrderByNomeAsc(String nome); //n
    List<Anime> findAllByOrderByNomeDesc(String nome); //n

    List<Anime> findALLByAnoDeLancamentoAsc(int anoDeLancamento); //n
    List<Anime> findALLByOrdenByAnoDeLancamentoDesc(int anoDeLancamento); //n


}
