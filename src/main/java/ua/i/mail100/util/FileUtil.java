package ua.i.mail100.util;

import ua.i.mail100.settings.Settings;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtil {

    public static void appendTo(List<String> strLines, String pathName, String fileName) throws IOException {
        Path path = Paths.get(pathName + Settings.FILE_SEP + fileName);
        Files.write(path, strLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
    }

    public static List<String> read(String pathName, String fileName) throws IOException {
        Path path = Paths.get(pathName + Settings.FILE_SEP + fileName);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}