package ua.i.mail100.testservice;

import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;

import java.io.IOException;

public class TestEqual {
    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FILES_DIR = MAIN_DIR + FILE_SEP + "files";

    public static void main(String[] args) throws IOException {
        ElectroBike electroBike1 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 11, 123, 123);
        ElectroBike electroBike2 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 11, 123, 123);
        ElectroBike electroBike3 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 12, 123, 123);
        ElectroBike electroBike4 = new ElectroBike(BikeType.E_BIKE, "brand1", null,
                null, "", null, null, 123);
        ElectroBike electroBike5 = new ElectroBike(BikeType.E_BIKE, "", null,
                null, "", null, null, 123);
        ElectroBike electroBike6 = new ElectroBike(null, "brand1", 45234,
                true, "rose", 11, 123, 123);
        System.out.println("1 and 2 = " + electroBike1.equals(electroBike2));
        System.out.println("1 and 3 = " + electroBike1.equals(electroBike3));
        System.out.println("1 and 4 = " + electroBike1.equals(electroBike4));
        System.out.println("1 and 5 = " + electroBike1.equals(electroBike5));
        System.out.println("1 and 6 = " + electroBike1.equals(electroBike6));



        MechanicBike bike1 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 11, 123, 123);
        MechanicBike bike2 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 11, 123, 123);
        MechanicBike bike3 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 12, 123, 123);
        MechanicBike bike4 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", null,
                null, "", null, null, null);
        MechanicBike bike5 = new MechanicBike(BikeType.FOLDING_BIKE, "", null,
                null, "", null, null, null);
        MechanicBike bike6 = new MechanicBike(null, "brand1", null,
                null, "", null, null, null);
        System.out.println(bike6);

        System.out.println();
        System.out.println("1 and 2 = " + bike1.equals(bike2));
        System.out.println("1 and 3 = " + bike1.equals(bike3));
        System.out.println("1 and 4 = " + bike1.equals(bike4));
        System.out.println("1 and 5 = " + bike1.equals(bike5));
        System.out.println("1 and 6 = " + bike1.equals(bike6));

        System.out.println(bike1.hashCode());
        System.out.println(bike4.hashCode());



        System.out.println();
    }
}
