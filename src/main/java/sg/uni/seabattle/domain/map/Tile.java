package sg.uni.seabattle.domain.map;

import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;
import sg.uni.seabattle.domain.ship.ShipPart;

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
}
