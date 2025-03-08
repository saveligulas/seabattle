package sagu.uni.seabattle;

import sagu.uni.seabattle.domain.Direction;
import sagu.uni.seabattle.domain.impl.TwoPlayerGame;
import sagu.uni.seabattle.domain.map.RectangleGameMap;
import sagu.uni.seabattle.domain.map.Vector2Int;
import sagu.uni.seabattle.domain.ship.SetupShip;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RectangleGameMap rectangleGameMap = new RectangleGameMap(new Vector2Int(5, 5));
        SetupShip setupShip = new SetupShip(3, Direction.EAST);
        Vector2Int position = new Vector2Int(0, 3);
        SetupShip setupShip2 = new SetupShip(5, Direction.SOUTH);
        Vector2Int position2 = new Vector2Int(3, 4);
        rectangleGameMap.placeShipWithNose(setupShip, position);
        rectangleGameMap.placeShipWithNose(setupShip2, position2);
        System.out.println(rectangleGameMap);
        System.out.println(new TwoPlayerGame(null, null, new ArrayList<>(), new Vector2Int(7, 7)).getEmptyMapRepresentation());
    }
}
