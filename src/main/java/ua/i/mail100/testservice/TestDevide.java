package ua.i.mail100.testservice;

import ua.i.mail100.model.bikes.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestDevide {
    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FILES_DIR = MAIN_DIR + FILE_SEP + "files";

    public static void main(String[] args) throws IOException {
        ElectroBike electroBike1 = new ElectroBike(BikeTypeEnum.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        ElectroBike electroBike2 = new ElectroBike(BikeTypeEnum.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        MechanicBike mechanicBike1 = new MechanicBike(BikeTypeEnum.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 1231, 123, 123);
        MechanicBike mechanicBike2 = new MechanicBike(BikeTypeEnum.FOLDING_BIKE, "brand1", 452888834,
                false, "rose", 1231, 123, 123);
        ElectroBike electroBike3 = new ElectroBike(BikeTypeEnum.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        ElectroBike electroBike4 = new ElectroBike(BikeTypeEnum.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        MechanicBike mechanicBike3 = new MechanicBike(BikeTypeEnum.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 1231, 123, 123);
        MechanicBike mechanicBike4 = new MechanicBike(BikeTypeEnum.FOLDING_BIKE, "brand1", 452888834,
                false, "rose", 1231, 123, 123);

        BikeCollection bikeCollection = new BikeCollection();
        bikeCollection.appent(electroBike1);
        bikeCollection.appent(electroBike2);
        bikeCollection.appent(electroBike3);
        bikeCollection.appent(electroBike4);
        bikeCollection.appent(mechanicBike1);
        bikeCollection.appent(mechanicBike2);
        bikeCollection.appent(mechanicBike3);
        bikeCollection.appent(mechanicBike4);


        bikeCollection.print();
        System.out.println();

        List<BikeCollection> bikeCollectionList = bikeCollection.dividePerParts(3);
        for(BikeCollection each:bikeCollectionList){
            each.print();
            System.out.println();
        }


    }
}
