package hardware;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Sensor implements KeyListener, Runnable {
    private final static int N_STREETLAMPS = 20;
    private int[] outputValues = new int[N_STREETLAMPS];
    private int detectedValue;

    private boolean detected = false;
    private boolean handled = false;

    private Thread myThread;

    private static int[] sensorsValues = new int[N_STREETLAMPS];
    private int sensorDetected;

    public Sensor() {
        /**
         * No sensors detected
         */
        for (int i = 0; i < N_STREETLAMPS; i++) {
            sensorsValues[i] = 0;
        }

        myThread = new Thread(this, "SensorThread");
        myThread.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_E) {
            // esci
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            Random ran = new Random();
            detectedValue = ran.nextInt(81) + 50;
            sensorDetected = 0; // ran.nextInt(N_STREETLAMPS);
            sensorsValues[0] = detectedValue;

            detected = true;

            try {
                myThread.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }


            detected = false;

            /* sensore rilevato
            Random ran = new Random();


            /**
             * Mi interessa una velocità compresa tra 50 km/h e 130 km/h, quindi
             * genero un numero casuale tra 0 e 80 (compresi) e aggiungo 50
             *
            int velocity = ran.nextInt(81) + 50;*/
        }
    }

    @Override
    public void run() {
        while (detected && !handled) {
            //outputValues = generateIntensities(sensorsValues);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
