package testingbeforeaftereach;

import junit.testingbeforeaftereach.DatabaseConnection;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class DatabaseConnectionTest {

    private DatabaseConnection db;

    @BeforeEach
    public void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    public void tearDown() {
        db.disconnect();
    }

    // Test if connection is established
    @Test
    public void testConnectionEstablished() {
        assertTrue(db.isConnected());
    }

    // Test if connection is closed after test
    @Test
    public void testConnectionClosed() {
        db.disconnect();
        assertFalse(db.isConnected());
    }
}
