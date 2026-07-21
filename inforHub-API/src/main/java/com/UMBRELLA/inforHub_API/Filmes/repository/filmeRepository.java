package com.UMBRELLA.inforHub_API.Filmes.repository;

import java.util.List;

import com.UMBRELLA.inforHub_API.Filmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface filmeRepository extends JpaRepository<Filme, Long> {

}
