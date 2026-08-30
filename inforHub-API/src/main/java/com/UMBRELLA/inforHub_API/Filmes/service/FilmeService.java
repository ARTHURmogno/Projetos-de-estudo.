package com.UMBRELLA.inforHub_API.Filmes.service;

import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeFiltroDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeRequestDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeResponseDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeUpdateDTO;
import com.UMBRELLA.inforHub_API.Filmes.mapper.FilmeMapper;
import com.UMBRELLA.inforHub_API.Filmes.model.Filme;
import com.UMBRELLA.inforHub_API.Filmes.repository.FilmeRepository;
import com.UMBRELLA.inforHub_API.Filmes.specification.FilmeSpecification;

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

    public Long contarOsFilmes() {
        Long quantidade = filmeRepository.count();

        return quantidade;
    }

    public Page<FilmeResponseDTO> buscarFilmePorFiltro(FilmeFiltroDTO filtro, Pageable pageable) {
        Specification<Filme> specification = FilmeSpecification.filtroDeFilme(filtro);

        Page<Filme> pagina = filmeRepository.findAll(specification, pageable);

        return pagina.map(filmeMapper::toResponseDTO);

    }

    public FilmeResponseDTO buscarPorId(Long id) {
        Filme filme = buscarFilmePorId(id);

        return filmeMapper.toResponseDTO(filme);
    }

    private Filme buscarFilmePorId(Long id) {
        return filmeRepository.findById(id) 
        .orElseThrow(() -> new IllegalArgumentException("Nada encontrado." + id));
    }

    public FilmeResponseDTO alterarPorId(FilmeUpdateDTO dto, Long id) {
        Filme filme = buscarFilmePorId(id);

        filmeMapper.atualizarFilme(dto, filme);

        Filme filmeAtualizar = filmeRepository.save(filme);

        return filmeMapper.toResponseDTO(filmeAtualizar);
    }

    public Long deletarPorId(Long id) {
        buscarFilmePorId(id);

        filmeRepository.deleteById(id);
        return id;
    }
    
}
