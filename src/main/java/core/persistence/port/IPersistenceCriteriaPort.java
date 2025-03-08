package core.persistence.port;

import sg.spring.core.persistence.IPortMarker;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IPersistenceCriteriaPort<D> extends IPortMarker {
    List<D> findByCriteria(Map<String, Object> criteria);
    Optional<D> findOneByCriteria(Map<String, Object> criteria);
}
