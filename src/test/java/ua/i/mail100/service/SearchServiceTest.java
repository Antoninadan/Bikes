package ua.i.mail100.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.model.*;
import ua.i.mail100.representative.BikeCollection;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceTest {
    ElectroBike criterion;
    ElectroBike bike2;
    ElectroBike bike3;
    ElectroBike bike4; // this only one similar
    ElectroBike bike5;
    ElectroBike bike6;
    MechanicBike bike7;
    BikeCollection bikeCollection = new BikeCollection();

    @BeforeEach
    void setUp() {
        criterion = new ElectroBike(BikeType.E_BIKE, "brand", 45234,
                true, "rose", 11, 123, 123);
        bike2 = new ElectroBike(BikeType.E_BIKE, "brand", 45234,
                true, "rose", 141, 123, 123);
        bike3 = new ElectroBike(BikeType.E_BIKE, "brand_new", 45234,
                true, "rose", 11, 123, 123);
        bike4 = new ElectroBike(BikeType.E_BIKE, "brand", null,
                null, "rose", null, 123, 123);
        bike5 = new ElectroBike(BikeType.E_BIKE, "brand1_new", null,
                null, "rose", 15671, 123, 123);
        bike6 = new ElectroBike(BikeType.SPEEDELEC, "brand", null,
                null, "rose", null, 123, 123);
        bike7 = new MechanicBike(BikeType.FOLDING_BIKE, "brand", 45234,
                true, "rose", 11, null, null);
        bikeCollection.append(bike2);
        bikeCollection.append(bike3);
        bikeCollection.append(bike4);
        bikeCollection.append(bike5);
        bikeCollection.append(bike6);
        bikeCollection.append(bike7);
    }

    @Test
    void findOneSimilarTo() {
        SearchService searchService = new SearchService(bikeCollection);
        Bike findedBike = searchService.findOneSimilarTo(criterion);

        assertFalse(bike2.similar(criterion));
        assertFalse(bike3.similar(criterion));
        assertTrue(bike4.similar(criterion));
        assertFalse(bike5.similar(criterion));
        assertFalse(bike6.similar(criterion));
        assertFalse(bike7.similar(criterion));
        assertTrue(bike4.similar(findedBike));
    }

    @Test
    void findAllSimilarTo() {
        SearchService searchService = new SearchService(bikeCollection);
        BikeCollection findedCollection = searchService.findAllSimilarTo(criterion);

        assertEquals(1, findedCollection.getBikes().size());

        assertFalse(bike2.similar(criterion));
        assertFalse(bike3.similar(criterion));
        assertTrue(bike4.similar(criterion));
        assertFalse(bike5.similar(criterion));
        assertFalse(bike6.similar(criterion));
        assertFalse(bike7.similar(criterion));
        assertTrue(bike4.similar(findedCollection.get(0)));
    }
}