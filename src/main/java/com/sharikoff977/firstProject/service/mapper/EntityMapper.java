package com.sharikoff977.firstProject.service.mapper;

import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */

public interface EntityMapper <D, E> {

    default E toEntity(D dto) {
        // to prevent default mapstruct generation
        throw new UnsupportedOperationException("Not implemented yet");
    }

    D toDto(E entity);

    default List <E> toEntity(List<D> dtoList) {
        // to prevent default mapstruct generation
        throw new UnsupportedOperationException("Not implemented yet");
    }

    //List <D> toDto(List<E> entityList);
}

