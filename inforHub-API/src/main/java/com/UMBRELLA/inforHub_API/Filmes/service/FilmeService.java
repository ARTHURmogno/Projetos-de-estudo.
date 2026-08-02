package com.UMBRELLA.inforHub_API.Filmes.service;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.repository.AnimeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeRequestDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeResponseDTO;
import com.UMBRELLA.inforHub_API.Filmes.model.Filme;
import com.UMBRELLA.inforHub_API.Filmes.repository.FilmeRepository;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    private FilmeResponseDTO converterFilmeParaFilmeResponseDTO(Filme filme) {
        FilmeResponseDTO response = new FilmeResponseDTO();

        response.setId(filme.getId());
        response.setNome(filme.getNome());
        response.setSinopse(filme.getSinopse());
        response.setGenero(filme.getGenero());
        response.setDuracao(filme.getDuracao());
        response.setOndeAssistir(filme.getOndeAssistir());

        return response;

    }

    private void copiarDadosDoDTO(Filme filme, FilmeRequestDTO dto) {

        filme.setNome(dto.getNome());
        filme.setSinopse(dto.getSinopse());
        filme.setGenero(dto.getGenero());
        filme.setDuracao(dto.getDuracao());
        filme.setOndeAssistir(dto.getOndeAssistir());

    }

    public FilmeResponseDTO adicionarFilme(FilmeRequestDTO dto) {
        Filme filme = new Filme();

        copiarDadosDoDTO(filme, dto);

        if (filmeRepository.existsByTitulo(filme.getNome())) {
            throw new IllegalArgumentException("Filme já cadastrado.");
        }

        Filme novoFilme = filmeRepository.save(filme);

        return converterFilmeParaFilmeResponseDTO(novoFilme);
      
    }

    public Long todosOsFilmes() {
        Long quantidade = filmeRepository.count();

        return quantidade;
    }

    public Page<FilmeResponseDTO> mostrarFilmes(Pageable pageable) {
        Page<Filme> listaDeFilmes = filmeRepository.findAll(pageable);

        if (listaDeFilmes.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return listaDeFilmes.map(this::converterFilmeParaFilmeResponseDTO);
    }

    public Page<FilmeResponseDTO> buscarPorNome(String nome, Pageable pageable) {
        Page<Filme> listaDeNome = filmeRepository.findByNomeContainingIgnoreCaseOrderByNome(nome, pageable);

        if (listaDeNome.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return listaDeNome.map(this::converterFilmeParaFilmeResponseDTO);
    }

    public Page<FilmeResponseDTO> buscarPorGenero(String genero, Pageable pageable) {
        Page<Filme> lista = filmeRepository.findByGeneroContainingIgnoreCaseOrderByNomeDesc(genero, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Buscar por Gênero, nada encontrado.");
        }

        return lista.map(this::converterFilmeParaFilmeResponseDTO);
    }

    public Page<FilmeResponseDTO> buscarPorPlataforma(String ondeAssistri, Pageable pageable) {
        Page<Filme> lista = filmeRepository.findByOndeAssistirContainingIgnoreCaseOrderByNomeDesc(ondeAssistri, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Busca por Plataforma, nada encontrado.");
        }

        return lista.map(this::converterFilmeParaFilmeResponseDTO);
    }

    public FilmeResponseDTO buscarPorId(Long id) {
        Filme filme = buscarFilmePorId(id);

        return converterFilmeParaFilmeResponseDTO(filme);
    }

    private Filme buscarFilmePorId(Long id) {
        return filmeRepository.findById(id) 
        .orElseThrow(() -> new IllegalArgumentException("Nada encontrado." + id));
    }

    public FilmeResponseDTO alterarPorId(FilmeRequestDTO dto, Long id) {
        Filme filme = buscarFilmePorId(id);

        copiarDadosDoDTO(filme, dto);

        Filme novoFilme = filmeRepository.save(filme);

        return converterFilmeParaFilmeResponseDTO(novoFilme);
    }

    public Long deletarPorId(Long id) {
        buscarFilmePorId(id);

        filmeRepository.deleteById(id);
        return id;
    }
    
}
