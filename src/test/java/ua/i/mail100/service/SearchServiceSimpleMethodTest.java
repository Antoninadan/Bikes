//package ua.i.mail100.service;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import ua.i.mail100.model.Bike;
//import ua.i.mail100.model.BikeType;
//import ua.i.mail100.model.ElectroBike;
//import ua.i.mail100.model.MechanicBike;
//import ua.i.mail100.representative.BikeCollection;
//import ua.i.mail100.service.LinearSearch;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class SearchServiceSimpleMethodTest {
//    ElectroBike criterion;
//    ElectroBike bike2;
//    ElectroBike bike3;
//    ElectroBike bike4; // this only one similar
//    ElectroBike bike5;
//    ElectroBike bike6;
//    MechanicBike bike7;
//    BikeCollection bikeCollection = new BikeCollection();
//    BikeCollection bikeCollectionTwo = new BikeCollection();
//    BikeCollection bikeCollectionThree = new BikeCollection();
//    LinearSearch searchServiceSimpleMethodOne;
//    LinearSearch searchServiceSimpleMethodTwo;
//    LinearSearch searchServiceSimpleMethodThree;
//
//    @BeforeEach
//    void setUp() {
//        criterion = new ElectroBike(BikeType.E_BIKE, "brand", 45234,
//                true, "rose", 11, 123, 123);
//        bike2 = new ElectroBike(BikeType.E_BIKE, "brand", 45234,
//                true, "rose", 141, 123, 123);
//        bike3 = new ElectroBike(BikeType.E_BIKE, "brand_new", 45234,
//                true, "rose", 11, 123, 123);
//        bike4 = new ElectroBike(BikeType.E_BIKE, "brand", null,
//                null, "rose", null, 123, 123);
//        bike5 = new ElectroBike(BikeType.E_BIKE, "brand1_new", null,
//                null, "rose", 15671, 123, 123);
//        bike6 = new ElectroBike(BikeType.SPEEDELEC, "brand", null,
//                null, "rose", null, 123, 123);
//        bike7 = new MechanicBike(BikeType.FOLDING_BIKE, "brand", 45234,
//                true, "rose", 11, null, null);
//        bikeCollection.append(bike2);
//        bikeCollection.append(bike3);
//        bikeCollection.append(bike4);
//        bikeCollection.append(bike5);
//        bikeCollection.append(bike6);
//        bikeCollection.append(bike7);
//
//        bikeCollectionTwo.append(bike2);
//        bikeCollectionTwo.append(bike3);
//        bikeCollectionTwo.append(bike4);
//        bikeCollectionTwo.append(bike5);
//        bikeCollectionTwo.append(bike6);
//        bikeCollectionTwo.append(bike7);
//
//        bikeCollectionThree.append(bike7);
//
//        searchServiceSimpleMethodOne = new LinearSearch(bikeCollection);
//        searchServiceSimpleMethodTwo = new LinearSearch(bikeCollectionTwo);
//        searchServiceSimpleMethodThree = new LinearSearch(bikeCollectionThree);
//    }
//
//    @Test
//    void findOneSimilarTo() {
//        LinearSearch searchServiceSimpleMethod = new LinearSearch(bikeCollection);
//        Bike findedBike = searchServiceSimpleMethod.findOneSimilarTo(criterion);
//
//        assertFalse(bike2.similar(criterion));
//        assertFalse(bike3.similar(criterion));
//        assertTrue(bike4.similar(criterion));
//        assertFalse(bike5.similar(criterion));
//        assertFalse(bike6.similar(criterion));
//        assertFalse(bike7.similar(criterion));
//        assertTrue(bike4.similar(findedBike));
//    }
//
//    @Test
//    void hashCodeTest() {
//    }
//
//    @Test
//    void equals() {
//    }
//}