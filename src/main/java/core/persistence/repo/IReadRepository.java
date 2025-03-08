package core.persistence.repo;

import sg.spring.core.persistence.port.IPersistenceFindAllByIdPort;
import sg.spring.core.persistence.port.IPersistenceFindPort;
import sg.spring.core.persistence.port.IPersistenceOptionalFindPort;
import sg.spring.core.persistence.port.IPersistencePaginationPort;

public interface IReadRepository<D, ID> extends IPersistenceOptionalFindPort<D, ID>, IPersistenceFindPort<D, ID>, IPersistencePaginationPort<D>, IPersistenceFindAllByIdPort<D, ID> {
}
