package com_UMBRELLA.Segundo_Spring;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;
    private String profissao;

    public Pessoa(int id, String nome, int idade, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
        this.id = id;

    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public int getId() {
        return id;
    }
    
}
