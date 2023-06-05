package linter;

import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    // Declaring ANSI_GREEN to color the successful test souts :)
    public static final String ANSI_GREEN = "\u001B[32m";
    @Test
    public void testMainThrowsExceptionWithNoArguments() throws IOException {
        try {
            String[] args = {};
            App.main(args);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
            System.out.println(ANSI_GREEN + "testMainThrowsExceptionWithNoArguments() - test passed successfully" + ANSI_RESET);
        }
    }

    @Test
    public void testMainThrowsExceptionWithWrongNumberOfArguments() throws IOException {
        try {
            String[] args = {"file1.js", "file2.js"};
            App.main(args);
            // if the exception is not thrown, fail the test
            fail("Expected IllegalArgumentException to be thrown, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            // the exception was thrown, the test passes
            System.out.println(ANSI_GREEN + "testMainThrowsExceptionWithWrongNumberOfArguments() - test passed successfully" + ANSI_RESET);
        }
    }

    @Test
    public void testRunLinterNoErrors() throws Exception {
        Path path = Paths.get("src/test/resources/gates-no-errors.js").toAbsolutePath();
        List<String> errorMessages = App.runLinter(path);

        assertEquals(0, errorMessages.size());

        System.out.println(ANSI_GREEN + "testRunLinterNoErrors() - test passed successfully" + ANSI_RESET);
    }

    @Test
    public void testRunLinterOneError() throws Exception {
        Path path = Paths.get("src/test/resources/gates-one-error.js").toAbsolutePath();
        List<String> errorMessages = App.runLinter(path);

        assertEquals(1, errorMessages.size());
        assertTrue(errorMessages.contains("Line 3: Missing semicolon.\n"));

        System.out.println(ANSI_GREEN + "testRunLinterOneError() - test passed successfully" + ANSI_RESET);
    }

    @Test
    public void testRunLinterFewErrors() throws Exception {
        Path path = Paths.get("src/test/resources/gates-few-errors.js").toAbsolutePath();
        List<String> errorMessages = App.runLinter(path);

        assertEquals(3, errorMessages.size());
        assertTrue(errorMessages.contains("Line 3: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 5: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 11: Missing semicolon.\n"));

        System.out.println(ANSI_GREEN + "testRunLinterFewErrors() - test passed successfully" + ANSI_RESET);
    }

    @Test
    public void testRunLinterManyErrors() throws Exception {
        Path path = Paths.get("src/test/resources/gates-many-errors.js").toAbsolutePath();
        List<String> errorMessages = App.runLinter(path);

        assertEquals(11, errorMessages.size());
        assertTrue(errorMessages.contains("Line 3: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 5: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 11: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 94: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 95: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 96: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 97: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 98: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 99: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 100: Missing semicolon.\n"));
        assertTrue(errorMessages.contains("Line 101: Missing semicolon.\n"));

        System.out.println(ANSI_GREEN + "testRunLinterManyErrors() - test passed successfully" + ANSI_RESET);
    }

    @Test
    public void testRunLinterEmptyFile() throws Exception {
        Path path = Paths.get("src/test/resources/empty-file.js").toAbsolutePath();
        List<String> errorMessages = App.runLinter(path);

        assertEquals(0, errorMessages.size());

        System.out.println(ANSI_GREEN + "testRunLinterEmptyFile() - test passed successfully" + ANSI_RESET);
    }
}