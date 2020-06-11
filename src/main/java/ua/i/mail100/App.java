package ua.i.mail100;

import ua.i.mail100.input.ElectroBikeInputer;
import ua.i.mail100.input.MechanikBikeInputer;
import ua.i.mail100.model.*;
import ua.i.mail100.modelcontainer.BikeCollection;
import ua.i.mail100.service.BikeParser;
import ua.i.mail100.service.SearchService;
import ua.i.mail100.util.FileUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App {
    public static final String LINE_SEP = System.getProperty("line.separator");

    private static final String MAIN_DIR = System.getProperty("user.dir");
    private static final String FILE_SEP = System.getProperty("file.separator");
    private static final String FILES_DIR = MAIN_DIR + FILE_SEP + "files";

    private static final int SHOW_BIKES_PER_PAGE = 5;

    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO change to args[0];
        final String fileName = "append.txt";

        List<String> readedFileStrings = FileUtil.readFile(FILES_DIR, fileName);
        BikeCollection savedBikes = BikeParser.parse(readedFileStrings);

        BikeCollection newBikes = new BikeCollection();

        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(LINE_SEP +
                    "1 - Show the entire EcoBike catalog (per " + SHOW_BIKES_PER_PAGE + " records)" + LINE_SEP +
                    "2 – Add a new folding bike" + LINE_SEP +
                    "3 – Add a new speedelec" + LINE_SEP +
                    "4 – Add a new e-bike" + LINE_SEP +
                    "5 – Find the first item of a particular brand" + LINE_SEP +
                    "6 – Write to file" + LINE_SEP +
                    "7 – Find all bikes by criteria" + LINE_SEP +
                    "8 – Stop the program ");
            try {
                Integer command = Integer.parseInt(bufferedReader.readLine());

                if (command == 1) {
                    showBikesPerPages(savedBikes);
                } else if (command == 2) {
                    newBikes.append(MechanikBikeInputer.inputFoldingBike());
                } else if (command == 3) {
                    newBikes.append(ElectroBikeInputer.inputSpeedelec());
                } else if (command == 4) {
                    newBikes.append(ElectroBikeInputer.inputEBike());
                } else if (command == 5) {
                    showFirstBikeByCriterion(savedBikes);
                } else if (command == 6) {
                    FileUtil.appendFile(newBikes.getListForWrite(), FILES_DIR, fileName);
                    savedBikes = savedBikes.union(newBikes);
                    newBikes.clear();
                } else if (command == 7) return;
            } catch (NumberFormatException e) {
                System.out.println("Bad command");
            }
        }
    }

    private static void showBikesPerPages(BikeCollection bikes) throws IOException {
        List<BikeCollection> bikeCollectionList = bikes.divideListPerRecords(SHOW_BIKES_PER_PAGE);
        int count = 0;

        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            if (bikeCollectionList.size() - 1 >= count) {
                bikeCollectionList.get(count).print();
            } else {
                return;
            }
            System.out.println(LINE_SEP + "Press any key to continue ");
            bufferedReader.readLine();
            count++;
        }
    }

    // TODO not null brand
    private static void showFirstBikeByCriterion(BikeCollection bikes) throws IOException, InterruptedException {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1 - Input folding bike parameters" + LINE_SEP +
                    "2 – Input speedelec bike parameters" + LINE_SEP +
                    "3 – Input e-bike bike parameters" + LINE_SEP);
            Bike criterion;
            try {
                Integer command = Integer.parseInt(bufferedReader.readLine());
                if (command == 1) {
                    criterion = MechanikBikeInputer.inputFoldingBike();
                    showCriterionAndOneFinded(bikes, criterion);
                    return;
                } else if (command == 2) {
                    criterion = ElectroBikeInputer.inputSpeedelec();
                    showCriterionAndOneFinded(bikes, criterion);
                    return;
                } else if (command == 3) {
                    criterion = ElectroBikeInputer.inputEBike();
                    showCriterionAndOneFinded(bikes, criterion);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Bad command");
            }

        }
    }

    public static void showCriterionAndOneFinded(BikeCollection bikes, Bike criterion) {
        SearchService searchService = new SearchService(bikes);
        System.out.println("Your search parameters:" + LINE_SEP + criterion);
        Bike finded = searchService.findOneSimilarTo(criterion);
        if (finded != null) {
            System.out.println("Results: ");
            finded.toString();
        } else {
            System.out.println("Results: 0");
        }
    }
}
