package test;

import exceptions.IntensityOutOfBoundException;
import hardware.Street;
import hardware.StreetLamp;

public class Test {
    public static void main(String... args) throws IntensityOutOfBoundException {
        //TODO Rembember to handle the exceptions
        Street mStreet = new Street("Via Orabona");
        StreetLamp[] streetLamps = new StreetLamp[15];
        for (int i = 0; i < 15; i++)
            streetLamps[i] = new StreetLamp(20);

        for (StreetLamp streetLamp : streetLamps) {
            mStreet.addStreetLamp(streetLamp);
        }
        System.out.println("PRIMO");
        for (int j = 0; j < 15; j++)
            System.out.println(streetLamps[j]);

        System.out.println("SECON");
        System.out.println(mStreet);
        System.out.println("TERZO");
        for (int i = 0; i < 15; i++) {
            mStreet.setCurrentStreetLight(streetLamps[i]);
            streetLamps[i].sensorDetected();
            System.out.println(mStreet);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}