package hardware;

import java.util.LinkedList;

public class Street extends Thread {
    private static int count_id = 0;

    public static StreetLamp currentSLNext;
    public static StreetLamp currentSLPrev;

    private int id;
    private String name;
    private LinkedList<StreetLamp> street;

    public Street() {
        this("Street" + count_id);
    }

    public Street(String name) {
        this.name = name;
        this.id = count_id;
        count_id++;

        currentSLNext = null;
        street = new LinkedList<>();
    }

    public void addStreetLamp(StreetLamp sl) {
        if (street.size() == 0) {
            //street.addFirst(sl);
            street.addLast(sl);
        } else {
            StreetLamp temp = street.getLast();
            street.addLast(sl);
            street.getLast().addPrevStreetLamp(temp);
            temp.addNextStreetLamp(sl);
        }
    }

    public void setCurrentStreetLight(StreetLamp currentStreetLight) {
        currentSLNext = currentStreetLight;
        currentSLPrev = currentStreetLight;
    }

    public LinkedList<StreetLamp> getStreet() {
        return street;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name).append(": ");
        for (StreetLamp aStreet : street) {
            if (aStreet.getIntensity() == 100)
                s.append("XX ");
            else
                s.append(aStreet.getIntensity()).append(" ");
        }

        return s.toString();
    }

    @Override
    public void run() {
        if (street != null && street.size() > 0) {

        }
    }
}