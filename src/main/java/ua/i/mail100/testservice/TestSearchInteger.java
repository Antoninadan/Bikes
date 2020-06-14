package ua.i.mail100.testservice;

import ua.i.mail100.model.Bike;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.service.BikeParser;
import ua.i.mail100.service.LinearSearch;
import ua.i.mail100.service.SetSearch;
import ua.i.mail100.service.m.LinearSearchI;
import ua.i.mail100.service.m.MultiSearchI;
import ua.i.mail100.service.multisearch.MultiSearch;
import ua.i.mail100.util.FileUtil;
import ua.i.mail100.util.TimeFixUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestSearchInteger {
    public static final String LINE_SEP = System.getProperty("line.separator");

    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FILES_DIR = MAIN_DIR + FILE_SEP + "files";

    public static void main(String[] args) throws IOException {

        List<String> readedFileStrings = FileUtil.read(FILES_DIR, "integers.txt");
        Integer criterion = 7777;
        List<Integer> saved = new ArrayList<>();
        for (String each : readedFileStrings) {
            saved.add(Integer.valueOf(each));
        }

        LinearSearchI linearSearch = new LinearSearchI(saved);
        TimeFixUtil timeFixUtil1 = new TimeFixUtil();
        Integer result = linearSearch.findOneSimilarTo(criterion);
        timeFixUtil1.elapsedTimePrint();
        System.out.println("result:               " + result);
        System.out.println();

        System.out.println();
        MultiSearchI multiSearchI = new MultiSearchI(saved, 4);
        TimeFixUtil timeFixUtil2 = new TimeFixUtil();
        Integer result2 = multiSearchI.findOneSimilarTo(criterion);
        System.out.println("TIME = "+ timeFixUtil2.elapsedTime());
        System.out.println("result:               " + result2);
        System.out.println();


    }
}
