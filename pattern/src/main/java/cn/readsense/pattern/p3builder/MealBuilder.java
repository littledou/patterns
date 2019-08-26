package cn.readsense.pattern.p3builder;

public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareChickenMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }


    public static void main(String args[]) {
        MealBuilder mealBuilder = new MealBuilder();
        final Meal meal = mealBuilder.prepareVegMeal();
        meal.showItems();
    }
}
