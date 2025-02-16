package reflection.advancedlevel.dependencyinjection;

public class Main {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();

        // Register services
        container.register(ServiceA.class);
        container.register(ServiceB.class);

        // Create App instance and inject dependencies
        App app = new App();
        container.injectDependencies(app);

        // Run the application
        app.run();
    }
}

