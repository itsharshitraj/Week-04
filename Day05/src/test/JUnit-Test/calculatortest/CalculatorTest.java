package calculatortest;
import static org.junit.jupiter.api.Assertions.*;
import junit.testingcalculatorclass.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    // Test addition
    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    // Test subtraction
    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    // Test multiplication
    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    // Test division
    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    // Test division by zero (Bonus)
    @Test
    public void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}


