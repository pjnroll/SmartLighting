package helper;

public enum Intensity {
    INTENSITY_6(100),
    INTENSITY_5(62),
    INTENSITY_4(38),
    INTENSITY_3(24),
    INTENSITY_2(15),
    INTENSITY_1(9),
    INTENSITY_0(0);

    private int intensity;

    public int getIntensity() {
        return intensity;
    }

    Intensity(int intensity) {
        this.intensity = intensity;
    }
}
