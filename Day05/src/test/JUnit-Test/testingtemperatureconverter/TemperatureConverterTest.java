package testingtemperatureconverter;
import junit.testingtemperatureconverter.TemperatureConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    private static final double DELTA = 0.01; // Precision for floating-point comparisons

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), DELTA);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), DELTA);
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40), DELTA);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), DELTA);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), DELTA);
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40), DELTA);
    }
}
