package hardware;

import exceptions.IntensityOutOfBoundException;

public class StreetLamp {
    private final static int MIN_INTENSITY = 0;
    private final static int MAX_INTENSITY = 100;

    private static int count = 0;
    private int id;
    private int intensity;

    private StreetLamp next;
    private StreetLamp prev;

    //TODO transorm it into a builder factory o come cazzo si chiama
    public StreetLamp(int intensity) throws IntensityOutOfBoundException {
        if (intensity < MIN_INTENSITY || intensity > MAX_INTENSITY) {
            throw new IntensityOutOfBoundException(intensity);
        } else {
            this.intensity = intensity;
            id = count;
            count++;
        }
    }

    public int getIntensity() {
        return intensity;
    }

    /**
     * Ricevo vari parametri in ingresso, con i quali calcolare l'intensità
     * da applicare al lampione successivo. Per ora ho direttamente l'intensità
     */
    public void sendToNextStreetLamp(int intensity) {

    }

    public void addNextStreetLamp(StreetLamp n) {
        this.next = n;
    }

    public StreetLamp getNext() {
        return next;
    }

    public StreetLamp getPrev() {
        return prev;
    }

    public void addPrevStreetLamp(StreetLamp p) {
        this.prev = p;
    }

    public void setIntensity(int intensity) throws IntensityOutOfBoundException {
        if (intensity >= MIN_INTENSITY && intensity <= MAX_INTENSITY)
            this.intensity = intensity;
        else if (intensity < MIN_INTENSITY)
            throw new IntensityOutOfBoundException(intensity);
        else
            throw new IntensityOutOfBoundException(intensity);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String s = "";
        s += getId() + ":" + getIntensity();

        return s;
    }
}
