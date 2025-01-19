package coffee_machine.drink;
import coffee_machine.supply.Supply;

/**
 * Data class for a drink
 */
public class Drink {
    public double price;
    public String name;
    public Supply recipe;
    public Drink(String name, double price, Supply recipe) {
        if(name.isEmpty() || name.isBlank()) throw new DrinkError("Drink name cannot be empty.");
        if(price < 0.1) throw new DrinkError("Drink price cannot be lower than 0.1");
        this.price = price;
        this.name = name;
        this.recipe = recipe;
    }
}
