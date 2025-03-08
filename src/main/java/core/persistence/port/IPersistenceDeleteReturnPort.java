package core.persistence.port;

import sg.spring.core.persistence.IPortMarker;

public interface IPersistenceDeleteReturnPort<D, ID> extends IPortMarker {
    D delete(ID id);
}
