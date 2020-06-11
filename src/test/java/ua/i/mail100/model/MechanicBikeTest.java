package ua.i.mail100.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MechanicBikeTest {
    MechanicBike bike1;
    MechanicBike bike2;
    MechanicBike bike3;
    MechanicBike bike4;
    MechanicBike bike5;
    MechanicBike bike6;

    @BeforeEach
    void setUp() {
        bike1 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 11, 123, 123);
        bike2 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 11, 123, 123);
        bike3 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 12, 123, 123);
        bike4 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", null,
                null, "", null, null, null);
        bike5 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", null,
                null, "", null, null, null);
        bike6 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 11, null, 123);
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