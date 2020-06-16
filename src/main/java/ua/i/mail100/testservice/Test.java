package ua.i.mail100.testservice;

import ua.i.mail100.model.Bike;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.representative.BikeCollection;
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

public class Test {
    public static void main(String[] args) throws IOException {
//        String string = new String();
//        String string2 = new String();
//        System.out.println(string.equals(string2));
//
//        Integer price = new Inputer("Input price", InputedType.INTEGER).input();
//        System.out.println(price);

//
//        Pattern pattern = Pattern.compile("(0|[1-9][0-9]*)");
//        Matcher matcher = pattern.matcher("0");
//        boolean matches = matcher.matches();
//        System.out.println(matches);

//
//        Boolean isLight = new Inputer("Input bool", InputedType.BOOLEAN).input();
//        System.out.println(isLight);

//        Boolean b = inputBoolean();


//        Boolean isLight = Boolean.parseBoolean("aaa");

//        printFilePath("test1.txt");


        BikeCollection newBikes = new BikeCollection();
        Bike bike2 = new ElectroBike(BikeType.E_BIKE, "brand", 45234,
                true, "rose", 141, 123, 123);
        newBikes.append(bike2);
        List<String> listToWrite = newBikes.getListForWrite();
//            int size = listToWrite.size();
        if(!FileUtil.isLineSeparatorAtEnd(Settings.FILES_DIR, "test1.txt")) {
            String lastRecordText = Settings.LINE_SEP + listToWrite.get(0);
            listToWrite.remove(0);
            listToWrite.add(0, lastRecordText);
        }
        FileUtil.appendTo(listToWrite, Settings.FILES_DIR, "test1.txt");

    }

    private static void printFilePath(String fileName) {
        Path filePath = Paths.get(Settings.FILES_DIR + Settings.FILE_SEP + fileName);
        System.out.println("File path: " + filePath + Settings.LINE_SEP);
    }

    private static Boolean inputBoolean() throws IOException {
        Boolean resultReturn = null;
        Integer result = -1;
        while (result != null && result == -1) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String line = bufferedReader.readLine();
                Pattern pattern = Pattern.compile("(0|1)");
                if (line.length() > 0) {
                    Matcher matcher = pattern.matcher(line);
                    boolean matches = matcher.matches();
                    if (matches) {
                        resultReturn = Boolean.parseBoolean(line);
                        result = 1;
                    } else {
                        line = "-";
                        result = Integer.parseInt(line);
                    }
                } else result = null;
            } catch (NumberFormatException e) {
                System.out.println("Bad command - true = 1, false = 0");
            } catch (NullPointerException e) {
                return resultReturn;
            }
        }
        return resultReturn;
    }
}
