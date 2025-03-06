package sg.uni.seabattle.domain.ship;

import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.Nullable;

@Getter
public class ShipPart {
    @Nullable
    private final Ship ship;
    private final ShipPartType partType;
    private boolean isHit;

    public static final ShipPart MISSED = new ShipPart(null, ShipPartType.MISS, true);

    public ShipPart(ShipPartType partType) {
        this(null, partType, false);
    }

    public ShipPart(@Nullable Ship ship, ShipPartType partType, boolean isHit) {
        this.ship = ship;
        this.partType = partType;
        this.isHit = isHit;
    }

    /**
     *
     * @return true if the ship was sunk following the hit
     */
    public boolean hit() {
        if (ship == null) {
            throw new IllegalStateException("Cannot mark a ship part as hit if the ship is null");
        }
        ship.hit();
        return ship.isSunk();
    }
}
