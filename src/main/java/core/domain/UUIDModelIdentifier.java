package core.domain;

import java.util.UUID;

public abstract class UUIDModelIdentifier extends StandardObjectIdentifier<UUID> {
    public UUIDModelIdentifier() {
        this(UUID.randomUUID());
    }

    public UUIDModelIdentifier(UUID identifier) {
        super(identifier);
    }

    @Override
    public boolean isDomainGenerated() {
        return true;
    }
}
