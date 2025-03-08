package core.persistence.port;

import java.util.Optional;

public interface IPersistenceOptionalFindPort<D, ID> {
    Optional<D> findOpt(ID id);
}
