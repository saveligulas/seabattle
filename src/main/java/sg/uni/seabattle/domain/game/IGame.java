package sg.uni.seabattle.domain.game;

import sg.uni.seabattle.domain.map.Vector2Int;
import sg.uni.seabattle.domain.player.Player;
import sg.uni.seabattle.domain.ship.SetupShip;

import java.util.List;
import java.util.Map;

public interface IGame {
    Vector2Int getSize();
    GamePhase getPhase();
    List<Player> getPlayers();
    List<Integer> getPlaceableShips();
    Player getCurrentTurnPlayer();
    void setup(Player player, Map<SetupShip, Vector2Int> shipVectorMap);
    ActionResultType performAction(PlayAction action);
    List<PlayAndResult> getPlayAndResultHistory();
}
