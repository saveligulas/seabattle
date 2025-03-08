package core.domain;

import lombok.Setter;
import org.jspecify.annotations.Nullable;

import java.util.UUID;

@Setter
public abstract class LongUUIDInternalExternalIdentifier extends StandardInternalExternalIdentifier<Long, UUID> {
    public LongUUIDInternalExternalIdentifier(IObjectInternalExternalIdentifier<Long, UUID> internalExternalIdentifier) {
        super(internalExternalIdentifier);
    }

    public LongUUIDInternalExternalIdentifier(@Nullable Long aLong, @Nullable UUID uuid) {
        super(aLong, uuid);
    }

    public LongUUIDInternalExternalIdentifier(@Nullable Long aLong, @Nullable UUID uuid, Long version) {
        super(aLong, uuid, version);
    }
}
