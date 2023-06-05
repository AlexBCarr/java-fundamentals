package linter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Error: No file path. Please input a file path");
        }

        if (args.length > 1) {
            throw new IllegalArgumentException("Error: Too many arguments. Please follow the command format ./gradlew run --args /absolutePath/to/your/file.js");
        }
        Path path = Paths.get(args[0]).toAbsolutePath();
        List<String> errorMessages = runLinter(path);

        // Sout zero errors
        if (errorMessages.isEmpty()) {
            System.out.println("No errors found.");
        }
        // Sout every error
        for (String errorMessage : errorMessages) {
            System.out.println(errorMessage);
        }
    }

    public static List<String> runLinter(Path filePath) throws IOException {
        List<String> errorMessages = new ArrayList<>();

        try (Scanner scanner = new Scanner(filePath)) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();

                // Time for a big ol' set of conditions to meet the brief
                if (!currentLine.isEmpty() && !currentLine.endsWith("{") && !currentLine.endsWith("}") && !currentLine.contains("if") && !currentLine.contains("else") && !currentLine.startsWith("//") && !currentLine.endsWith(";")) {
                    String errorMessage = String.format("Line %d: Missing semicolon.\n", lineNumber);
                    errorMessages.add(errorMessage);
                }
                lineNumber++;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return errorMessages;
    }
}