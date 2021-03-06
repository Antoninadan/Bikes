package ua.i.mail100;

import ua.i.mail100.input.ElectroBikeInputer;
import ua.i.mail100.input.MechanikBikeInputer;
import ua.i.mail100.model.Bike;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    private static final String MAIN_MENU = Settings.LINE_SEP +
            "1 - Show the entire EcoBike catalog (per " + Settings.SHOW_BIKES_PER_PAGE + " records)" + Settings.LINE_SEP +
            "2 – Add a new folding bike" + Settings.LINE_SEP +
            "3 – Add a new speedelec" + Settings.LINE_SEP +
            "4 – Add a new e-bike" + Settings.LINE_SEP +
            "5 – Find the first item of a particular brand" + Settings.LINE_SEP +
            "6 – Write to file" + Settings.LINE_SEP +
            "7 – Stop the program ";
    private static final String FIND_ONE_MENU = "1 - Input folding bike parameters" + Settings.LINE_SEP +
            "2 – Input speedelec bike parameters" + Settings.LINE_SEP +
            "3 – Input e-bike bike parameters" + Settings.LINE_SEP;

    public static void main(String[] args) throws IOException {
        final String fileName = args[0];
        List<String> readedFileStrings = FileUtil.read(Settings.FILES_DIR, fileName);
        BikeCollection savedBikes = BikeParser.parse(readedFileStrings);
        BikeCollection newBikes = new BikeCollection();
        String line = "-";

        Pattern pattern = Pattern.compile("([1-7][1-7]*)");
        Matcher matcher = pattern.matcher(line);
        while (!matcher.matches()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(MAIN_MENU);
            line = bufferedReader.readLine();
            if (line.equals("1")) {
                printFilePath(fileName);
                showBikesPerPages(savedBikes);
            } else if (line.equals("2")) {
                newBikes.append(MechanikBikeInputer.inputFoldingBike());
                System.out.println("Successfully add FOLDING BIKE");
            } else if (line.equals("3")) {
                newBikes.append(ElectroBikeInputer.inputSpeedelec());
                System.out.println("Successfully add SPEEDELEC");
            } else if (line.equals("4")) {
                newBikes.append(ElectroBikeInputer.inputEBike());
                System.out.println("Successfully add E-BIKE");
            } else if (line.equals("5")) {
                showFirstBikeByCriterion(savedBikes, args[1]);
            } else if (line.equals("6")) {
                savedBikes = saveToFile(Settings.FILES_DIR, fileName, savedBikes, newBikes);
            } else if (line.equals("7")) {
                exit(newBikes, fileName);
            } else {
                System.out.println("Bad command ");
            }
        }
    }

    private static void printFilePath(String fileName) {
        Path filePath = Paths.get(Settings.FILES_DIR + Settings.FILE_SEP + fileName);
        System.out.println("File path: " + filePath + Settings.LINE_SEP);
    }

    private static void showBikesPerPages(BikeCollection bikes) throws IOException {
        List<BikeCollection> bikeCollectionList = bikes.dividePerRecords(Settings.SHOW_BIKES_PER_PAGE);
        int count = 0;
        while (bikeCollectionList.size() - 1 > count) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            bikeCollectionList.get(count).print();
            System.out.println(Settings.LINE_SEP + "Press any key to continue ");
            bufferedReader.readLine();
            count++;
        }
        bikeCollectionList.get(count).print();
    }

    private static void showFirstBikeByCriterion(BikeCollection bikes, String searchType) throws IOException {
        System.out.println(FIND_ONE_MENU);
        Bike criterion = null;
        String line = "-";
        Pattern pattern = Pattern.compile("([1-3][1-3]*)");
        Matcher matcher = pattern.matcher(line);
        while (!matcher.matches()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            line = bufferedReader.readLine();
            if (line.equals("1")) {
                criterion = MechanikBikeInputer.inputFoldingBike();
                showCriterionAndOneFinded(bikes, criterion, searchType);
                return;
            } else if (line.equals("2")) {
                criterion = ElectroBikeInputer.inputSpeedelec();
                showCriterionAndOneFinded(bikes, criterion, searchType);
                return;
            } else if (line.equals("3")) {
                criterion = ElectroBikeInputer.inputEBike();
                showCriterionAndOneFinded(bikes, criterion, searchType);
                return;
            } else {
                System.out.println("Bad command ");
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
            System.out.println(Settings.LINE_SEP + "Result: " + Settings.LINE_SEP + finded);
        } else {
            System.out.println(Settings.LINE_SEP + "Result: -");
        }
    }

    public static void exit(BikeCollection newBikes, String fileName) throws IOException {
        if (newBikes.getBikes().size() == 0) {
            System.exit(0);
        } else {
            System.out.println("You have unsaved records. If you want to save to file - press \"1\". " +
                    "If you want to exit without saving - press \"2\"");
            String line = "-";
            Pattern pattern = Pattern.compile("([1-2][1-2]*)");
            Matcher matcher = pattern.matcher(line);
            while (!matcher.matches()) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                line = bufferedReader.readLine();
                if (line.equals("1")) {
                    FileUtil.appendTo(newBikes.getListForWrite(), Settings.FILES_DIR, fileName);
                    System.exit(0);
                } else if (line.equals("2")) {
                    System.exit(0);
                } else {
                    System.out.println("Bad command. To save = press \"1\", to exit without saving - press \"2\"");
                }
            }
        }
    }

    public static BikeCollection saveToFile(String pathName, String fileName, BikeCollection savedBikes, BikeCollection newBikes)
            throws IOException {
        if (newBikes.getBikes().size() == 0) {
            System.out.println("You don't have unsaved records");
        } else {
            printFilePath(fileName);
            List<String> listToWrite = newBikes.getListForWrite();
            if (!FileUtil.isLineSeparatorAtEnd(pathName, fileName)) {
                String firstRecordText = Settings.LINE_SEP + listToWrite.get(0);
                listToWrite.remove(0);
                listToWrite.add(0, firstRecordText);
            }
            FileUtil.appendTo(listToWrite, pathName, fileName);
            savedBikes = savedBikes.union(newBikes);
            newBikes.clear();
            System.out.println("Successfully saved");
        }
        return savedBikes;
    }
}
