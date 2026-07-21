package com.UMBRELLA.inforHub_API.Filmes.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.UMBRELLA.inforHub_API.Filmes.model.Filme;
import com.UMBRELLA.inforHub_API.Filmes.repository.FilmeRepository;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme adicionarFilme(Filme novoFilme) {
        if (filmeRepository.existsByTitulo(novoFilme.getTitulo())) {
            throw new IllegalArgumentException("Filme já cadastrado.");
        }

        return filmeRepository.save(novoFilme);
    }

    public Long todosOsFilmes() {
        Long quantidade = filmeRepository.count();

        return quantidade;
    }

    public List<Filme> buscarPorGenero(String genero) {
        List<Filme> lista = filmeRepository.findByGenero(genero);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Buscar por Gênero, nada encontrado.");
        }

        return lista;
    }

    public List<Filme> buscarPorPlataforma(String ondeAssistri) {
        List<Filme> lista = filmeRepository.findByOndeAssistir(ondeAssistri);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Busca por Plataforma, nada encontrado.");
        }

        return lista;
    }

    public Filme buscarPorId(Long id) {
        return filmeRepository.findById(id) 
        .orElseThrow(() -> new IllegalArgumentException("Nada encontrado." + id));
    }

    public Filme alterarPorId(Filme novoFilme, Long id) {
        Filme filme = filmeRepository.findById(id) 
        .orElseThrow(() -> new IllegalArgumentException("Nada encontrado." + id));

                filme.setTitulo(novoFilme.getTitulo());
                filme.setSinopse(novoFilme.getSinopse());
                filme.setGenero(novoFilme.getGenero());
                filme.setDuracao(novoFilme.getDuracao());
                filme.setOndeAssistir(novoFilme.getOndeAssistir());
            
        filmeRepository.save(filme);
        return filme;
    }

    public Long deletarPorId(Long id) {
        buscarPorId(id);

        filmeRepository.deleteById(id);
        return id;
    }
    
}
