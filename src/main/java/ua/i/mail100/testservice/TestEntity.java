package ua.i.mail100.testservice;

import ua.i.mail100.model.bikes.BikeType;
import ua.i.mail100.model.bikes.ElectroBike;
import ua.i.mail100.model.bikes.MechanicBike;

import java.io.IOException;

public class TestEntity {
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

        System.out.println(electroBike1);
        System.out.println(electroBike2);
        System.out.println(mechanicBike1);
        System.out.println(electroBike1.equals(electroBike2));
        System.out.println(mechanicBike1.equals(mechanicBike2));
    }
}
