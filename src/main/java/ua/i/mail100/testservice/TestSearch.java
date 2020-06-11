package ua.i.mail100.testservice;

import ua.i.mail100.model.Bike;
import ua.i.mail100.modelcontainer.BikeCollection;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.service.BikeParser;
import ua.i.mail100.service.SearchService;
import ua.i.mail100.util.FileUtil;
import ua.i.mail100.util.TimeFixUtil;

import java.io.IOException;
import java.util.List;

public class TestSearch {
    public static final String LINE_SEP = System.getProperty("line.separator");

    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FILES_DIR = MAIN_DIR + FILE_SEP + "files";

    public static void main(String[] args) throws IOException {
        ElectroBike criterion = new ElectroBike(BikeType.SPEEDELEC, "Ferrari", null,
                null, "uniq_color", null, null, null);

        List<String> readedFileStrings = FileUtil.readFile(FILES_DIR, "test2.txt");
        BikeCollection savedBikes = BikeParser.parse(readedFileStrings);

        SearchService searchService = new SearchService(savedBikes);
        TimeFixUtil timeFixUtil = new TimeFixUtil();
        Bike b = searchService.findOneSimilarTo(criterion);
        timeFixUtil.elapsedTimePrint();
        System.out.println("result:               "+ b);

//        System.out.println();
//        BikeCollection finded = searchService.findAllSimilarTo(criterion);
//        finded.print();







    }
}
