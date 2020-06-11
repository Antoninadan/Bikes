package ua.i.mail100.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ElectroBikeTest {
    ElectroBike bike1;
    ElectroBike bike2;
    ElectroBike bike3;
    ElectroBike bike4;
    ElectroBike bike5;

    @BeforeEach
    void setUp() {
         bike1 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 11, 123, 123);
         bike2 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 11, 123, 123);
         bike3 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 12, 123, 123);
         bike4 = new ElectroBike(BikeType.E_BIKE, "brand1", null,
                null, "", null, null, null);
         bike5 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                 true, "rose", 12, 123, 123);
    }

    @Test
    void equals() {


        assertEquals(bike1, bike2);
        assertNotEquals(bike1, bike3);
        assertEquals(bike1, bike4);
        assertNotEquals(bike1, bike5);
    }


}