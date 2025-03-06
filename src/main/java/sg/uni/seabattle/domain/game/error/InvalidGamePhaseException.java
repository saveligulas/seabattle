package sg.uni.seabattle.domain.game.error;

public class InvalidGamePhaseException extends RuntimeException {
    public InvalidGamePhaseException() {
        super();
    }
    public InvalidGamePhaseException(String message) {
        super(message);
    }
}
