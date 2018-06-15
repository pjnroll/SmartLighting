package exceptions;

public class StreetFullException extends Exception {
    public StreetFullException() {
        super("The street is full.");
    }
}
