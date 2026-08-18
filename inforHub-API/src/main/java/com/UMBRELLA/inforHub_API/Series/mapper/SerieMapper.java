package com.UMBRELLA.inforHub_API.Series.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.UMBRELLA.inforHub_API.Series.dto.SerieRequestDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieResponseDTO;
import com.UMBRELLA.inforHub_API.Series.dto.SerieUpdateDTO;
import com.UMBRELLA.inforHub_API.Series.model.Serie;

@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SerieMapper {

    Serie toEntity(SerieRequestDTO dto);

    SerieResponseDTO toResponseDTO(Serie serie);

    @Mapping(target = "id", ignore = true)
    void atualizarSerie(SerieUpdateDTO dto, @MappingTarget Serie serie);
    
}
