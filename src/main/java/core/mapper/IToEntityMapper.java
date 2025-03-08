package core.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface IToEntityMapper<D, E> {
    E toEntity(D domain);

    default List<E> toEntityList(List<D> domains) {
        if (domains == null) {
            return new ArrayList<>();
        }

        return domains.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    default Set<E> toEntitySet(Set<D> domains) {
        if (domains == null) {
            return new HashSet<>();
        }

        return domains.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }
}
