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
    private int nStreetLamps;
    //private List<StreetLamp> streetLamps;
    private StreetLamp first;
    private StreetLamp last;

    public Street(String name) {
        this.name = name == null ? "" : name;
        this.nStreetLamps = nStreetLamps;
        id = count;
        count++;

        first = null;
        last = null;
        //streetLamps = new LinkedList<>();
    }

    /*public void addStreetLamp(StreetLamp sl) throws StreetContainsLampException, StreetFullException {
        boolean full = isFull();
        boolean contains = streetLamps.contains(sl);
        if (!full && !contains) {
            if (isEmpty()) {
                streetLamps.add(sl);
                streetLamps.get(0).addPrevStreetLamp(null);
            } else {
                streetLamps.get(streetLamps.size()-1).addNextStreetLamp(sl);

            }
        }
        else if (!full)
            throw new StreetContainsLampException(sl.getId());
        else if (!contains)
            throw new StreetFullException();
        else
            System.err.println("My god");
    }*/

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
        return nStreetLamps;
    }

    /*private boolean isFull(){
        return streetLamps.size() >= getnStreetLamps();
    }

    private boolean isEmpty() {
        return streetLamps.size() == 0;
    }*/

    public String toString() {
        String s = "";
        //s += streetLamps;

        return s;
    }

    @Override
    public Iterator<StreetLamp> iterator() {
        Iterable<StreetLamp> it =
    }
}
