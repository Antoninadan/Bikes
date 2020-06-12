package ua.i.mail100.testservice;

import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;

import java.io.IOException;

public class TestDevide {
    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FILES_DIR = MAIN_DIR + FILE_SEP + "files";

    public static void main(String[] args) throws IOException {
        ElectroBike electroBike1 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        ElectroBike electroBike2 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        MechanicBike mechanicBike1 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 1231, 123, 123);
        MechanicBike mechanicBike2 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 452888834,
                false, "rose", 1231, 123, 123);
        ElectroBike electroBike3 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        ElectroBike electroBike4 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        MechanicBike mechanicBike3 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 1231, 123, 123);
        MechanicBike mechanicBike4 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 452888834,
                false, "rose", 1231, 123, 123);

        BikeCollection bikeCollection = new BikeCollection();
        bikeCollection.append(electroBike1);
        bikeCollection.append(electroBike2);
        bikeCollection.append(electroBike3);
        bikeCollection.append(electroBike4);
        bikeCollection.append(mechanicBike1);
        bikeCollection.append(mechanicBike2);
        bikeCollection.append(mechanicBike3);
        bikeCollection.append(mechanicBike4);


        bikeCollection.print();
        System.out.println();




    }
}
