package com.UMBRELLA.inforHub_API.Filmes.specification;

import org.springframework.data.jpa.domain.Specification;

import com.UMBRELLA.inforHub_API.Filmes.dto.FilmeFiltroDTO;
import com.UMBRELLA.inforHub_API.Filmes.model.Filme;

import jakarta.persistence.criteria.Predicate;

public class FilmeSpecification {

    public static Specification<Filme> filtroDeFilme(FilmeFiltroDTO filtroDTO) {

        return (root, query, builder ) -> {
            Predicate predicate = builder.conjunction();

            if (filtroDTO.getNome() != null && !filtroDTO.getNome().isBlank()) {

                String nomeBuscar = "%" + filtroDTO.getNome().toLowerCase() + "%";
                Predicate nomePredicate = builder.like(builder.lower(root.get("nome")), nomeBuscar);

                predicate = builder.and(predicate, nomePredicate);

            }

            if (filtroDTO.getGenero() != null && !filtroDTO.getGenero().isBlank()) {

                String generoBuscar = "%" + filtroDTO.getGenero().toLowerCase() + "%";
                Predicate generoPredicate = builder.like(builder.lower(root.get("genero")), generoBuscar);

                predicate = builder.and(predicate, generoPredicate);

            }

            if (filtroDTO.getOndeAssistir() != null&& !filtroDTO.getOndeAssistir().isBlank()) {

                String ondeAssistirBuscar = "%" + filtroDTO.getOndeAssistir().toLowerCase() + "%";
                Predicate ondeAssistirPredicate = builder.like(builder.lower(root.get("ondeAssistir")), ondeAssistirBuscar);

                predicate = builder.and(predicate, ondeAssistirPredicate);

            }

            return predicate;

        };

    }
    
}
