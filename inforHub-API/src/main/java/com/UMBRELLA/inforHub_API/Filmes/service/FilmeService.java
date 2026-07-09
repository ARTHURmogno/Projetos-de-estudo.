package com.UMBRELLA.inforHub_API.Filmes.service;

import java.util.List;
import java.util.ArrayList;
import com.UMBRELLA.inforHub_API.Filmes.model.Filme;

public class FilmeService {
    private List<Filme> filmes = new ArrayList<>();

    Long proximalId = 1L;

    public Filme adicionarFilme(Filme novoFilme) {

        for (Filme filme : filmes) {
            if (filme.getTitulo().trim().equalsIgnoreCase(novoFilme.getTitulo())) {
                throw new IllegalArgumentException("Filme já cadastrado:"); 
            }
        }

        novoFilme.setId(proximalId);
        proximalId++;

        filmes.add(novoFilme);
        return novoFilme;

    }

    public List<Filme> listarTodos() {
        return filmes;
    }

    public List<Filme> buscarPoEspecifico(String genero) {
        List<Filme> especificos = new ArrayList<>();

        for (Filme filme : filmes) {
            if (filme.getGenero().trim().equalsIgnoreCase(genero)) {
                especificos.add(filme);
            }
        }

        if (especificos.isEmpty()) {
            throw new IllegalArgumentException("Nem um filme emcontrodo por: " + genero);
        }

        return especificos;

    }

    public Filme buscarPorId(Long id) {

        for (Filme filme : filmes) {
            if (filme.getId().equals(id)) {
                return filme;
            }
        }

            throw new IllegalArgumentException("id não encontrado: " + id);
    }

    public Filme alterarPorId(Filme novoFilme, Long id) {

        for (Filme filme : filmes) {
            if (filme.getId().equals(id)) {

                filme.setTitulo(novoFilme.getTitulo());
                filme.setSinopse(novoFilme.getSinopse());
                filme.setGenero(novoFilme.getGenero());
                filme.setDuracao(novoFilme.getDuracao());
                filme.setOndeAssistir(novoFilme.getOndeAssistir());

                return filme;
            }
        }

        throw new IllegalArgumentException("id não encontrado: " + id);

    }

    public Long deletarPorId(Long id) {
        Filme encontrado = buscarPorId(id);
        filmes.remove(encontrado);

        return id;
    }
    
}
