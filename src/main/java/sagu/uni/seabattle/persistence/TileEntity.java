package sagu.uni.seabattle.persistence;

import org.springframework.data.neo4j.core.schema.Node;
import sg.spring.core.persistence.provider.neo4j.Neo4jNodeIdentifier;

import java.util.UUID;

@Node
public class TileEntity extends Neo4jNodeIdentifier<UUID> {

    public TileEntity() {
    }

    public TileEntity(UUID identifier) {
        super(identifier);
    }
}
