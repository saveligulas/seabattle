package core.persistence.port;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface IPersistenceFindAllByIdPort<D, ID> {
    List<D> findAll(Collection<ID> ids);
    Set<D> findAllSet(Collection<ID> ids);
}
