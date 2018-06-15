package exceptions;

public class IntensityOutOfBoundException extends Exception {
    public IntensityOutOfBoundException(int b) {
        super(b + " is not a valid value.");
    }

    public IntensityOutOfBoundException(int a, int b) {
        super(a + " " + b + " are not valid values.");
    }
}
