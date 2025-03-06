package sg.uni.seabattle.domain.game;

import sg.uni.seabattle.domain.map.Vector2Int;

public class PlayAction {
    private final Vector2Int coordinates;
    private final String playerId;

    public PlayAction(Vector2Int coordinates, String playerId) {
        this.coordinates = coordinates;
        this.playerId = playerId;
    }

    public Vector2Int getCoordinates() {
        return coordinates;
    }

    public String getPlayerId() {
        return playerId;
    }
}
