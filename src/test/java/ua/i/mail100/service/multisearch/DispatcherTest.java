package ua.i.mail100.service.multisearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.model.Bike;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.representative.BikeCollection;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DispatcherTest {
    List<ThreadItem> threadsOne;
    List<ThreadItem> threadsTwo;
    ThreadItem threadItem1;
    ThreadItem threadItem2;
    ThreadItem threadItem3;
    Dispatcher dispatcher1;
    Dispatcher dispatcher2;
    Dispatcher dispatcher3;

    @BeforeEach
    void setUp() {
        BikeCollection bikeCollection = new BikeCollection();
        Bike criterion = new ElectroBike(BikeType.E_BIKE, "brand", 45234,
                true, "rose", 11, 123, 123);
        Bike bike2 = new ElectroBike(BikeType.E_BIKE, "brand", 45234,
                true, "rose", 141, 123, 123);
        Bike bike3 = new ElectroBike(BikeType.E_BIKE, "brand_new", 45234,
                true, "rose", 11, 123, 123);
        bikeCollection.append(bike2);
        bikeCollection.append(bike3);

        threadsOne = new ArrayList<>();
        threadsTwo = new ArrayList<>();

        dispatcher1 = new Dispatcher(threadsOne);
        dispatcher2 = new Dispatcher(threadsOne);
        dispatcher3 = new Dispatcher(threadsTwo);
        threadsOne.add(threadItem1);
        threadsOne.add(threadItem2);
        threadsTwo.add(threadItem3);

        threadItem1 = new ThreadItem(bikeCollection, criterion, dispatcher1);
        threadItem2 = new ThreadItem(bikeCollection, criterion, dispatcher1);
        threadItem3 = new ThreadItem(bikeCollection, criterion, dispatcher1);
    }

    @Test
    void equals() {
        assertEquals(dispatcher1, dispatcher2);
        assertNotEquals(dispatcher1, dispatcher3);
    }

    @Test
    void hashCodeTest() {
        assertEquals(dispatcher1.hashCode(), dispatcher2.hashCode());
        assertNotEquals(dispatcher1.hashCode(), dispatcher3.hashCode());
    }
}