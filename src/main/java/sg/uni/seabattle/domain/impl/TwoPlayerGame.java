package sg.uni.seabattle.domain.impl;

import sg.uni.seabattle.domain.game.*;
import sg.uni.seabattle.domain.game.error.InvalidGamePhaseException;
import sg.uni.seabattle.domain.game.error.InvalidPlayerActionException;
import sg.uni.seabattle.domain.map.IGameMap;
import sg.uni.seabattle.domain.map.RectangleGameMap;
import sg.uni.seabattle.domain.map.Tile;
import sg.uni.seabattle.domain.map.Vector2Int;
import sg.uni.seabattle.domain.map.error.VectorOutOfBoundsException;
import sg.uni.seabattle.domain.player.Player;
import sg.uni.seabattle.domain.ship.SetupShip;
import sg.uni.seabattle.domain.ship.ShipPart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TwoPlayerGame implements IGame {
    private final Player playerRed;
    private final Player playerBlue;
    private final List<Integer> setupShipSizes;
    private final Vector2Int size;

    //TODO: implement this
    private final List<PlayAndResult> playHistory;

    private GamePhase phase;

    public TwoPlayerGame(Player playerRed, Player playerBlue, List<Integer> setupShipSizes, Vector2Int size) {
        if (!sizeWithShipsIsValid(setupShipSizes, size)) {
            throw new IllegalArgumentException("Ships don't fit on the map");
        }

        this.playerRed = playerRed;
        this.playerBlue = playerBlue;
        this.setupShipSizes = setupShipSizes;
        this.size = size;

        this.playHistory = new ArrayList<>();

        this.phase = GamePhase.SETUP;
    }

    private boolean sizeWithShipsIsValid(List<Integer> setupShipSizes, Vector2Int size) {
        return size.getMultiplicity() < setupShipSizes.stream().mapToInt(Integer::intValue).sum();
    }

    private IGameMap getOpposingPlayerMap(String playerId) {
        IGameMap map = playerId.equals(playerRed.getId())? playerBlue.getMap() : playerRed.getMap();

        if (map == null) {
            throw new IllegalStateException("Opposing player's map is null");
        }

        return map;
    }

    @Override
    public Vector2Int getSize() {
        return this.size;
    }

    @Override
    public GamePhase getPhase() {
        return phase;
    }

    @Override
    public List<Player> getPlayers() {
        return List.of(playerRed, playerBlue);
    }

    @Override
    public List<Integer> getPlaceableShips() {
        return Collections.unmodifiableList(setupShipSizes);
    }

    @Override
    public Player getCurrentTurnPlayer() {
        if (phase == GamePhase.SETUP) {
            throw new InvalidGamePhaseException();
        }

        if (playHistory.isEmpty()) {
            return playerRed;
        }

        //TODO: once playhistory is implemented, check for latest action result so that if a hit occurred then the turn for the last player continues
        return playHistory.getLast().getPlayAction().getPlayerId().equals(playerRed.getId()) ? playerBlue : playerRed;
    }

    @Override
    public void setup(Player player, Map<SetupShip, Vector2Int> shipVectorMap) {
        checkPlayerAccess(player);

        if (phase != GamePhase.SETUP) {
            throw new InvalidGamePhaseException("Ships are already set for both players");
        }

        player.setMap(new RectangleGameMap(size));

        for (Map.Entry<SetupShip, Vector2Int> entry : shipVectorMap.entrySet()) {
            try {
                player.getMap().placeShipWithNose(entry.getKey(), entry.getValue());
            } catch (VectorOutOfBoundsException e) {
                throw new InvalidPlayerActionException("Invalid Ship placement: " + entry.getValue());
            }
        }

        if (playerRed.getMap() != null && playerBlue.getMap() != null) {
            phase = GamePhase.PLAY;
        }
    }

    @Override
    public ActionResultType performAction(PlayAction action) {
        if (phase != GamePhase.PLAY) {
            throw new InvalidGamePhaseException("Player cannot perform action in this phase");
        }

        if (!getCurrentTurnPlayer().getId().equals(action.getPlayerId())) {
            throw new InvalidPlayerActionException("Not this player's turn");
        }

        Vector2Int vector = action.getCoordinates();
        IGameMap map = getOpposingPlayerMap(action.getPlayerId());

        try {
            Tile targetedTile = map.getTile(vector);

            if (targetedTile.getPlacedShipPart() == null) {
                targetedTile.setPlacedShipPart(ShipPart.MISSED);
            } else {
                ShipPart targetedShipPart = targetedTile.getPlacedShipPart();
                if (targetedTile.getPlacedShipPart().isHit()) {
                    throw new InvalidPlayerActionException("Tile already hit");
                }
                if (targetedShipPart.hit()) {
                    return ActionResultType.SUNK;
                }
            }
        } catch (VectorOutOfBoundsException e) {
            throw new InvalidPlayerActionException("Invalid target coordinates: " + vector);
        }
    }

    @Override
    public List<PlayAndResult> getPlayAndResultHistory() {
        return List.of();
    }

    private void checkPlayerAccess(Player player) {
        if (player == null || (!player.equals(playerRed) && !player.equals(playerBlue))) {
            throw new InvalidPlayerActionException("Player does not participate in this game");
        }
    }
}
