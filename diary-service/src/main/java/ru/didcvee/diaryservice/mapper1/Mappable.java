package ru.didcvee.diaryservice.mapper1;

import java.util.List;

public interface Mappable<E, D> {
    E toEntity(D d);
    List<E> toEntity(List<D> d);

    D toDto(E e);
    List<D> toDto(List<E> e);
}
