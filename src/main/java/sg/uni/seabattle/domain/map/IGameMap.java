package sg.uni.seabattle.domain.map;

import sg.uni.seabattle.domain.map.error.VectorOutOfBoundsException;
import sg.uni.seabattle.domain.ship.SetupShip;

public interface IGameMap {
    int getSize();

    /**
     * Returns the tiles going from top to bottom and left to right.
     * @return Tile array containing all tiles of the corresponding map
     */
    Tile[] getTiles();

    Tile[] getTileRow(int row) throws VectorOutOfBoundsException;

    Tile[] getTileColumn(int col) throws VectorOutOfBoundsException;

    Tile getTile(Vector2Int vector) throws VectorOutOfBoundsException;

    void setTile(Tile tile, Vector2Int vector) throws VectorOutOfBoundsException;

    void placeShipWithNose(SetupShip setupShip, Vector2Int vector) throws VectorOutOfBoundsException;
}
