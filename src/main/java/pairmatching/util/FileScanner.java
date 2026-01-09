package pairmatching.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import pairmatching.model.crew.Course;
import pairmatching.model.crew.Crew;

public class FileScanner {
    private static final String BACKEND_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_PATH = "src/main/resources/frontend-crew.md";

    public List<Crew> loadBackendCrews() {
        List<String> lines = readFile(BACKEND_PATH);
        return lines.stream()
                .map(this::parseToBackendCrew)
                .collect(Collectors.toList());
    }

    public List<Crew> loadFrontendCrews() {
        List<String> lines = readFile(BACKEND_PATH);
        return lines.stream()
                .map(this::parseToFrontendCrew)
                .collect(Collectors.toList());
    }

    private Crew parseToBackendCrew(String line) {
        return new Crew(Course.BACKEND, line.trim());
    }

    private Crew parseToFrontendCrew(String line) {
        return new Crew(Course.BACKEND, line.trim());
    }

    public List<String> readFile(String filePath) {
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