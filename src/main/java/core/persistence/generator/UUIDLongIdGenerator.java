package core.persistence.generator;

import org.jspecify.annotations.NullMarked;
import org.springframework.data.neo4j.core.schema.IdGenerator;

import java.util.UUID;

@NullMarked
public class UUIDLongIdGenerator implements IdGenerator<Long> {

    @Override
    public Long generateId(String primaryLabel, Object entity) {
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}

