package sagu.uni.seabattle.persistence;

import core.domain.IObjectInternalExternalIdentifier;
import core.persistence.provider.neo4j.RelationshipPropertiesBase;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Target;
import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.UUID;

@RelationshipProperties
@Getter
@Setter
public class PlayerMapRelation extends RelationshipPropertiesBase {
    public static final String TYPE = "HAS_PLAYER_MAP";
    private String role;
    @TargetNode
    private GameMapEntity gameMap;

    public PlayerMapRelation(UUID uuid) {
        super(uuid);
    }

    public PlayerMapRelation(IObjectInternalExternalIdentifier<UUID, String> identifier) {
        super(identifier);
    }

    public PlayerMapRelation(UUID uuid, @Nullable String elementId) {
        super(uuid, elementId);
    }

    public PlayerMapRelation(UUID uuid, @Nullable String elementId, Long version) {
        super(uuid, elementId, version);
    }

    @Override
    public boolean isDomainGenerated() {
        return false;
    }

}
