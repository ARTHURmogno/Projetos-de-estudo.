package com.UMBRELLA.inforHub_API.Filmes.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeRequestDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeResponseDTO;
import com.UMBRELLA.inforHub_API.Filmes.model.Filme;

@Mapper(componentModel = "spring")
public interface FilmeMapper {

    Filme toEntity(FilmeRequestDTO dto);

    FilmeResponseDTO toResponseDTO(Filme filme);

    void atualizarFilme(FilmeRequestDTO dto, @MappingTarget Filme filme);

}
