package test;

import exceptions.IntensityOutOfBoundException;
import exceptions.StreetContainsLampException;
import exceptions.StreetFullException;
import exceptions.StreetLampException;
import hardware.Street;
import hardware.StreetLamp;

public class Test {
    public static void main(String... args) throws IntensityOutOfBoundException, StreetFullException, StreetContainsLampException {
        //TODO Rembember to handle the exceptions
        Street mStreet = new Street("Via Orabona");
        StreetLamp[] streetLamps = new StreetLamp[15];
        for (int i = 0; i < 15; i++)
            streetLamps[i] = new StreetLamp(20);

        for (StreetLamp streetLamp : streetLamps) {
            mStreet.addStreetLamp(streetLamp);
        }
        System.out.println(mStreet.toString());

        for (int i = 0; i < 15; i++) {
            mStreet.setCurrentStreetLight(streetLamps[i]);
            streetLamps[i].sensorDetected();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(mStreet);
        }
    }
}
