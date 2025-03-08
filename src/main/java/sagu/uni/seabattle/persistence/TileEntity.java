package sagu.uni.seabattle.persistence;

import core.domain.UUIDModelIdentifier;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.UUID;

@Node
public class TileEntity extends UUIDModelIdentifier {
    public TileEntity(UUID identifier) {
        super(identifier);
    }

    public TileEntity() {
    }
}
