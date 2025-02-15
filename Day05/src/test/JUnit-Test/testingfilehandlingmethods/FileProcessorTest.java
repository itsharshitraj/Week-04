package testingfilehandlingmethods;

import junit.testingfilehandlingmethods.FileProcessor;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FileProcessorTest {

    private FileProcessor fileProcessor;
    private static final String TEST_FILE = "src/test/java/testingfilehandlingmethods/testfile.txt";

    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, JUnit!";

        // Write content to file
        fileProcessor.writeToFile(TEST_FILE, content);

        // Read content from file and verify
        String readContent = fileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        fileProcessor.writeToFile(TEST_FILE, "Sample content");

        // Verify file exists
        assertTrue(Files.exists(Path.of(TEST_FILE)));
    }

    @Test
    void testReadNonExistentFile() {
        Exception exception = assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
        assertTrue(exception.getMessage().contains("nonexistent.txt"));
    }
}

