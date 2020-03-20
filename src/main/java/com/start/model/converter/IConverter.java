package com.start.model.converter;

public interface IConverter<E, D> {

    E toEntity(D item);

    D toDto(E item);
}
