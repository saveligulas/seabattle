package core.persistence.repo;

import sg.spring.core.persistence.port.IPersistenceDeletePort;

public interface IBaseRepository<D, ID> extends IReadRepository<D, ID>, IWritableRepository<D>, IPersistenceDeletePort<D, ID> {
}
