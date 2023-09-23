package edu.hsai.dbfiller.fileio;

import java.io.IOException;
import java.nio.file.*;

public class FileIO {
    public static void writeToFile(String data, String path) {
        try {
            Files.writeString(Path.of(path), data,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
