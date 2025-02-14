package personalizedmealplangenerator;

import java.util.List;
import java.util.ArrayList;

// Implement a generic class for meal handling
class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();

    public void addMeal(T meal) {
        meals.add(meal);
    }

    public void displayMeals() {
        for (T meal : meals) {
            meal.displayMeal();
        }
    }
}
