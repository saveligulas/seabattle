package sagu.uni.seabattle.persistence;

import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;
import sg.spring.core.persistence.provider.neo4j.RelationshipPropertiesBase;

import java.util.UUID;

@RelationshipProperties
@Getter
@Setter
public class PlayerMapRelation extends RelationshipPropertiesBase {
    public static final String TYPE = "HAS_PLAYER_MAP";
    private String role;
    @TargetNode
    private GameMapEntity gameMap;

    public PlayerMapRelation() {
    }

    public PlayerMapRelation(UUID uuid) {
        this(uuid, null);
    }

    public PlayerMapRelation(UUID uuid, @Nullable String elementId) {
        super(uuid, elementId);
    }

    public PlayerMapRelation(UUID uuid, @Nullable String elementId, String role, GameMapEntity gameMap) {
        super(uuid, elementId);
        this.role = role;
        this.gameMap = gameMap;
    }
}
