package exceptions;

public class NoSuchUserException extends Throwable {
    public NoSuchUserException(String message) {
        super(message);
    }
}
