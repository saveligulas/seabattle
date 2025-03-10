package sagu.uni.seabattle.domain.player;

import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import sagu.uni.seabattle.domain.map.IGameMap;
import sg.spring.core.domain.UUIDDomainIdentifier;

@Getter
@Setter
public class Player extends UUIDDomainIdentifier {
    private final String id;
    @Nullable
    private IGameMap map;

    public Player(String id) {
        this(id, null);
    }

    public Player(String id, @Nullable IGameMap map) {
        this.id = id;
        this.map = map;
    }
}
