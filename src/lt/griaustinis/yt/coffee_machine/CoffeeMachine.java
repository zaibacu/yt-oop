package lt.griaustinis.yt.coffee_machine;

public class CoffeeMachine {
    public static Drink espresso(int sugar) {
        return Drink.builder()
                .addIngredient(new Espresso(25))
                .addIngredient(new Sugar(sugar))
                .build();
    }

    public static Drink cafeLatte(int sugar) {
        return Drink.builder()
                .addIngredient(new Espresso(25))
                .addIngredient(new Milk(100, true))
                .addIngredient(new Sugar(sugar))
                .build();
    }
}
