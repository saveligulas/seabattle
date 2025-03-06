package sg.uni.seabattle.domain.game.error;

public class InvalidPlayerActionException extends RuntimeException {
    public InvalidPlayerActionException() {
        super();
    }
    public InvalidPlayerActionException(String message) {
        super(message);
    }
}
