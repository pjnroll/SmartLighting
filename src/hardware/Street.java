package hardware;

import java.util.Iterator;
import java.util.LinkedList;

public class Street {
    private static int count_id = 0;
    private int cont;

    private StreetLamp currentSL;

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

        cont = 0;

        currentSL = null;
        street = new LinkedList<>();
    }

    public void addStreetLamp(StreetLamp sl) {
        street.add(sl);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        System.out.println("NEL TO STRING");
        for (Iterator<StreetLamp> it = street.iterator(); it.hasNext();) {
            System.out.println("CISONO");
            s.append(it.next());
        }

        return s.toString();
    }
}