package sagu.uni.seabattle.domain.map;

import sagu.uni.seabattle.domain.ship.SetupShip;
import sagu.uni.seabattle.domain.ship.Ship;
import sagu.uni.seabattle.domain.ship.ShipPart;
import sagu.uni.seabattle.domain.ship.ShipPartType;

import java.util.UUID;

//TODO: implement this
public class RectangleGameMap implements IGameMap {
    private final Tile[][] tiles;


    public RectangleGameMap(Vector2Int size) {
        tiles = new Tile[size.getX()][size.getY()];
        for (int x = 0; x < size.getX(); x++) {
            for (int y = 0; y < size.getY(); y++) {
                tiles[x][y] = new Tile();
            }
        }
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Tile[] getTiles() {
        return new Tile[0];
    }

    @Override
    public Tile[] getTileRow(int row) {
        return new Tile[0];
    }

    @Override
    public Tile[] getTileColumn(int col) {
        return new Tile[0];
    }

    @Override
    public Tile getTile(Vector2Int vector) {
        return null;
    }

    @Override
    public void setTile(Tile tile, Vector2Int vector) {

    }

    @Override
    public void placeShipWithNose(SetupShip setupShip, Vector2Int vector) {
        if (!vector.fitsIntoInclusivePositive(Vector2Int.fromArray(tiles))) {
            throw new IllegalArgumentException("The given vector does not fit inclusive positive coordinates");
        }

        if (!shipFits(setupShip, vector)) {
            throw new IllegalArgumentException("The given ship does not fit inclusive positive coordinates");
        }

        Ship ship = new Ship(setupShip.getSize(), UUID.randomUUID());
        Vector2Int directionVector = Vector2Int.fromDirection(setupShip.getDirection(), setupShip.getSize());

        int deltaX = Integer.compare(directionVector.getX(), 0);
        int deltaY = Integer.compare(directionVector.getY(), 0);

        for (int i = 0; i < setupShip.getSize(); i++) {
            int x = vector.getX() + (i * deltaX);
            int y = vector.getY() + (i * deltaY);

            ShipPartType partType = ShipPartType.BODY;
            if (i == 0) partType = ShipPartType.NOSE;
            if (i == setupShip.getSize() - 1) partType = ShipPartType.TRUNK;

            tiles[x][y].setPlacedShipPart(new ShipPart(ship, partType));
        }
    }

    private boolean shipFits(SetupShip setupShip, Vector2Int vector) {
        Vector2Int shipTrunkVector = Vector2Int.add(vector, Vector2Int.fromDirection(setupShip.getDirection(), setupShip.getSize()));

        return shipTrunkVector.fitsIntoInclusivePositive(Vector2Int.fromArray(tiles));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int width = tiles.length;
        int height = tiles[0].length;

        // Top border with column numbers
        sb.append("   ");
        for (int x = 0; x < width; x++) {
            sb.append(x % 10).append(" "); // Column numbers (mod 10 for readability)
        }
        sb.append("\n  ").append("━".repeat(2 * width)).append("\n");

        // Render the grid from top to bottom (y increasing upwards)
        for (int y = height - 1; y >= 0; y--) {
            sb.append(String.format("%2d┃", y)); // Row number with left padding

            for (int x = 0; x < width; x++) {
                ShipPart part = tiles[x][y].getPlacedShipPart();

                if (part == null) {
                    sb.append("· "); // Empty water
                } else {
                    switch (part.getPartType()) {
                        case NOSE -> sb.append("N ");
                        case BODY -> sb.append("B ");
                        case TRUNK -> sb.append("T ");
                        case MISS -> sb.append("X "); // Missed shot
                        default -> sb.append("? ");
                    }
                }
            }
            sb.append("┃\n");
        }

        // Bottom border
        sb.append("  ").append("━".repeat(2 * width)).append("\n");

        return sb.toString();
    }


}
