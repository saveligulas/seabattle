package core.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface IToDomainMapper<D, E> {
    D toDomain(E entity);

    default Set<D> toDomainSet(Set<E> entities) {
        if (entities == null) {
            return new HashSet<>();
        }

        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toSet());
    }

    default List<D> toDomainList(List<E> entities) {
        if (entities == null) {
            return new ArrayList<>();
        }

        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}
