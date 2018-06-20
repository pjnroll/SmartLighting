package test;

import exceptions.IntensityOutOfBoundException;
import hardware.Street;
import hardware.StreetLamp;

import java.util.Random;

public class Test {
    private final static int N_STREETLAMPS = 20;
    private final static int INTENSITY_BASE = 20;

    public static void main(String... args) throws IntensityOutOfBoundException {
        //TODO Rembember to handle the exceptions
        Random ran = new Random();

        Street mStreet = new Street("Via Orabona");
        StreetLamp[] streetLamps = new StreetLamp[N_STREETLAMPS];
        for (int i = 0; i < N_STREETLAMPS; i++)
            streetLamps[i] = new StreetLamp(INTENSITY_BASE);

        for (StreetLamp streetLamp : streetLamps) {
            mStreet.addStreetLamp(streetLamp);
        }

        for (int k = 0; k < 3; k++) {
            int time = ran.nextInt(1000);
            for (int i = 0; i < N_STREETLAMPS; i++) {
                mStreet.setCurrentStreetLight(streetLamps[i]);
                streetLamps[i].sensorDetected();
                System.out.println((1000-time) + "km/h: " + mStreet);

                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.flush();
        }
    }
}