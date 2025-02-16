package reflection.advancedlevel.dependencyinjection;

public class App {
    @Inject
    private ServiceA serviceA; // Automatically injected

    @Inject
    private ServiceB serviceB; // Automatically injected

    public void run() {
        serviceA.performTask();
        serviceB.execute();
    }
}

