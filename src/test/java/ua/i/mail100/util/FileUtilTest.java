package ua.i.mail100.util;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileUtilTest {
    public static final String MAIN_DIR = System.getProperty("user.dir");
    public static final String FILE_SEP = System.getProperty("file.separator");
    public static final String FILES_DIR = MAIN_DIR + FILE_SEP + "src" + FILE_SEP + "test" + FILE_SEP + "files";
    public static final String TEST_INPUT_FILE_NAME = "input.txt"; // DONT CHANGE THIS FILE!
    public static final String TEST_NOT_LINE_SEPARATOR_FILE_NAME = "not_line_separator.txt"; // DONT CHANGE THIS FILE!
    public static final String TEST_LINE_SEPARATOR_FILE_NAME = "ok_line_separator.txt"; // DONT CHANGE THIS FILE!
    public static final String TEST_RESULT_FILE_NAME = "result.txt";

    List<String> strings = Arrays.asList(
            "1",
            "22",
            "333",
            "4444");

    @Test
    void appendFile() throws IOException {
        List<String> empty = new ArrayList<>();
        Path path = Paths.get(FILES_DIR + FILE_SEP + TEST_RESULT_FILE_NAME);
        Files.write(path, empty);

        FileUtil.appendTo(strings, FILES_DIR, TEST_RESULT_FILE_NAME);
        FileUtil.appendTo(strings, FILES_DIR, TEST_RESULT_FILE_NAME);

        List<String> expected = new ArrayList<>(strings);
        expected.addAll(expected);
        List<String> readedStrings = FileUtil.read(FILES_DIR, TEST_RESULT_FILE_NAME);
        Assert.assertEquals(expected, readedStrings);
    }

    @Test
    void read() throws IOException {
        List<String> readedStrings = FileUtil.read(FILES_DIR, TEST_INPUT_FILE_NAME);
        Assert.assertEquals(strings, readedStrings);
    }

    @Test
    void isLineSeparatorAtEnd() throws IOException{
        Boolean noSeparator = FileUtil.isLineSeparatorAtEnd(FILES_DIR, TEST_NOT_LINE_SEPARATOR_FILE_NAME);
        assertFalse(noSeparator);

        Boolean okSeparator = FileUtil.isLineSeparatorAtEnd(FILES_DIR, TEST_LINE_SEPARATOR_FILE_NAME);
        assertTrue(okSeparator);
    }
}