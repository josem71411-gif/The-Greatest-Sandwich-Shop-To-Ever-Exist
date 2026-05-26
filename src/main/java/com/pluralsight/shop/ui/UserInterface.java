package com.pluralsight.shop.ui;
import com.pluralsight.shop.filemanagement.ReceiptFileManager;
import com.pluralsight.shop.models.Chip;
import com.pluralsight.shop.models.Drink;
import com.pluralsight.shop.models.Order;
import com.pluralsight.shop.models.Sandwich;
import com.pluralsight.shop.toppings.RegularTopping;
import com.pluralsight.shop.toppings.Sauce;
import com.pluralsight.shop.toppings.Side;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    private Order currentOrder;

    private ReceiptFileManager receiptFileManager = new ReceiptFileManager();

    public void display() {
        boolean running = true;
        while(running) {
            System.out.println("\n===== Worlds Greatest Deli =====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("Choose an option: ");

            int choice =
                    Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                currentOrder = new Order();
                displayOrderScreen();
            } else if (choice == 0) {
                running = false;
                System.out.println("Goodbye!");

            }

        }
    }
    private void displayOrderScreen() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("\n===== Build Your Worlds Greatest Sandwich =====");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("Choose an Option: ");

            int choice =
                    Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                addSandwich();
            } else if (choice == 2) {
                addDrink();

            } else if (choice == 3) {
                addChips();
            } else if (choice == 4) {
                checkout();
                ordering = false;
            } else if (choice == 0) {
                currentOrder = null;
                ordering=false;
                System.out.println("Order Canceled");

            }
        }
    }

    private void addSandwich() {
        System.out.println("\n===== Add Sandwich =====");

        System.out.print("Select Bread: White, Wheat, Rye, Wrap: ");

        String bread = scanner.nextLine();
        System.out.print("Select Size: 4 Inch, 8 Inch, or 12 Inch: ");

        String size = scanner.nextLine();

        System.out.print("Would you like it toasted? yes/no: ");

        boolean toasted =
                scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        addMeats(sandwich);
        addCheeses(sandwich);
        addRegularToppings(sandwich);
        addSauces(sandwich);
        addSides(sandwich);

        currentOrder.addItem(sandwich);
        System.out.print("Sandwich added.");
}
private void addMeats(Sandwich sandwich){

    while(true) {
        System.out.print(
                "Add Meat? steak, ham, salami, roast beef, chicken, bacon, or done: ");

        String meat = scanner.nextLine();

        if (meat.equalsIgnoreCase("done")) {
            break;
        }

        System.out.print("Extra meat? yes/no");
        boolean extra =
                scanner.nextLine()
                        .equalsIgnoreCase("yes");

        sandwich.addTopping(
                new Meat(meat,extra));
        }
    }
    private void addCheeses(Sandwich sandwich) {
        while (true) {
            System.out.print("Add Cheese? american, provolone, cheddar, swiss, or done:  ");

            String cheese = scanner.nextLine();

            if (cheese.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Extra cheese? yes/no: ");

            boolean extra = scanner.nextLine().equalsIgnoreCase("Yes");

            boolean extra = scanner.nextLine().equalsIgnoreCase("yes");

            sandwich.addTopping(new Cheese(cheese, extra));
        }
    }
    private void addRegularToppings(Sandwich sandwich) {
        while(true) {
            System.out.print("Add Topppings? lettuce, peppers, onion, tomatoes, jalapenos, cucumber, pickkles, guacamole, mushrooms, or done: ");

            String topping = scanner.nextLine();

            if (topping.equalsIgnoreCase("done")){
                break;
            }

            sandwich.addTopping( new RegularTopping(topping, false));
        }
    }

    private void addSauces(Sandwich sandwich) {
        while(true) {
            System.out.print("Add sauce? mayo, ketchup, ranch, thousand islands, vinaigrette, or done: ");
            String sauce = scanner.nextLine();

            if (sauce.equalsIgnoreCase("done")) {
                break;
            }
            sandwich.addTopping(
                    new Sauce(sauce, false));
        }
    }
    private void addSides(Sandwich sandwich) {
        while(true) {
            System.out.print("Add side? au jus, sauce, or done: ");

            String side =
                    scanner.nextLine();
            if (side.equalsIgnoreCase("done")){
                break;
            }
            sandwich.addTopping(
                    new Side(side,false));
        }
    }
    private void addDrink() {
        System.out.println("\n===== Add Drink =====");

        System.out.print("Drink size? small, medium, large: ");
        String size = scanner.nextLine();

        System.out.print("Drink Flavor? ");
        String flavor = scanner.nextLine();

        Drink drink = new Drink(size, flavor);
        currentOrder.addItem(drink);
        System.out.println("Drink added.");
    }
    private void addChips() {
        System.out.println("\n===== Add Chips =====");
        System.out.print("Chip type? ");

        String type = scanner.nextLine();

        Chips chips = new Chips(type);

        currentOrder.addItem(chips);
        System.out.println("Chips added.");
    }
    private void checkout() {
        System.out.println("\n===== Checkout =====");

        System.out.println(currentOrder.getDetails());

        System.out.print("\nConfirm order? yes/no: ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            receiptFileManager.saveReceipt(currentorder);
            System.out.println("Order Completed.");
        }  else {
            System.out.println(
                    "order canceled.");
        }
        currentOrder = null;
    }
}

