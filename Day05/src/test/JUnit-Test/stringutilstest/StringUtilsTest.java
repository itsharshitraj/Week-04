package stringutilstest;
import static org.junit.jupiter.api.Assertions.*;
import junit.stringutils.StringUtils;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    // Test reverse method
    @Test
    public void testReverse() {
        assertEquals("olleh", StringUtils.reverse("hello"));
        assertEquals("avaJ", StringUtils.reverse("Java"));
        assertEquals("", StringUtils.reverse(""));
        assertNull(StringUtils.reverse(null));
    }

    // Test isPalindrome method
    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));
        assertTrue(StringUtils.isPalindrome("Racecar")); // Case insensitive check
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome(null));
    }

    // Test toUpperCase method
    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));
        assertEquals("JAVA", StringUtils.toUpperCase("Java"));
        assertEquals("", StringUtils.toUpperCase(""));
        assertNull(StringUtils.toUpperCase(null));
    }
}
