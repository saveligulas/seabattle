package sg.uni.seabattle.domain.ship;

import sg.uni.seabattle.domain.Direction;

public class Ship extends SetupShip {
    private int hits;

    public Ship(SetupShip setupShip) {
        this(setupShip.getSize(), setupShip.getDirection());
    }

    public Ship(int size, Direction direction) {
        super(size, direction);
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits == getSize();
    }
}
