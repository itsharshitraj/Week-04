package annotations.exercise;

// Class with an old method
class LegacyAPI {

    // Marking the old method as deprecated
    @Deprecated
    void oldFeature() {
        System.out.println("This is the old feature. Please use newFeature() instead.");
    }

    // New recommended method
    void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}
public class Exercise2 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature(); // show a warning
        api.newFeature(); // preferred method
    }
}
