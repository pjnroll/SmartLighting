package test;

import exceptions.IntensityOutOfBoundException;
import hardware.Street;
import hardware.StreetLamp;
import helper.Intensity;

import java.util.Random;

public class Test {
    private final static int N_STREETLAMPS = 20;
    //private final static int INTENSITY_BASE = 20;

    public static void main(String... args) throws IntensityOutOfBoundException {
        //TODO Rembember to handle the exceptions
        Random ran = new Random();

        Street mStreet = new Street("Via Orabona");
        StreetLamp[] streetLamps = new StreetLamp[N_STREETLAMPS];
        for (int i = 0; i < N_STREETLAMPS; i++)
            streetLamps[i] = new StreetLamp(Intensity.INTENSITY_3);

        for (StreetLamp streetLamp : streetLamps) {
            mStreet.addStreetLamp(streetLamp);
        }

        for (int i = ran.nextInt(N_STREETLAMPS); i < N_STREETLAMPS; i++) {
            mStreet.setCurrentStreetLight(streetLamps[i]);
            streetLamps[i].sensorDetected();
            System.out.println(mStreet);

        }
    }
}