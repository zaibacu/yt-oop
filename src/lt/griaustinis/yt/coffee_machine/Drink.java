package lt.griaustinis.yt.coffee_machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Drink {
    private List<Ingredient> ingredients;

    private Drink(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return String.format("My coffee: %s", String.join(
                ", ",
                ingredients
                        .stream()
                        .map(Objects::toString)
                        .collect(Collectors.toList())));
    }

    public static class Builder {
        private List<Ingredient> ingredients = new ArrayList<>();

        public Builder addIngredient(Ingredient ingredient){
            ingredients.add(ingredient);

            return this;
        }

        public Drink build() {
            return new Drink(ingredients);
        }
    }
}
