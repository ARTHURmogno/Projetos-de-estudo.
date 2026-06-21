package com_UMBRELLA.Segundo_Spring;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository 
    extends JpaRepository<Pessoa, Long> {


    }
