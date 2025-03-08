package core.persistence.port;

import java.util.Collection;

public interface IPersistenceSaveAllPort<D> {
    void saveAll(Collection<D> data);
}
