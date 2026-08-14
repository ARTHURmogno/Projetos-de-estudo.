package com.UMBRELLA.inforHub_API.Animes.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeRequestDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeResponseDTO;
import com.UMBRELLA.inforHub_API.Animes.dto.AnimeUpdateDTO;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;

@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AnimeMapper {

    Anime toEntity(AnimeRequestDTO dto);

    AnimeResponseDTO toResponseDTO(Anime anime);

    @Mapping(target = "id", ignore = true)
    void atualizarAnime(AnimeUpdateDTO dto, @MappingTarget Anime anime);
    
}
