package hardware;

import java.util.LinkedList;

public class Street extends Thread {
    private static int count_id = 0;

    public static StreetLamp currentSLNext;
    public static StreetLamp currentSLPrev;

    private int id;
    private String name;
    private LinkedList<StreetLamp> streetLamps;

    public Street() {
        this("Street" + count_id);
    }

    public Street(String name) {
        this.name = name;
        this.id = count_id;
        count_id++;

        currentSLNext = null;
        streetLamps = new LinkedList<>();
    }

    public void addStreetLamp(StreetLamp sl) {
        if (streetLamps.size() == 0) {
            //streetLamps.addFirst(sl);
            streetLamps.addLast(sl);
        } else {
            StreetLamp temp = streetLamps.getLast();
            streetLamps.addLast(sl);
            streetLamps.getLast().addPrevStreetLamp(temp);
            temp.addNextStreetLamp(sl);
        }
    }

    public void setCurrentStreetLight(StreetLamp currentStreetLight) {
        currentSLNext = currentStreetLight;
        currentSLPrev = currentStreetLight;
    }

    public LinkedList<StreetLamp> getStreetLamps() {
        return streetLamps;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(name).append(": ");
        for (StreetLamp aStreet : streetLamps) {
            if (aStreet.getIntensity() == 100)
                s.append("XX ");
            else
                s.append(aStreet.getIntensity()).append(" ");
        }

        return s.toString();
    }

    @Override
    public void run() {
        if (streetLamps != null && streetLamps.size() > 0) {

        }
    }
}