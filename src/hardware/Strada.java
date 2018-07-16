package hardware;

import java.util.ArrayList;

public class Strada {
    private int numberOfProducts;
    private int idProduct;
    private String name;
    private boolean empty = true; // magazzino vuoto
    private ArrayList<Lampione> lampioni;

    public Strada(String name) {
        this.name = name;
        lampioni = new ArrayList<>();
    }

    public void addLampione(Lampione l) {
        if (l != null)
            lampioni.add(l);
    }

    public void start() {
        /*for (Lampione l : lampioni)
            l.startLampione();*/
    }

    /*public /*synchronized* void put(int idProduct) {
        if (!empty) {
            try {
                wait();
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
        this.idProduct = idProduct;
        numberOfProducts++;
        printSituation("Produced " + idProduct);
        empty = false;
        notify(); // svegliati Consumer
    }*/

    /*public synchronized int get() {
        if (empty) {
            try {
                wait(); // bloccati Consumer
            }
            catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
        numberOfProducts--;
        printSituation("Consumed " + idProduct);
        empty = true; // il magazzino ora è vuoto
        notify(); // svegliati Lampione
        return idProduct;
    }*/
/*
    private /*synchronized* void printSituation(String msg) {
        System.out.println(msg +"\n" + numberOfProducts +
        " Product in Strada");
    }*/

    public void show() {
        System.out.println(lampioni);
    }
}