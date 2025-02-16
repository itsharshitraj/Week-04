package reflection.advancedlevel.jsonrepresentation;

public class Main {
    public static void main(String[] args) {
        User user = new User("Harshit", 25);
        String json = JsonConverter.toJson(user);
        System.out.println(json);
    }
}
