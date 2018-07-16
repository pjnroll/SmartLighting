package hardware;

//classe Produttore ***************************
public class Lampione implements Runnable {
    private String stato;
    private Strada street;
    private boolean detected = false;

    private static int count = 0;
    private int id;

    public Lampione() {
        this(new Strada("Temporary Street"));
    }
    public Lampione(Strada street) {
        stato = "O";
        id = count;
        count++;
        this.street = street;

        //TODO capire dove piazzare sto giovanotto
        //new Thread(this, "Lampione").start();

        Thread t = new Thread(this, "Lampione");
        t.setPriority(10-id);
        t.start();
    }

    /*public synchronized void startLampione() {
        Thread t = new Thread(this, "Lampione");
        t.setPriority(10-id);
        t.start();
    }*/

    public void run() {
        /*try {
            Thread.sleep(1000);
            stato = "X";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        synchronized (street) {

        }

        System.out.println(id);
        street.show();
    }

    public String toString() {
        return stato;
    }
}