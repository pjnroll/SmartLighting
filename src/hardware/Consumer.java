package hardware;

//classe Consumatore **************************
public class Consumer implements Runnable {
    private Strada wareHouse;
    public Consumer(Strada wareHouse) {
        this.wareHouse = wareHouse;
        new Thread(this, "Consumer").start();
    }

    public void run() {
//        for (int i = 0; i < 10;) {
//            i = wareHouse.get();
//        }
    }
}