package sagu.uni.seabattle.persistence;

import core.domain.UUIDModelIdentifier;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Node
@Getter
@Setter
public class GameMapEntity extends UUIDModelIdentifier {
    @Relationship(type = "HAS_HAPPENED", direction = Direction.)
    private Set<TileEntity> tileEntities = new ArrayList<>();

    public GameMapEntity(List<TileEntity> tileEntities) {
        this.tileEntities = tileEntities;
    }

    public GameMapEntity(UUID identifier, List<TileEntity> tileEntities) {
        super(identifier);
        this.tileEntities = tileEntities;
    }
}
