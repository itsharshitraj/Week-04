package testingpasswordstrengthvalidator;
import junit.testingpasswordstrengthvalidator.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValidPassword("Strong1Pass"));
    }

    @Test
    void testShortPassword() {
        assertFalse(PasswordValidator.isValidPassword("Short1"));
    }

    @Test
    void testNoUpperCase() {
        assertFalse(PasswordValidator.isValidPassword("lowercase1"));
    }

    @Test
    void testNoDigit() {
        assertFalse(PasswordValidator.isValidPassword("NoDigitHere"));
    }

    @Test
    void testNullPassword() {
        assertFalse(PasswordValidator.isValidPassword(null));
    }

    @Test
    void testEmptyPassword() {
        assertFalse(PasswordValidator.isValidPassword(""));
    }
}

