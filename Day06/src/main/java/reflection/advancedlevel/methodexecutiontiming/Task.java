package reflection.advancedlevel.methodexecutiontiming;

public class Task {
    public void quickTask() {
        System.out.println("Executing quick task...");
    }

    public void slowTask() {
        try {
            Thread.sleep(1000); // Simulate a slow method
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Executing slow task...");
    }
}
