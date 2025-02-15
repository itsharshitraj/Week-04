package testinguserregistration;
import junit.testinguserregistration.UserRegistration;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        assertEquals("User registered successfully",
                UserRegistration.registerUser("john_doe", "john@example.com", "SecureP@ss1"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("", "john@example.com", "SecureP@ss1"));

        assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser(null, "john@example.com", "SecureP@ss1"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("john_doe", "invalid-email", "SecureP@ss1"));

        assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("john_doe", "john@.com", "SecureP@ss1"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("john_doe", "john@example.com", "short"));

        assertThrows(IllegalArgumentException.class,
                () -> UserRegistration.registerUser("john_doe", "john@example.com", ""));
    }
}
