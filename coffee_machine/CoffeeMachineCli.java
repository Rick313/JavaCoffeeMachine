package coffee_machine;

import coffee_machine.drink.Drink;
import utils.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachineCli extends AbstractCoffeeMachine {
    Scanner scanner = new Scanner(System.in);
    public CoffeeMachineCli(List<Drink> drinks) {
        super(drinks);
    }

    @Override
    public void menu() {
        System.out.println("What do you want ?");
        List<String> actions = List.of("1) buy", "2) infos", "3) fill", "4) take", "5) quit");
        actions.forEach(System.out::println);
        String action = scanner.next();
        if(!action.equals(")")) {
            for (int i = 0; i < actions.size(); i++) {
                String element = actions.get(i);
                if (!element.contains(action)) continue;
                switch (i) {
                    case 0 : buy(); return;
                    case 1 : infos(); return;
                    case 2 : fill(); return;
                    case 3 : take(); return;
                    case 4 : quit(); return;
                }
            }
        }
        System.out.println("I don't understand what you need");
        menu();
    }

    @Override
    protected void buy() {
        ArrayList<Pair<String, Drink>> choices = new ArrayList<>();
        for(int i = 0; i < drinks.size(); i++) {
            Drink drink = drinks.get(i);
            String choiceLabel = (i+1) + ") " + drink.name;
            System.out.println(choiceLabel);
            choices.add(new Pair<>(choiceLabel, drink));
        }
        String backLabel = choices.size() +1 + ") back";
        System.out.println(backLabel);

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if(!choice.equals(")")) {
            if(backLabel.contains(choice)) {
                menu();
                return;
            }
            for (Pair<String, Drink> pair : choices) {
                if (pair.first.contains(choice)) {
                    prepare(pair.second);
                    System.out.println("Your drink is ok.");
                    menu();
                    return;
                }
            }
        }
        System.out.println("I don't understand what you need");
        buy();
    }

    @Override
    protected void infos() {
        System.out.println("Drink available.");
        drinks.forEach((drink -> { System.out.println(" - " + drink.name); }));
        System.out.println("Cups available: " + cups + ".");
        System.out.println("Water available: " + supply.water + "ml.");
        System.out.println("Milk available: " + supply.milk + "ml.");
        System.out.println("Beans available: " + supply.beans + ".");
        System.out.println("Money: " + coins + "$.");
        menu();
    }

    @Override
    protected void fill() {
        List<String> elements = List.of("cups", "water", "milk", "beans");
        for(String el: elements) {
            System.out.print("How many " + el + " do you want to add ? ");
            int num = scanner.nextInt();
            if(num < 0) throw new CoffeeMachineError("Number of" + num + " should be greater than or equal to 0.");
            if(el.equals("cups")) cups += num;
            if(el.equals("water")) supply.water += num;
            if(el.equals("milk")) supply.milk += num;
            if(el.equals("beans")) supply.beans += num;
        }
        menu();
    }

    @Override
    protected void take() {
        System.out.println("Money took " + coins + ".");
        coins = 0;
        menu();
    }

    /**
     * Quit cli
     */
    private void quit() {
        scanner.close();
        System.out.println("Bye !");
    }
}

