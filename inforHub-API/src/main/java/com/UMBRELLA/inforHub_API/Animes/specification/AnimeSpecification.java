package com.UMBRELLA.inforHub_API.Animes.specification;

import org.springframework.data.jpa.domain.Specification;

import com.UMBRELLA.inforHub_API.Animes.dto.AnimeFiltroDTO;
import com.UMBRELLA.inforHub_API.Animes.model.Anime;

import jakarta.persistence.criteria.Predicate;

public class AnimeSpecification {

    public static Specification<Anime> comFiltros(AnimeFiltroDTO filtro) {

        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction();

            if (filtro.getNome() != null && !filtro.getNome().isBlank()) {

                String nomeBuscar = "%" + filtro.getNome().toLowerCase() + "%";
                Predicate nomePredicate = builder.like(builder.lower(root.get("nome")), nomeBuscar);

                predicate = builder.and(predicate, nomePredicate);

            }

            if (filtro.getGenero() != null && !filtro.getGenero().isBlank()) {

                String generoBuscar = "%" + filtro.getGenero().toLowerCase() + "%";
                Predicate generoPredicate = builder.like(builder.lower(root.get("genero")), generoBuscar);

                predicate = builder.and(predicate, generoPredicate);

            }

            if (filtro.getOndeAssistir() != null && !filtro.getOndeAssistir().isBlank()) {

                String ondeAssistirBuscar = "%" + filtro.getOndeAssistir().toLowerCase() + "%";
                Predicate ondeAssistirPredicate = builder.like(builder.lower(root.get("ondeAssistir")), ondeAssistirBuscar);

                predicate = builder.and(predicate, ondeAssistirPredicate);

            }

            return predicate;
        };

    }
    
}
