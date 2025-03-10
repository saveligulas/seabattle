package sagu.uni.seabattle.persistence;

import jakarta.persistence.PersistenceException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import sagu.uni.seabattle.domain.map.Vector2Int;
import sg.spring.core.persistence.provider.neo4j.Neo4jNodeIdentifier;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Node("TwoPlayerGame")
@Getter
@Setter
public class TwoPlayerGameEntity extends Neo4jNodeIdentifier<UUID> {
    @Relationship(type = PlayerMapRelation.TYPE, direction = Relationship.Direction.INCOMING)
    private Set<PlayerMapRelation> players;
    private List<Integer> setupShipSizes;
    private Vector2Int size;

    public PlayerMapRelation getPlayerRed() {
        return getPlayerByRole("RED");
    }

    public PlayerMapRelation getPlayerBlue() {
        return getPlayerByRole("BLUE");
    }

    private PlayerMapRelation getPlayerByRole(String role) {
        return players.stream()
                .filter(p -> p.getRole().equals(role))
                .findFirst()
                .orElseThrow(() -> new PersistenceException("No red player found"));
    }

    public TwoPlayerGameEntity() {
        super();
    }

    public TwoPlayerGameEntity(UUID uuid) {
        super(uuid);
    }
}
