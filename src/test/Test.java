package test;

import exceptions.IntensityOutOfBoundException;
import exceptions.StreetContainsLampException;
import exceptions.StreetFullException;
import hardware.Street;
import hardware.StreetLamp;

public class Test {
    public static void main(String... args) throws IntensityOutOfBoundException, StreetFullException, StreetContainsLampException {
        //TODO Rembember to handle the exceptions
        StreetLamp[] streetLamps = new StreetLamp[10];
        for (int i = 0; i < 10; i++)
            streetLamps[i] = new StreetLamp(20);

        Street street = new Street("Main Street");
        for (StreetLamp streetLamp : streetLamps) {
            street.addStreetLamp(streetLamp);
        }

        System.out.println(street);

    }
}
