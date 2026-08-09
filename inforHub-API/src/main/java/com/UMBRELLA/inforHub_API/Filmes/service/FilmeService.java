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
import com.UMBRELLA.inforHub_API.Filmes.mapper.FilmeMapper;
import com.UMBRELLA.inforHub_API.Filmes.model.Filme;
import com.UMBRELLA.inforHub_API.Filmes.repository.FilmeRepository;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final FilmeMapper filmeMapper;

    public FilmeService(FilmeRepository filmeRepository, FilmeMapper filmeMapper) {
        this.filmeRepository = filmeRepository;
        this.filmeMapper = filmeMapper;
    }

    public FilmeResponseDTO adicionarFilme(FilmeRequestDTO dto) {
        Filme filme = filmeMapper.toEntity(dto);

        if (filmeRepository.existsByNome(filme.getNome())) {
            throw new IllegalArgumentException("Filme já cadastrado.");
        }

        Filme novoFilme = filmeRepository.save(filme);

        return filmeMapper.toResponseDTO(novoFilme);
      
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

        return listaDeFilmes.map(filmeMapper::toResponseDTO);
    }

    public Page<FilmeResponseDTO> buscarPorNome(String nome, Pageable pageable) {
        Page<Filme> listaDeNome = filmeRepository.findByNomeContainingIgnoreCaseOrderByNome(nome, pageable);

        if (listaDeNome.isEmpty()) {
            throw new IllegalArgumentException("Nada encontrado.");
        }

        return listaDeNome.map(filmeMapper::toResponseDTO);
    }

    public Page<FilmeResponseDTO> buscarPorGenero(String genero, Pageable pageable) {
        Page<Filme> lista = filmeRepository.findByGeneroContainingIgnoreCaseOrderByNomeDesc(genero, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Buscar por Gênero, nada encontrado.");
        }

        return lista.map(filmeMapper::toResponseDTO);
    }

    public Page<FilmeResponseDTO> buscarPorPlataforma(String ondeAssistri, Pageable pageable) {
        Page<Filme> lista = filmeRepository.findByOndeAssistirContainingIgnoreCaseOrderByNomeDesc(ondeAssistri, pageable);

        if (lista.isEmpty()) {
            throw new IllegalArgumentException("Busca por Plataforma, nada encontrado.");
        }

        return lista.map(filmeMapper::toResponseDTO);
    }

    public FilmeResponseDTO buscarPorId(Long id) {
        Filme filme = buscarFilmePorId(id);

        return filmeMapper.toResponseDTO(filme);
    }

    private Filme buscarFilmePorId(Long id) {
        return filmeRepository.findById(id) 
        .orElseThrow(() -> new IllegalArgumentException("Nada encontrado." + id));
    }

    public FilmeResponseDTO alterarPorId(FilmeRequestDTO dto, Long id) {
        Filme filme = buscarFilmePorId(id);

        filmeMapper.toEntity(dto);

        Filme filmeAtualizar = filmeRepository.save(filme);

        return filmeMapper.toResponseDTO(filmeAtualizar);
    }

    public Long deletarPorId(Long id) {
        buscarFilmePorId(id);

        filmeRepository.deleteById(id);
        return id;
    }
    
}
