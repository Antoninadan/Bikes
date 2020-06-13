package ua.i.mail100.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.representative.BikeCollection;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BikeTest {
    @Test
    void hashCodeTest() {
        Bike bikeOne = new Bike() {
            @Override
            public String toStringForWrite() {
                return null;
            }

            @Override
            public boolean similar(Bike bike) {
                return false;
            }
        };
        bikeOne.type = BikeType.E_BIKE;
        bikeOne.brand = "brand1";
        bikeOne.weightInGrams = 1;
        bikeOne.isLights = true;
        bikeOne.price = 1;
        bikeOne.color = "color1";

        Bike bikeTwo = new Bike() {
            @Override
            public String toStringForWrite() {
                return null;
            }

            @Override
            public boolean similar(Bike bike) {
                return false;
            }
        };
        bikeTwo.type = BikeType.E_BIKE;
        bikeTwo.brand = "brand1";
        bikeTwo.weightInGrams = 1;
        bikeTwo.isLights = true;
        bikeTwo.price = 1;
        bikeTwo.color = "color1";

        Bike bikeThree = new Bike() {
            @Override
            public String toStringForWrite() {
                return null;
            }

            @Override
            public boolean similar(Bike bike) {
                return false;
            }
        };
        bikeThree.type = BikeType.E_BIKE;
        bikeThree.brand = "brand1";
        bikeThree.weightInGrams = null;
        bikeThree.isLights = true;
        bikeThree.price = null;
        bikeThree.color = "color1";

        Bike bikeFour = new Bike() {
            @Override
            public String toStringForWrite() {
                return null;
            }

            @Override
            public boolean similar(Bike bike) {
                return false;
            }
        };
        bikeFour.type = BikeType.E_BIKE;
        bikeFour.brand = "brand1";
        bikeFour.weightInGrams = 1;
        bikeFour.isLights = true;
        bikeFour.price = 11111111;
        bikeFour.color = "color1";

        assertEquals(bikeOne.hashCode(), bikeTwo.hashCode());
        assertNotEquals(bikeOne.hashCode(), bikeThree.hashCode());
        assertNotEquals(bikeOne.hashCode(), bikeFour.hashCode());
    }

    @Test
    void equals() {
        Bike bikeOne = new Bike() {
            @Override
            public String toStringForWrite() {
                return null;
            }

            @Override
            public boolean similar(Bike bike) {
                return false;
            }
        };
        bikeOne.type = BikeType.E_BIKE;
        bikeOne.brand = "brand1";
        bikeOne.weightInGrams = 1;
        bikeOne.isLights = true;
        bikeOne.price = 1;
        bikeOne.color = "color1";

        Bike bikeTwo = new Bike() {
            @Override
            public String toStringForWrite() {
                return null;
            }

            @Override
            public boolean similar(Bike bike) {
                return false;
            }
        };
        bikeTwo.type = BikeType.E_BIKE;
        bikeTwo.brand = "brand1";
        bikeTwo.weightInGrams = 1;
        bikeTwo.isLights = true;
        bikeTwo.price = 1;
        bikeTwo.color = "color1";

        Bike bikeThree = new Bike() {
            @Override
            public String toStringForWrite() {
                return null;
            }

            @Override
            public boolean similar(Bike bike) {
                return false;
            }
        };
        bikeThree.type = BikeType.E_BIKE;
        bikeThree.brand = "brand1";
        bikeThree.weightInGrams = null;
        bikeThree.isLights = true;
        bikeThree.price = null;
        bikeThree.color = "color1";

        Bike bikeFour = new Bike() {
            @Override
            public String toStringForWrite() {
                return null;
            }

            @Override
            public boolean similar(Bike bike) {
                return false;
            }
        };
        bikeFour.type = BikeType.E_BIKE;
        bikeFour.brand = "brand1";
        bikeFour.weightInGrams = 1;
        bikeFour.isLights = true;
        bikeFour.price = 11111111;
        bikeFour.color = "color1";

        // TODO
        assertNotEquals(bikeOne, bikeThree);
        assertNotEquals(bikeOne, bikeFour);
    }
}