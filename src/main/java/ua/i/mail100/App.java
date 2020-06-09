package ua.i.mail100;

import ua.i.mail100.model.bikes.BikeCollection;
import ua.i.mail100.model.bikes.BikeType;
import ua.i.mail100.model.bikes.ElectroBike;
import ua.i.mail100.model.bikes.MechanicBike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class App {
    public static final String LINE_SEP = System.getProperty("line.separator");
    private static final int SHOW_BIKES_PER_PAGE = 5;

    public static void main(String[] args) throws IOException, InterruptedException {
        ElectroBike electroBike1 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        ElectroBike electroBike2 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        MechanicBike mechanicBike1 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 1231, 123, 123);
        MechanicBike mechanicBike2 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 452888834,
                false, "rose", 1231, 123, 123);
        ElectroBike electroBike3 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        ElectroBike electroBike4 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 1231, 123, 123);
        MechanicBike mechanicBike3 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 45234,
                false, "rose", 1231, 123, 123);
        MechanicBike mechanicBike4 = new MechanicBike(BikeType.FOLDING_BIKE, "brand1", 452888834,
                false, "rose", 1231, 123, 123);


        BikeCollection savedBikes = new BikeCollection();

        savedBikes.appent(electroBike1);
        savedBikes.appent(electroBike2);
        savedBikes.appent(electroBike3);
        savedBikes.appent(electroBike4);
        savedBikes.appent(mechanicBike1);
        savedBikes.appent(mechanicBike2);
        savedBikes.appent(mechanicBike3);
        savedBikes.appent(mechanicBike4);

        BikeCollection newBikes = new BikeCollection();
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\n" +
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
                    System.out.println("Add a new folding bike");
                } else if (command == 3) {
                    System.out.println("Add a new speedelec");
                } else if (command == 4) {
                    System.out.println("Add a new e-bike");
                } else if (command == 5) {
                    System.out.println("Add a new e-bike");
                } else if (command == 6) {
                    System.out.println("Write to file");
                } else if (command == 7) {
                    System.out.println("Find all bikes by criteria");
                } else if (command == 8) return;
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
}
