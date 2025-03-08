package sagu.uni.seabattle.domain.map;

import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import sagu.uni.seabattle.domain.ship.ShipPart;

@Getter
@Setter
public class Tile {
    @Nullable
    private ShipPart placedShipPart;

    public Tile() {
        this(null);
    }

    public Tile(@Nullable ShipPart placedShipPart) {
        this.placedShipPart = placedShipPart;
    }

    public boolean isPopulated() {
        return placedShipPart != null;
    }
}
