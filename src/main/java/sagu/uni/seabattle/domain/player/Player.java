package sagu.uni.seabattle.domain.player;

import core.domain.UUIDModelIdentifier;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import sagu.uni.seabattle.domain.map.IGameMap;

@Getter
@Setter
public class Player extends UUIDModelIdentifier {
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
