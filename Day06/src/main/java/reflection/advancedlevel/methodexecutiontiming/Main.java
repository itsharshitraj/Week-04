package reflection.advancedlevel.methodexecutiontiming;

public class Main {
    public static void main(String[] args) {
        Task task = new Task();

        // Measure execution time for different methods
        MethodTimer.measureExecutionTime(task, "quickTask");
        MethodTimer.measureExecutionTime(task, "slowTask");
    }
}

