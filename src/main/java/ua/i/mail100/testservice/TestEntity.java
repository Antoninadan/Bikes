package ua.i.mail100.testservice;

import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;
import ua.i.mail100.util.FileUtil;

import java.io.IOException;

public class TestEntity {
    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FILES_DIR = MAIN_DIR + FILE_SEP + "files";

    public static void main(String[] args) throws IOException {
        ElectroBike electroBike1 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 11, 123, 123);
        ElectroBike electroBike2 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 12, 123, 123);
        MechanicBike mechanicBike1 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 13, 123, 123);
        MechanicBike mechanicBike2 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 452888834,
                false, "rose", 14, 123, 123);

        ElectroBike electroBike3 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 100, 123, 123);
        MechanicBike mechanicBike3 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 101, 123, 123);

        System.out.println(electroBike1);
        System.out.println(electroBike2);
        System.out.println(mechanicBike1);
        System.out.println(electroBike1.equals(electroBike2));
        System.out.println(mechanicBike1.equals(mechanicBike2));

        BikeCollection oldBikes = new BikeCollection();
        oldBikes.append(electroBike1);
        oldBikes.append(electroBike2);
        oldBikes.append(mechanicBike1);
        oldBikes.append(mechanicBike2);

        BikeCollection newBikes = new BikeCollection();
        newBikes.append(electroBike3);
        newBikes.append(mechanicBike3);
        FileUtil.appendTo(newBikes.getListForWrite(), FILES_DIR,"append.txt");


        oldBikes = oldBikes.union(newBikes);
        System.out.println("---------oldBikes");
        oldBikes.print();
        System.out.println("--------newBikes");
        newBikes.clear();
        newBikes.print();

        MechanicBike bike1 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 11, 123, 123);
        System.out.println(bike1);
        System.out.println(bike1.toStringForWrite());

    }
}
