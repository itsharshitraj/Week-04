package junit.testingbeforeaftereach;

public class DatabaseConnection {

    private boolean isConnected;

    // Simulate database connection
    public void connect() {
        isConnected = true;
        System.out.println("Database connected.");
    }

    // Simulate closing database connection
    public void disconnect() {
        isConnected = false;
        System.out.println("Database disconnected.");
    }

    public boolean isConnected() {
        return isConnected;
    }
}
