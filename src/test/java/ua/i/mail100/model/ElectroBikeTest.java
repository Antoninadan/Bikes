package ua.i.mail100.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElectroBikeTest {
    ElectroBike bike1;
    ElectroBike bike2;
    ElectroBike bike3;
    ElectroBike bike4;
    ElectroBike bike5;
    ElectroBike bike6;

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
        bike5 = new ElectroBike(BikeType.E_BIKE, "brand1", null,
                null, "", null, null, null);
        bike6 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 11, null, 123);
    }

    @Test
    void equals() {
        assertEquals(bike1, bike2);
        assertNotEquals(bike1, bike3);
        assertNotEquals(bike1, bike4);
        assertEquals(bike4, bike5);
        assertNotEquals(bike6, bike1);
        assertNotEquals(bike1, bike6);


        assertEquals(bike1.hashCode(), bike2.hashCode());
        assertNotEquals(bike1.hashCode(), bike3.hashCode());
        assertNotEquals(bike1.hashCode(), bike4.hashCode());
        assertEquals(bike4.hashCode(), bike5.hashCode());
        assertNotEquals(bike1.hashCode(), bike6.hashCode());
    }

    //TODO hashCode

    @Test
    void similar() {
        assertTrue(bike1.similar(bike2));
        assertTrue(bike2.similar(bike1));

        assertFalse(bike1.similar(bike3));
        assertFalse(bike3.similar(bike1));

        assertTrue(bike1.similar(bike4));
        assertTrue(bike4.similar(bike1));

        assertTrue(bike4.similar(bike5));
        assertTrue(bike5.similar(bike4));

        assertTrue(bike1.similar(bike6));
        assertTrue(bike6.similar(bike1));
    }
}