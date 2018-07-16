package hardware;

import java.util.Collection;
import java.util.LinkedList;

public class StreetList {
    private static int count_id = 0;

    private int id;
    private String name;
    private LinkedList<StreetLamp> street;

    public StreetList() {
        this("Street" + count_id);
    }

    public StreetList(String name) {
        this.name = name;
        this.id = count_id;
        count_id++;

        street = new LinkedList<>();
    }


}
