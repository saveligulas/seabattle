package core.persistence.port;

import sg.spring.core.persistence.IPortMarker;

public interface IPersistenceDeletePort<D, ID> extends IPortMarker {
    void delete(ID id);
}
