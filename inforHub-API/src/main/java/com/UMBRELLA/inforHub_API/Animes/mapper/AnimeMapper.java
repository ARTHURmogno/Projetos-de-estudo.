package com.UMBRELLA.inforHub_API.Animes.mapper;

import org.mapstruct.Mapper;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeResponseDTO;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;

@Mapper(componentModel = "spring")
public interface AnimeMapper {

    Anime toEntity(AnimeRequestDTO dto);

    AnimeResponseDTO toResponseDTO(Anime anime);
    
}
