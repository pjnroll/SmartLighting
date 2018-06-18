package hardware;

import exceptions.StreetContainsLampException;
import exceptions.StreetFullException;
import exceptions.StreetLampException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Street implements Iterable<StreetLamp> {
    private static int count = 0;

    private int id;
    private String name;
    private StreetLamp first;
    private StreetLamp last;

    public Street(String name) {
        this.name = name == null ? "" : name;
        id = count;
        count++;

        first = null;
        last = null;
    }

    public void addStreetLamp(StreetLamp sl) throws StreetLampException {
        if (sl != null) {
            if (first == null && last == null) {
                // Street just created, there are no street lamps
                first = sl;
                last = sl;

                first.addPrevStreetLamp(null);
                first.addNextStreetLamp(last);
                last.addPrevStreetLamp(first);
                last.addNextStreetLamp(null);

                sl.addPrevStreetLamp(null);
                sl.addNextStreetLamp(null);
            } else if (first != null && last != null) {
                StreetLamp temp = last;
                last = sl;
                last.addPrevStreetLamp(temp);
                last.addNextStreetLamp(null);
            } else {
                throw new StreetLampException();
            }
        }
    }


    public int getnStreetLamps() {
        int n = 0;
        for (Iterator<StreetLamp> it = iterator(); it.hasNext(); it.next())
            n++;

        return n;
    }

    /*private boolean isFull(){
        return streetLamps.size() >= getnStreetLamps();
    }

    private boolean isEmpty() {
        return streetLamps.size() == 0;
    }*/

    public String toString() {
        //s += streetLamps;

        return "";
    }

    @Override
    public Iterator<StreetLamp> iterator() {

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                boolean has = false;
                if (first != null && last != null) {
                    if (first == last) {
                        has = true;
                    }
                }

                return has;
            }

            @Override
            public StreetLamp next() {
                StreetLamp toRet = null;
                if (first != null && last != null) {
                    if (first == last) {
                        toRet = last;
                    } else {
                        toRet = last.getNext();
                    }
                }
                return toRet;
            }
        };
    }
}
