package helper;

import java.util.Comparator;

public enum Intensity {
    INTENSITY_0(0),
    INTENSITY_1(9),
    INTENSITY_2(15),
    INTENSITY_3(24),
    INTENSITY_4(38),
    INTENSITY_5(62),
    INTENSITY_6(100);

    private int intensity;

    public String toString() {
        return String.valueOf(intensity);
    }

    Intensity(int intensity) {
        this.intensity = intensity;
    }
}
