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
        StreetLamp[] streetLamps = new StreetLamp[10];
        for (int i = 0; i < 10; i++)
            streetLamps[i] = new StreetLamp(20);

        for (int i = 0; i < 10; i++)
            System.out.print(streetLamps[i]);

        for (StreetLamp streetLamp : streetLamps) {
            System.out.println("Entrato");
            System.out.println("Nel try");
            mStreet.addStreetLamp(streetLamp);
        }
        //System.out.println("NUM LAMPIONE =>>>>>>>>>>" + mStreet.getnStreetLamps());

        System.out.println("Strada->" + mStreet.toString());

    }
}
