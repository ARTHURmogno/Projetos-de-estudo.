package com.UMBRELLA.ControleDeGastos.model;

import java.time.LocalDateTime;

public class UsuarioModel {

    private Long id;
    private String nome;
    private Long gastosMensal;

    public UsuarioModel(Long id, String nome, Long gastosMensal) {
        this.id = id;
        this.nome = nome;
        this.gastosMensal = gastosMensal;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Long getGastosMensal() {
        return gastosMensal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
