package performancetesting;
import junit.performancetesting.TaskProcessor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

class TaskProcessorTest {

    private final TaskProcessor taskProcessor = new TaskProcessor();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Fail if execution takes >2 seconds
    void testLongRunningTask() {
        assertEquals("Completed", taskProcessor.longRunningTask());
    }
}
