package sg.uni.seabattle.domain.map;

import sg.uni.seabattle.domain.ship.SetupShip;
import sg.uni.seabattle.domain.ship.ShipPart;
import sg.uni.seabattle.domain.ship.ShipPartType;

import java.util.Objects;

//TODO: implement this
public class RectangleGameMap implements IGameMap {

    public RectangleGameMap(Vector2Int size) {
//        for (int i = 0; i < size; i++) {
//            ShipPartType type = null;
//            if (i == 0) {
//                type = ShipPartType.NOSE;
//            }
//
//            if (i == size - 1) {
//                type = ShipPartType.TRUNK;
//            }
//
//            parts[i] = new ShipPart(Objects.requireNonNullElse(type, ShipPartType.BODY));
//        }
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

    }
}
