package ua.i.mail100.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtil {
    public static final String FILE_SEP = System.getProperty("file.separator");


    public static void rewriteTextToFile(List<String> strLines, String pathName, String fileName) throws IOException {
        Path path = Paths.get(pathName + FILE_SEP + fileName);
        Files.write(path, strLines, StandardCharsets.UTF_8);
    }

    public static void appendTextToFile(List<String> strLines, String pathName, String fileName) throws IOException {
        Path path = Paths.get(pathName + FILE_SEP + fileName);
        Files.write(path, strLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
    }

}