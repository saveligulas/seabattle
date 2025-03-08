package sagu.uni.seabattle.domain.ship;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Ship {
    private int hits;
    private final int size;
    private final UUID identifier;

    public Ship(int size, UUID identifier) {
        this.size = size;
        this.identifier = identifier;
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits == size;
    }
}
