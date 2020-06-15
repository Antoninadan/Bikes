package ua.i.mail100.testservice;

import ua.i.mail100.model.Bike;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.service.BikeParser;
import ua.i.mail100.service.LinearSearch;
import ua.i.mail100.service.SetSearch;
import ua.i.mail100.service.multisearch.MultiSearch;
import ua.i.mail100.settings.Settings;
import ua.i.mail100.util.FileUtil;
import ua.i.mail100.util.TimeFixUtil;

import java.io.IOException;
import java.util.List;

public class TestSearch {
    public static void main(String[] args) throws IOException {
//        Bike criterion = new ElectroBike(BikeType.SPEEDELEC, "Ferrari", null,
//                null, "uniq_color", null, null, null);
//        Bike criterion = new MechanicBike(BikeType.FOLDING_BIKE, "BMW", 10500,
//                null, "blue", null, null, null);
        Bike criterion = new ElectroBike(BikeType.SPEEDELEC, "EcoRide", null,
                null, "blue", 1055, null, null);

        List<String> readedFileStrings = FileUtil.read(Settings.FILES_DIR, "test2.txt");
        BikeCollection savedBikes = BikeParser.parse(readedFileStrings);

        System.out.println("SET SEARCH ----------------------------------");
        SetSearch setSearch = new SetSearch(savedBikes);
        TimeFixUtil timeFixUtil = new TimeFixUtil();
        Bike b = setSearch.findOneSimilarTo(criterion);
        timeFixUtil.elapsedTimePrint();
        System.out.println("Result");
        System.out.println(b);
        System.out.println();

        System.out.println("LINEAR SEARCH ----------------------------------");
        LinearSearch linearSearch = new LinearSearch(savedBikes);
        TimeFixUtil timeFixUtil2 = new TimeFixUtil();
        Bike b2 = linearSearch.findOneSimilarTo(criterion);
        timeFixUtil2.elapsedTimePrint();
        System.out.println("Result");
        System.out.println(b2);
        System.out.println();

        System.out.println("MULTI SEARCH ----------------------------------");
        MultiSearch multiSearch = new MultiSearch(savedBikes, 1);
        TimeFixUtil timeFixUtil5 = new TimeFixUtil();
        Bike b3 = multiSearch.findOneSimilarTo(criterion);
        timeFixUtil5.elapsedTimePrint();
        System.out.println("Result");
        System.out.println(b3);
        System.out.println();
    }
}
