package exceptions;

import helper.Intensity;

public class IntensityOutOfBoundException extends Exception {
    public IntensityOutOfBoundException(Intensity a) {
        super(a + " is not a valid value.");
    }
}
