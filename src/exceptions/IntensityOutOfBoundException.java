package exceptions;

public class IntensityOutOfBoundException extends Exception {
    public IntensityOutOfBoundException(int a) {
        super(a + " is not a valid value.");
    }
}
