package ua.i.mail100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.i.mail100.model.BikeType;
import ua.i.mail100.model.ElectroBike;
import ua.i.mail100.representative.BikeCollection;
import ua.i.mail100.settings.Settings;
import ua.i.mail100.util.FileUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    public static final String LINE_SEP = System.getProperty("line.separator");
    public static final String MAIN_DIR = System.getProperty("user.dir");
    public static final String FILE_SEP = System.getProperty("file.separator");
    public static final String FILES_DIR = MAIN_DIR + FILE_SEP + "src" + FILE_SEP + "test" + FILE_SEP + "files";
    public static final String TEST_LINE_SEPARATOR_FILE_NAME = "save_ok_line_separator.txt";
    public static final String TEST_NOT_LINE_SEPARATOR_FILE_NAME = "save_not_line_separator.txt";

    ElectroBike bike1;
    ElectroBike bike2;
    ElectroBike bike3;
    ElectroBike bike4;
    BikeCollection saveBikes = new BikeCollection();
    BikeCollection newBikes = new BikeCollection();
    BikeCollection expectedBikes = new BikeCollection();
    String contentLineSeparator;
    String contentNotLineSeparator;

    @BeforeEach
    void setUp() throws IOException {
        bike1 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 1, 123, 123);
        bike2 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 2, 123, 123);
        bike3 = new ElectroBike(BikeType.E_BIKE, "brand1", 45234,
                true, "rose", 3, 123, 123);
        bike4 = new ElectroBike(BikeType.E_BIKE, "brand1", null,
                null, "", 4, null, null);

        saveBikes.append(bike1);
        saveBikes.append(bike2);

        newBikes.append(bike3);
        newBikes.append(bike4);

        expectedBikes.append(bike1);
        expectedBikes.append(bike2);
        expectedBikes.append(bike3);
        expectedBikes.append(bike4);

        String bikeFirstStr = "E-BIKE brand1; 123; 45234; true; 123; rose; 3";

        contentLineSeparator = bikeFirstStr + LINE_SEP;
        Path pathLineSeparator = Paths.get(FILES_DIR + FILE_SEP + TEST_LINE_SEPARATOR_FILE_NAME);
        Files.write(pathLineSeparator, contentLineSeparator.getBytes());

        contentNotLineSeparator = bikeFirstStr;
        Path pathNotLineSeparator = Paths.get(FILES_DIR + FILE_SEP + TEST_NOT_LINE_SEPARATOR_FILE_NAME);
        Files.write(pathNotLineSeparator, contentNotLineSeparator.getBytes());
    }

    @Test
    void saveToFile() throws IOException {
        BikeCollection actual = App.saveToFile(FILES_DIR, TEST_LINE_SEPARATOR_FILE_NAME, saveBikes, newBikes);

        assertEquals(expectedBikes, actual);

        newBikes.append(bike3);
        newBikes.append(bike4);
        BikeCollection actual2 = App.saveToFile(FILES_DIR, TEST_NOT_LINE_SEPARATOR_FILE_NAME, saveBikes, newBikes);

        newBikes.append(bike3);
        newBikes.append(bike4);
        BikeCollection actual3 = App.saveToFile(FILES_DIR, TEST_LINE_SEPARATOR_FILE_NAME, saveBikes, newBikes);

        // should be no exception
        List<String> readedFileStrings1 = FileUtil.read(FILES_DIR, TEST_NOT_LINE_SEPARATOR_FILE_NAME);
        List<String> readedFileStrings2 = FileUtil.read(FILES_DIR, TEST_LINE_SEPARATOR_FILE_NAME);
    }
}

