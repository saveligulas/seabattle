package sg.uni.seabattle.domain.ship;

import sg.uni.seabattle.domain.Direction;

import java.util.List;

public class SetupShip {
    private final int size;
    private final Direction direction;

    public SetupShip(int size, Direction direction) {
        this.size = size;
        this.direction = direction;
    }

    public int getSize() {
        return this.size;
    }

    public Direction getDirection() {
        return this.direction;
    }

    //TODO: fix bug if allowedShipSizes contains multiples
    public static boolean equalsShipSizes(List<SetupShip> setupShips, List<Integer> allowedShipSizes) {
        return setupShips.stream()
               .mapToInt(SetupShip::getSize)
               .allMatch(allowedShipSizes::contains);
    }
}
