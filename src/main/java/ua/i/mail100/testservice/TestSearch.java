package ua.i.mail100.testservice;

import ua.i.mail100.model.Bike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.service.BikeParser;
import ua.i.mail100.service.LinearSearch;
import ua.i.mail100.service.SetSearch;
import ua.i.mail100.service.multisearch.Dispatcher;
import ua.i.mail100.service.multisearch.MultiSearch;
import ua.i.mail100.service.multisearch.ThreadItem;
import ua.i.mail100.util.DivideUtil;
import ua.i.mail100.util.FileUtil;
import ua.i.mail100.util.TimeFixUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestSearch {
    public static final String LINE_SEP = System.getProperty("line.separator");

    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FILES_DIR = MAIN_DIR + FILE_SEP + "files";

    public static void main(String[] args) throws IOException {
        ElectroBike criterion = new ElectroBike(BikeType.SPEEDELEC, "Ferrari", null,
                null, "uniq_color", null, null, null);

        List<String> readedFileStrings = FileUtil.read(FILES_DIR, "test2.txt");
        BikeCollection savedBikes = BikeParser.parse(readedFileStrings);

        SetSearch setSearch = new SetSearch(savedBikes);
        TimeFixUtil timeFixUtil = new TimeFixUtil();
        Bike b = setSearch.findOneSimilarTo(criterion);
        timeFixUtil.elapsedTimePrint();
        System.out.println("result:               "+ b);
        System.out.println();

        TimeFixUtil timeFixUtil3 = new TimeFixUtil();
        BikeCollection finded = setSearch.findAllSimilarTo(criterion);
        timeFixUtil3.elapsedTimePrint();
        System.out.println("result:               ");
        finded.print();
        System.out.println();

        System.out.println("-------------");

        LinearSearch linearSearch = new LinearSearch(savedBikes);
        TimeFixUtil timeFixUtil2 = new TimeFixUtil();
        Bike b2 = linearSearch.findOneSimilarTo(criterion);
        timeFixUtil2.elapsedTimePrint();
        System.out.println("result:               "+ b);
        System.out.println();

        TimeFixUtil timeFixUtil4 = new TimeFixUtil();
        BikeCollection finded2 = linearSearch.findAllSimilarTo(criterion);
        timeFixUtil4.elapsedTimePrint();
        System.out.println("result:               ");
        finded2.print();
        System.out.println();

        //        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        //
        System.out.println("-----------------------------");


        MultiSearch multiSearch = new MultiSearch(savedBikes, 1);
        TimeFixUtil timeFixUtil5 = new TimeFixUtil();

        Bike b5 =  multiSearch.findOneSimilarTo(criterion);
        timeFixUtil5.elapsedTimePrint();
        System.out.println("result:               "+ b5);



    }
}
