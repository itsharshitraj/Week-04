package personalizedmealplangenerator;

public class Main {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegetarianPlan = MealPlanGenerator.generateMealPlan(new VegetarianMeal());
        Meal<VeganMeal> veganPlan = MealPlanGenerator.generateMealPlan(new VeganMeal());

        System.out.println("Personalized Meal Plans:");
        vegetarianPlan.displayMeals();
        veganPlan.displayMeals();
    }
}
