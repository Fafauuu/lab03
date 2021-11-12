package exceptions;

public class InvalidActionException extends Throwable {
    public InvalidActionException(String message) {
        super(message);
    }
}
