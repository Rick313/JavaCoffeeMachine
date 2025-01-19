
# Let's build a coffee machine !

<img style="width:50%" alt="Coffee cup" src="https://img.freepik.com/vecteurs-premium/coupe-cafe-flottante-haricots-illustration-vectorielle-dessin-anime-concept-conception-article-boisson_1019772-9800.jpg?semt=ais_hybrid">

## Context 
It's been a while since I've done Java. 
The goal is to recreate a small application as quickly 
as possible with best practices. I really like coffee, 
so the goal is to create a small coffee machine. 
This is an exercise that I had already done to learn 
Kotlin. It covers basic concepts, input, output, 
error handling, etc.

If you read this code. I hope you will like it. 
Open to pull requests and issues. I will try to answer 
you asap.

---

## Spec
What exactly do we want ?
With what technical constraints ?

To begin, we need to create a simple application. Try not 
to start a project with N dependencies. Java offers a 
large number of features. Let's try using them before 
looking for a third-party library.

The coffee machine must:
  - Store supplies (cups, water, milk, beans)
  - Store drinks (espresso, late, cappuccino)
  - Store money
  - Fill supplies (cups, water, milk, beans)
  - Being able to make coffee
  - Sell coffee
  - Provide information about its health (supplies, money, cups)
  - Notify in case of unavailability (Not enough supply).

---

## Tour of project

Let's dive into the project
 - Entry point of application : Application.java
 - Features : coffee_machine/*
 - Utilities : utils/*

The coffee_machine package brings together all the 
features of coffee_machine.

For this project, I decided to adopt a “strategy pattern”.
The AbstractCoffeeMachine class represents everything
the functionalities of the machine. Here I opted for a
command line application (CoffeeMachineCli). But
nothing stops you from creating a policy so that this application
works via another medium (eg: CoffeeMachineWebAPI).

To start the application : 
If you use Eclipse or Intellij, I think you will have no 
problem starting the application.
But if you doesn't use it.  
 1. Make sure you have Java installed on your machine
 2. Run this command :

    ```shell
    # In root folder.
    $ javac  -sourcepath . -d ./out/ Application.java
    $ cd out
    $ java Application
    ```

---

Thanks for reading.

Author : RAFAIDEEN Richard






