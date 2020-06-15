package ua.i.mail100;

import ua.i.mail100.input.ElectroBikeInputer;
import ua.i.mail100.input.MechanikBikeInputer;
import ua.i.mail100.model.*;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.service.BikeParser;
import ua.i.mail100.service.LinearSearch;
import ua.i.mail100.service.SetSearch;
import ua.i.mail100.service.multisearch.MultiSearch;
import ua.i.mail100.settings.Settings;
import ua.i.mail100.util.FileUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String fileName = args[0];

        List<String> readedFileStrings = FileUtil.read(Settings.FILES_DIR, fileName);
        BikeCollection savedBikes = BikeParser.parse(readedFileStrings);

        BikeCollection newBikes = new BikeCollection();

        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(Settings.LINE_SEP +
                    "1 - Show the entire EcoBike catalog (per " + Settings.SHOW_BIKES_PER_PAGE + " records)" + Settings.LINE_SEP +
                    "2 – Add a new folding bike" + Settings.LINE_SEP +
                    "3 – Add a new speedelec" + Settings.LINE_SEP +
                    "4 – Add a new e-bike" + Settings.LINE_SEP +
                    "5 – Find the first item of a particular brand" + Settings.LINE_SEP +
                    "6 – Write to file" + Settings.LINE_SEP +
                    "7 – Find all bikes by criteria" + Settings.LINE_SEP +
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
                    showFirstBikeByCriterion(savedBikes, args[1]);
                } else if (command == 6) {
                    FileUtil.appendTo(newBikes.getListForWrite(), Settings.FILES_DIR, fileName);
                    savedBikes = savedBikes.union(newBikes);
                    newBikes.clear();
                } else if (command == 7) return;
            } catch (NumberFormatException e) {
                System.out.println("Bad command");
            }
        }
    }

    private static void showBikesPerPages(BikeCollection bikes) throws IOException {
        List<BikeCollection> bikeCollectionList = bikes.dividePerRecords(Settings.SHOW_BIKES_PER_PAGE);
        int count = 0;

        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            if (bikeCollectionList.size() - 1 >= count) {
                bikeCollectionList.get(count).print();
            } else {
                return;
            }
            System.out.println(Settings.LINE_SEP + "Press any key to continue ");
            bufferedReader.readLine();
            count++;
        }
    }

    private static void showFirstBikeByCriterion(BikeCollection bikes, String searchType) throws IOException, InterruptedException {
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("1 - Input folding bike parameters" + Settings.LINE_SEP +
                    "2 – Input speedelec bike parameters" + Settings.LINE_SEP +
                    "3 – Input e-bike bike parameters" + Settings.LINE_SEP);
            Bike criterion;
            try {
                Integer command = Integer.parseInt(bufferedReader.readLine());
                if (command == 1) {
                    criterion = MechanikBikeInputer.inputFoldingBike();
                    showCriterionAndOneFinded(bikes, criterion, searchType);
                    return;
                } else if (command == 2) {
                    criterion = ElectroBikeInputer.inputSpeedelec();
                    showCriterionAndOneFinded(bikes, criterion, searchType);
                    return;
                } else if (command == 3) {
                    criterion = ElectroBikeInputer.inputEBike();
                    showCriterionAndOneFinded(bikes, criterion, searchType);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Bad command");
            }

        }
    }

    public static void showCriterionAndOneFinded(BikeCollection bikes, Bike criterion, String searchType) {
        SetSearch setSearch = new SetSearch(bikes);
        LinearSearch linearSearch = new LinearSearch(bikes);
        MultiSearch multiSearch = new MultiSearch(bikes, 3);
        System.out.println("Your search parameters:" + Settings.LINE_SEP + criterion);
        Bike finded = null;
        if (searchType.equals("search1")) {
            finded = setSearch.findOneSimilarTo(criterion);
        }
        if (searchType.equals("search2")) {
            finded = linearSearch.findOneSimilarTo(criterion);
        }
        if (searchType.equals("search3")) {
            finded = multiSearch.findOneSimilarTo(criterion);
        }

        if (finded != null) {
            System.out.println();
            System.out.println("Results: ");
            System.out.println(finded);
        } else {
            System.out.println("Results: 0");
        }
    }
}
