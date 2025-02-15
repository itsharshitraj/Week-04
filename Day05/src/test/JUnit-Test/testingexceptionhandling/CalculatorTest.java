package testingexceptionhandling;

import junit.testingexceptionhandling.Calculator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    // Test normal division
    @Test
    public void testDivide() {
        assertEquals(2, Calculator.divide(10, 5));
        assertEquals(-3, Calculator.divide(-9, 3));
    }

    // Test exception for division by zero
    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}

