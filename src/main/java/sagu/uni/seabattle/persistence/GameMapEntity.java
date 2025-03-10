package sagu.uni.seabattle.persistence;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import sg.spring.core.persistence.provider.neo4j.Neo4jNodeIdentifier;

import java.util.*;

@Node
@Getter
@Setter
public class GameMapEntity extends Neo4jNodeIdentifier<UUID> {
    @Relationship(type = "HAS_HAPPENED", direction = Relationship.Direction.OUTGOING)
    private Set<TileEntity> tileEntities = new HashSet<>();

    /**
     * Not intended to be called directly, instead this constructor is for ORM purposes.
     */
    public GameMapEntity() {
    }

    public GameMapEntity(UUID identifier) {
        this(identifier, new HashSet<>());
    }

    public GameMapEntity(UUID identifier, Set<TileEntity> tileEntities) {
        super(identifier);
        this.tileEntities = tileEntities;
    }
}
