package personalizedmealplangenerator;

// generic method to generate a meal plan
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T meal) {
        Meal<T> mealPlan = new Meal<>();
        mealPlan.addMeal(meal);
        return mealPlan;
    }
}
