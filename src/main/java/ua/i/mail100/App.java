package ua.i.mail100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static final String LINE_SEP = System.getProperty("line.separator");
    private static final int SHOW_BIKES_PER_PAGE = 20;

    public static void main(String[] args) throws IOException, InterruptedException{
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\n" +
                    "1 - Show the entire EcoBike catalog (per " + SHOW_BIKES_PER_PAGE + " records, to continue press Enter)" + LINE_SEP +
                    "2 – Add a new folding bike" + LINE_SEP +
                    "3 – Add a new speedelec" + LINE_SEP +
                    "4 – Add a new e-bike" + LINE_SEP +
                    "5 – Find the first item of a particular brand" + LINE_SEP +
                    "6 – Write to file" + LINE_SEP +
                    "7 – Find all bikes by criteria" + LINE_SEP +
                    "8 – Stop the program ");
            try {
                Integer command = Integer.parseInt(bufferedReader.readLine());

                if (command == 1) {System.out.println("Print catalog ");}
                else if (command == 2) {System.out.println("Add a new folding bike");}
                else if (command == 3) {System.out.println("Add a new speedelec");}
                else if (command == 4) {System.out.println("Add a new e-bike");}
                else if (command == 5) {System.out.println("Add a new e-bike");}
                else if (command == 6) {System.out.println("Write to file");}
                else if (command == 7) {System.out.println("Find all bikes by criteria");}
                else if (command == 8) return;
            } catch (NumberFormatException e) {
                System.out.println("Bad command");
            }
        }
    }
}
