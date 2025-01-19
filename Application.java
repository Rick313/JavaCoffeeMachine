import coffee_machine.*;
import coffee_machine.drink.Drink;
import coffee_machine.supply.Supply;

import java.util.List;

public class Application {
        public static void main(String[] _args) {
            System.out.println("Coffee machine started");
            final List<Drink> drinks = List.of(
                    new Drink("espresso",  0.45, new Supply(250, 0, 16)),
                    new Drink("late",      0.45, new Supply(350, 75, 20)),
                    new Drink("cappuccino",1.10, new Supply(200, 10, 12))
            );
            final AbstractCoffeeMachine machine = new CoffeeMachineCli(drinks);
            try {
                machine.menu();
            } catch (CoffeeMachineError error) {
                System.out.println(error.getMessage());
                machine.menu();
            }
        }
}
