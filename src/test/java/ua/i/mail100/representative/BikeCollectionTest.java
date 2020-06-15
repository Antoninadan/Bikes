package ua.i.mail100.representative;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.model.MechanicBike;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void get() {
        bikeCollection.append(mBike1);
        bikeCollection.append(mBike2);
        assertEquals(mBike1, bikeCollection.get(0));
        assertEquals(mBike2, bikeCollection.get(1));
    }

    @Test
    void getSubCollection() {
        bikeCollection.append(mBike1); // 0
        bikeCollection.append(mBike2); // 1
        bikeCollection.append(mBike3); // 2
        bikeCollection.append(mBike1); // 3
        bikeCollection.append(mBike2); // 4
        bikeCollection.append(mBike3); // 5
        bikeCollection.append(eBike1); // 6

        BikeCollection bikeCollection1 = bikeCollection.getSubCollection(2, 5);
        assertEquals(3, bikeCollection1.getBikes().size());
        assertEquals(mBike3, bikeCollection1.get(0));
        assertEquals(mBike1, bikeCollection1.get(1));
        assertEquals(mBike2, bikeCollection1.get(2));
    }

    @Test
    void append() {
        bikeCollection.append(mBike1);
        bikeCollection.append(eBike1);
        bikeCollection.append(eBike2);
        assertEquals(3, bikeCollection.getBikes().size());
        assertEquals(mBike1, bikeCollection.get(0));
        assertEquals(eBike1, bikeCollection.get(1));
        assertEquals(eBike2, bikeCollection.get(2));

        assertEquals(1, bikeCollection.getFoldingBikeHashSet().size());
        assertTrue(bikeCollection.getFoldingBikeHashSet().contains(mBike1));

        assertEquals(1, bikeCollection.getEBikeHashSet().size());
        assertTrue(bikeCollection.getEBikeHashSet().contains(eBike1));

        assertEquals(1, bikeCollection.getSpedelecBikeHashSet().size());
        assertTrue(bikeCollection.getSpedelecBikeHashSet().contains(eBike2));
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
    void hashCodeTest() {
        BikeCollection bikesOne = new BikeCollection();
        bikesOne.append(mBike1);
        bikesOne.append(mBike2);

        BikeCollection bikesTwo = new BikeCollection();
        bikesTwo.append(mBike1);
        bikesTwo.append(mBike2);

        BikeCollection bikesThree = new BikeCollection();
        bikesThree.append(mBike2);
        bikesThree.append(mBike3);

        BikeCollection bikesFour = new BikeCollection();
        bikesFour.append(mBike2);
        bikesFour.append(mBike1);

        System.out.println(bikesOne.hashCode());
        System.out.println(bikesTwo.hashCode());
        System.out.println(bikesThree.hashCode());
        System.out.println(bikesFour.hashCode());

        assertEquals(bikesOne.hashCode(), bikesTwo.hashCode());
        assertNotEquals(bikesOne.hashCode(), bikesThree.hashCode());
        assertEquals(bikesOne.hashCode(), bikesFour.hashCode());
    }

    @Test
    void equals() {
        BikeCollection bikesOne = new BikeCollection();
        bikesOne.append(mBike1);
        bikesOne.append(mBike2);

        BikeCollection bikesTwo = new BikeCollection();
        bikesTwo.append(mBike1);
        bikesTwo.append(mBike2);

        BikeCollection bikesThree = new BikeCollection();
        bikesThree.append(mBike2);
        bikesThree.append(mBike3);

        BikeCollection bikesFour = new BikeCollection();
        bikesFour.append(mBike2);
        bikesFour.append(mBike1);

        assertEquals(bikesOne, bikesTwo);
        assertNotEquals(bikesOne, bikesThree);
        assertEquals(bikesOne, bikesFour);

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

        List<BikeCollection> dividedCollections = bikeCollection.dividePerRecords(5);
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

    @Test
    void dividePerParts() {
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

        List<BikeCollection> dividedCollections = bikeCollection.dividePerParts(5);
        assertEquals(2, dividedCollections.get(0).getBikes().size());
        assertEquals(2, dividedCollections.get(1).getBikes().size());
        assertEquals(2, dividedCollections.get(2).getBikes().size());
        assertEquals(2, dividedCollections.get(3).getBikes().size());
        assertEquals(4, dividedCollections.get(4).getBikes().size());

        assertEquals(mBike1, dividedCollections.get(0).getBikes().get(0));
        assertEquals(mBike2, dividedCollections.get(0).getBikes().get(1));

        assertEquals(mBike3, dividedCollections.get(1).getBikes().get(0));
        assertEquals(mBike1, dividedCollections.get(1).getBikes().get(1));

        assertEquals(mBike2, dividedCollections.get(2).getBikes().get(0));
        assertEquals(mBike3, dividedCollections.get(2).getBikes().get(1));

        assertEquals(eBike1, dividedCollections.get(3).getBikes().get(0));
        assertEquals(eBike2, dividedCollections.get(3).getBikes().get(1));

        assertEquals(eBike3, dividedCollections.get(4).getBikes().get(0));
        assertEquals(eBike1, dividedCollections.get(4).getBikes().get(1));
        assertEquals(eBike2, dividedCollections.get(4).getBikes().get(2));
        assertEquals(eBike3, dividedCollections.get(4).getBikes().get(3));
    }
}