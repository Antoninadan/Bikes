package ua.i.mail100.representative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class BikeCollectionTest {
    ElectroBike eBike1;
    ElectroBike eBike2;
    ElectroBike eBike3;
    MechanicBike mBike1;
    MechanicBike mBike2;
    MechanicBike mBike3;
    BikeCollection bikeCollection;

    @BeforeEach
    void setUp() {
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
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void get() {
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);
        assertEquals(mBike1, bikeCollection.get(0));
        assertEquals(mBike2, bikeCollection.get(1));
    }

    @Test
    void append() {
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);
        assertEquals(2, bikeCollection.getBikes().size());
        assertEquals(mBike1, bikeCollection.get(0));
        assertEquals(mBike2, bikeCollection.get(1));
    }

    @Test
    void getListForWrite() {
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);

        List<String> list = bikeCollection.getListForWrite();

        assertEquals(mBike1.toStringForWrite(), list.get(0));
        assertEquals(mBike2.toStringForWrite(), list.get(1));
    }

    @Test
    void union() {
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);

        BikeCollection bikeCollection2 = new BikeCollection();
        bikeCollection2.append(eBike1);
        bikeCollection2.append(eBike2);

        BikeCollection unitedCollection = bikeCollection.union(bikeCollection2);
        assertEquals(mBike1, unitedCollection.get(0));
        assertEquals(mBike2, unitedCollection.get(1));
        assertEquals(eBike1, unitedCollection.get(2));
        assertEquals(eBike2, unitedCollection.get(3));
    }

    @Test
    void clear() {
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);
        bikeCollection.clear();
        assertEquals(0, bikeCollection.getBikes().size());
    }

    @Test
    void divideListPerRecords() {
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);
        bikeCollection.append(mBike3);
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);
        bikeCollection.append(mBike3);
        bikeCollection.append(eBike1);
        bikeCollection.append(eBike2);
        bikeCollection.append(eBike3);
        bikeCollection.append(eBike1);
        bikeCollection.append(eBike2);
        bikeCollection.append(eBike3);

        List<BikeCollection> dividedCollections = bikeCollection.divideListPerRecords(5);
        assertEquals(5, dividedCollections.get(0).getBikes().size());
        assertEquals(5, dividedCollections.get(1).getBikes().size());
        assertEquals(2, dividedCollections.get(2).getBikes().size());

        assertEquals(mBike1, dividedCollections.get(0).getBikes().get(0));
        assertEquals(mBike2, dividedCollections.get(0).getBikes().get(1));
        assertEquals(mBike3, dividedCollections.get(0).getBikes().get(2));
        assertEquals(mBike1, dividedCollections.get(0).getBikes().get(3));
        assertEquals(mBike2, dividedCollections.get(0).getBikes().get(4));

        assertEquals(mBike3, dividedCollections.get(1).getBikes().get(0));
        assertEquals(eBike1, dividedCollections.get(1).getBikes().get(1));
        assertEquals(eBike2, dividedCollections.get(1).getBikes().get(2));
        assertEquals(eBike3, dividedCollections.get(1).getBikes().get(3));
        assertEquals(eBike1, dividedCollections.get(1).getBikes().get(4));

        assertEquals(eBike2, dividedCollections.get(2).getBikes().get(0));
        assertEquals(eBike3, dividedCollections.get(2).getBikes().get(1));
    }
}