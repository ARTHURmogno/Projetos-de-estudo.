package com.UMBRELLA.inforHub_API.Filmes.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeRequestDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeResponseDTO;
import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeUpdateDTO;
import com.UMBRELLA.inforHub_API.Filmes.model.Filme;

@Mapper(componentModel = "spring", 
  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FilmeMapper {

    Filme toEntity(FilmeRequestDTO dto);

    FilmeResponseDTO toResponseDTO(Filme filme);

    @Mapping(target = "id", ignore = true)
    void atualizarFilme(FilmeUpdateDTO dto, @MappingTarget Filme filme);

}
