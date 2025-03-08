package core.persistence.provider.neo4j;

import core.domain.IObjectInternalExternalIdentifier;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.Version;
import org.springframework.data.neo4j.core.schema.RelationshipId;

import java.util.UUID;

@Setter
public abstract class RelationshipPropertiesBase implements IObjectInternalExternalIdentifier<UUID, String> {
    private UUID uuid;
    @Nullable
    @RelationshipId
    private String elementId;
    @Version
    private Long version;

    public RelationshipPropertiesBase() {
    }

    public RelationshipPropertiesBase(UUID uuid) {
        this(uuid, null, 0L);
    }

    public RelationshipPropertiesBase(IObjectInternalExternalIdentifier<UUID, String> identifier) {
        this(identifier.getIdentifier(), identifier.getExternalIdentifier(), 0L);
    }

    public RelationshipPropertiesBase(UUID uuid, @Nullable String elementId) {
        this(uuid, elementId, 0L);
    }

    public RelationshipPropertiesBase(UUID uuid, @Nullable String elementId, Long version) {
        this.uuid = uuid;
        this.elementId = elementId;
        this.version = version;
    }

    @Override
    public Long getVersion() {
        return -1L;
    }

    @Override
    public @Nullable String getExternalIdentifier() {
        return elementId;
    }

    @Override
    public @Nullable UUID getIdentifier() {
        return uuid;
    }
}
