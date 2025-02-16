package reflection.advancedlevel.customloggingproxy;

public class Main {
    public static void main(String[] args) {
        // Create original object
        Greeting original = new GreetingImpl();

        // Create a logging proxy
        Greeting proxy = LoggingProxy.createProxy(original, Greeting.class);

        // Invoke method through proxy
        System.out.println(proxy.sayHello("Harshit"));
    }
}
