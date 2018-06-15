package exceptions;

public class StreetContainsLampException extends Exception {
    public StreetContainsLampException(int id) {
        super("The street already contains street lamp " + id + ".");
    }
}
