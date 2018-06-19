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

    private StreetLamp activeStreetLamp = null;

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
    private void sendToNextStreetLamp(int intensity) {
        /*if (getNext() != null) {
            try {
                getNext().setIntensity(intensity);
            } catch (IntensityOutOfBoundException e) {
                e.printStackTrace();
            }
        }*/
        //System.out.println("StreetLamp()");
        //System.out.println(this + ":" + getNext());
        //System.out.println(getIntensity());
        /*if (getNext() != null && getNext().getIntensity() <= intensity && intensity > 20) {
            //System.out.println("if");
            getNext().sendToNextStreetLamp(intensity-20);
        }*/

        /*Street.currentSL = Street.currentSL.getNext();
        System.err.println(Street.currentSL + "; intensity " + intensity);

        if (intensity <= 20 || Street.currentSL.getNext() == null) {
            setIntensity(intensity);
            /*if (activeStreetLamp.getNext() != null)
                sendToNextStreetLamp(intensity - 20);
        } else {
            sendToNextStreetLamp(intensity-20);
        }*/

        /*if (intensity > 20 && Street.currentSL.getNext() != null) {
            Street.currentSL = Street.currentSL.getNext();
            sendToNextStreetLamp(intensity-20);
        }
        setIntensity(intensity);*/

        Street.currentSLNext = Street.currentSLNext.getNext();
        if (Street.currentSLNext.getNext() != null)
                sendToNextStreetLamp(intensity - 20);
            if (intensity > 20) {
                Street.currentSLNext.setIntensity(intensity);
        }
    }

    private void sendToPrevStreetLamp(int intensity) {
        Street.currentSLPrev = Street.currentSLPrev.getPrev();
        if (intensity >= 20) {
            Street.currentSLPrev.setIntensity(intensity);
            if (Street.currentSLPrev.getPrev() != null && intensity > 20)
                sendToPrevStreetLamp(intensity - 20);
        }

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

    public void setIntensity(int intensity) {
        if (intensity >= MIN_INTENSITY && intensity <= MAX_INTENSITY)
            this.intensity = intensity;

            //throw new IntensityOutOfBoundException(intensity);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof StreetLamp && ((StreetLamp) obj).getId() == getId();
    }

    @Override
    public String toString() {
        String s = "";
        s += getId() + ":" + getIntensity() + " ";

        return s;
    }

    public void sensorDetected() {/*
        Street.currentSL = this;
        //System.out.println("sensorDetected()");
        //System.out.println("try");
        Street.currentSL.setIntensity(100);
        //System.out.print("sendToNext");
        if (Street.currentSL.getNext() != null)
            sendToNextStreetLamp(80);*/
        Street.currentSLNext = this;
        Street.currentSLPrev = this;

        Street.currentSLNext.setIntensity(100);
        Street.currentSLPrev.setIntensity(100);

        if (Street.currentSLNext.getNext() != null)
            sendToNextStreetLamp(80);

        if (Street.currentSLPrev.getPrev() != null)
            sendToPrevStreetLamp(80);
    }

}
