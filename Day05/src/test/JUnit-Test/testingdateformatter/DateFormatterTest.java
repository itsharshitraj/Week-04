package testingdateformatter;
import junit.testingdateformatter.DateFormatter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateFormatterTest {

    @Test
    void testValidDateConversion() {
        assertEquals("15-02-2025", DateFormatter.formatDate("2025-02-15"));
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("15-02-2025"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("2025/02/15"));
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("invalid-date"));
    }

    @Test
    void testEmptyDateInput() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate(""));
    }
}
