package core.persistence.port;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;

public interface IPersistencePaginationPort<D> {
    Page<D> findAll(int page, int size);
    Page<D> findAll(int page, int size, SpringDataWebProperties.Sort sort);
}
