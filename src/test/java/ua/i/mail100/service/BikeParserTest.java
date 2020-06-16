package ua.i.mail100.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;
import ua.i.mail100.representative.BikeCollection;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BikeParserTest {
    ElectroBike eBike1;
    ElectroBike eBike2;
    ElectroBike eBike3;
    ElectroBike eBike4;
    MechanicBike mBike1;
    MechanicBike mBike2;
    List<String> strings;
    BikeCollection bikeCollection;

    @BeforeEach
    void setUp() {
        bikeCollection = new BikeCollection();
        mBike1 = new MechanicBike(BikeType.FOLDING_BIKE, "BMW", 10500,
                false, "blue", 635, 20, 1);
        mBike2 = new MechanicBike(BikeType.FOLDING_BIKE, "BMW", null,
                null, "", null, null, null);

        eBike1 = new ElectroBike(BikeType.E_BIKE, "Lankeleisi", 28200,
                false, "coral", 2429, 60, 15000);

        eBike2 = new ElectroBike(BikeType.E_BIKE, "Lankeleisi", null,
                null, "", null, null, null);

        eBike3 = new ElectroBike(BikeType.SPEEDELEC, "EcoRide", 8300,
                true, "blue", 1055, 15, 15600);

        eBike4 = new ElectroBike(BikeType.SPEEDELEC, "EcoRide", null,
                null, "", null, null, null);

        strings = Arrays.asList("FOLDING BIKE BMW; 20; 1; 10500; false; blue; 635",
                "FOLDING BIKE BMW; ; ; ; ; ; ",
                "E-BIKE Lankeleisi; 60; 28200; false; 15000; coral; 2429",
                "E-BIKE Lankeleisi; ; ; ; ; ; ",
                "SPEEDELEC EcoRide; 15; 8300; true; 15600; blue; 1055",
                "SPEEDELEC EcoRide; ; ; ; ; ; ");
    }

    @Test
    void parse() {
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);
        bikeCollection.append(eBike1);
        bikeCollection.append(eBike2);
        bikeCollection.append(eBike3);
        bikeCollection.append(eBike4);

        BikeCollection parsed = BikeParser.parse(strings);

        assertEquals(bikeCollection, parsed);
    }
}