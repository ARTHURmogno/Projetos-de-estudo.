package com.UMBRELLA.inforHub_API.Series.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.UMBRELLA.inforHub_API.Series.dto.SerieRequestDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieResponseDTO;
import com.UMBRELLA.inforHub_API.Series.model.Serie;

@Mapper(componentModel = "spring")
public interface SerieMapper {

    Serie toEntity(SerieRequestDTO dto);

    SerieResponseDTO toResponseDTO(Serie serie);

    void atualizarSerie(SerieRequestDTO dto, @MappingTarget Serie serie);
    
}
