package ua.i.mail100.testservice;

import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;
import ua.i.mail100.representative.BikeCollection;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        ElectroBike eBike1;
        ElectroBike eBike2;
        ElectroBike eBike3;
        MechanicBike mBike1;
        MechanicBike mBike2;
        MechanicBike mBike3;
        BikeCollection bikeCollection;
        mBike1 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 123431, 275, 27);
        mBike2 = new MechanicBike(BikeType.FOLDING_BIKE, "brand2", 45243,
                false, "black", 112324, 290, 30);
        mBike3 = new MechanicBike(BikeType.FOLDING_BIKE, "brand3", 2354,
                false, "rose", 34232, 290, 24);
        eBike1 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "red", 456611, 38, 23);
        eBike2 = new ElectroBike(BikeType.SPEEDELEC, "brand2e", 45234,
                true, "rose", 66611, 50, 11);
        eBike3 = new ElectroBike(BikeType.E_BIKE, "brand3", 46534,
                true, "green", 45312, 40, 81);
        bikeCollection = new BikeCollection();
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);

        List<String> list = bikeCollection.getListForWrite();
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));


    }
}
