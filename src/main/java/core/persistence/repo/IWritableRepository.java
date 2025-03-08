package core.persistence.repo;


import sg.spring.core.persistence.port.IPersistenceSaveAllPort;
import sg.spring.core.persistence.port.IPersistenceSavePort;

public interface IWritableRepository<D> extends IPersistenceSavePort<D>, IPersistenceSaveAllPort<D> {
}
