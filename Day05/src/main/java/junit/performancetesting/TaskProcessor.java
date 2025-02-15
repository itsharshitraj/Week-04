package junit.performancetesting;

public class TaskProcessor {
    public String longRunningTask() {
        try {
           // Thread.sleep(3000); // Simulating delay of 3 seconds it will fail
            Thread.sleep(1500); //1.5 seconds test pass
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Completed";
    }
}
