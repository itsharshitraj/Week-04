package testingparameterizedtests;

import junit.testingparameterizedtests.NumberUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


public class NumberUtilsTest {

    // Test even numbers (should return true)
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    public void testIsEven_WithEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number), number + " should be even");
    }

    // Test odd numbers (should return false)
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void testIsEven_WithOddNumbers(int number) {
        assertFalse(NumberUtils.isEven(number), number + " should be odd");
    }
}

