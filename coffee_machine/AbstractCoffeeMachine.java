package coffee_machine;

import coffee_machine.supply.Supply;
import coffee_machine.drink.Drink;
import java.util.List;

/**
 * Class representing THE machine !
 */
public abstract class AbstractCoffeeMachine {
    protected double coins = 500.00;
    protected int cups = 14;
    protected Supply supply = new Supply(400, 540, 120);
    protected List<Drink> drinks = List.of();

    public AbstractCoffeeMachine(List<Drink> drinks) {
        this.drinks = drinks;
    }

    /**
     * "Entry point" it allows you to launch the machine! ☕
     */
    public abstract void menu();

    /**
     * Method to buy a coffee
     */
    protected abstract void buy();

    /**
     * Method to show all infos of THE machine
     */
    protected abstract void infos();

    /**
     * Redo the supply
     */
    protected abstract void fill();

    /**
     * Take all money
     */
    protected abstract void take();

    /**
     * Prepare coffee if they are enough supplies available
     * @param drink
     */
    protected void prepare(Drink drink) {
        String errorMessage = "Not enough %1$s.";
        if(cups < 1)                          throw new CoffeeMachineError(String.format(errorMessage, "cups"));
        if(supply.water < drink.recipe.water) throw new CoffeeMachineError(String.format(errorMessage, "water"));
        if(supply.milk < drink.recipe.milk)   throw new CoffeeMachineError(String.format(errorMessage, "milk"));
        if(supply.beans < drink.recipe.beans) throw new CoffeeMachineError(String.format(errorMessage, "beans"));
        coins += drink.price;
        cups -= 1;
        supply.water -= drink.recipe.water;
        supply.milk -= drink.recipe.milk;
        supply.beans -= drink.recipe.beans;
    }
}
