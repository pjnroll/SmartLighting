package test;

import exceptions.IntensityOutOfBoundException;
import hardware.Sensor;
import hardware.Street;
import hardware.StreetLamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Test implements Runnable {
    private final static int N_STREETLAMPS = 20;
    private final static int INTENSITY_BASE = 20;

    private Street mStreet;
    private StreetLamp[] streetLamps;

    private int[] startingValues;
    private int[] outputValues;

    private Thread prOS;

    public Test() {
        mStreet = new Street("Via Orabona");
        streetLamps = new StreetLamp[N_STREETLAMPS];
        startingValues = new int[N_STREETLAMPS];
        outputValues = new int[N_STREETLAMPS];

        System.out.println("CI sentro");
        for (int i = 0; i < N_STREETLAMPS; i++) {
            try {
                streetLamps[i] = new StreetLamp(INTENSITY_BASE);
            } catch (IntensityOutOfBoundException e) {
                e.printStackTrace();
            }
        }

        for (StreetLamp streetLamp : streetLamps) {
            mStreet.addStreetLamp(streetLamp);
        }

        for (int i = 0; i < startingValues.length; i++) {
            startingValues[i] = 20;
        }

        prOS = Thread.currentThread();

        new Sensor();   // Start every sensor
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        //TODO Rembember to handle the exceptions

        new Test();
        /*
         * No sensors detected
         *
        for (int i = 0; i < N_STREETLAMPS; i++) {
            sensorsDetected[i] = 0;
        }*/

        /*for (int k = 0; k < 3; k++) {
            int time = ran.nextInt(1000);
            for (int i = 0; i < N_STREETLAMPS; i++) {
                mStreet.setCurrentStreetLight(streetLamps[i]);
                streetLamps[i].sensorDetected();
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(mStreet);
            }
            System.out.flush();
        }*/
    }

    public int[] generateIntensities(int detectedValue, int[] sensorsValues) {
        int[] toRet = new int[sensorsValues.length];

        for (int i = detectedValue; i < sensorsValues.length; i++) {
            toRet[i] = 100;
            toRet[i+1] = 100;
            toRet[1+2] = 80;
            toRet[1+3] = 60;
            toRet[1+4] = 40;
        }

        return toRet;
    }

    @Override
    public void run() {

    }

    public class Sensor implements KeyListener, Runnable {
        private final static int N_STREETLAMPS = 20;
        private int detectedValue;

        private boolean detected;
        private boolean handled;

        private Thread myThread;

        private int[] sensorsValues = new int[N_STREETLAMPS];
        private int sensorDetected;

        private int time;

        Sensor() {
            detected = false;
            handled = false;

            time = 0;

            /**
             * No sensors detected
             */
            for (int i = 0; i < N_STREETLAMPS; i++) {
                sensorsValues[i] = 0;
            }

            myThread = new Thread(this, "SensorThread");
            //myThread.start();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_E) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_S) {
                Random ran = new Random();

                sensorDetected = 0; // ran.nextInt(N_STREETLAMPS);
                detectedValue = ran.nextInt(81) + 50;
                sensorsValues[sensorDetected] = detectedValue;

                // calcola il tempo
                time = (35*36)/(detectedValue * 10) * 100;
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
                outputValues = generateIntensities(detectedValue, sensorsValues);

                for (int i = 0; i < streetLamps.length; i++) {
                    streetLamps[i].setIntensity(outputValues[i]);
                }

                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handled = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

}