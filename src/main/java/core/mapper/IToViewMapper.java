package core.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface IToViewMapper<D, T> {
    T toView(D domain);

    default List<T> toViewList(List<D> domains) {
        if (domains == null) {
            return new ArrayList<>();
        }

        return domains.stream()
                .map(this::toView)
                .collect(Collectors.toList());
    }

    default Set<T> toViewSet(Set<D> domains) {
        if (domains == null) {
            return new HashSet<>();
        }

        return domains.stream()
                .map(this::toView)
                .collect(Collectors.toSet());
    }
}
