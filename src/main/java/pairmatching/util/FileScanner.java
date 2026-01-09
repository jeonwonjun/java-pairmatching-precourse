package pairmatching.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileScanner {

    public static List<String> readFile(String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));
            List<String> fileBody = new ArrayList<>();
            scanner.next();
            while (scanner.hasNext()) {
                fileBody.add(scanner.next());
            }
            return fileBody;
        } catch (IOException e) {
            throw new IllegalStateException(ErrorMessage.INVALID_FILE_READ.getMessage());
        }
    }
}