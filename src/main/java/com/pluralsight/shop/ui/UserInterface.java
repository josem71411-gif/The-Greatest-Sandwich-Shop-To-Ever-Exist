package com.pluralsight.shop.ui;
import com.pluralsight.shop.filemanagement.ReceiptFileManager;
import com.pluralsight.shop.models.*;
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
            System.out.println("2) View Receipts");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            int choice =
                    Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                currentOrder = new Order();
                displayOrderScreen();
            } else if (choice == 2) {
                receiptFileManager.displayReceipts();
            } else if (choice == 0) {
                running = false;
                System.out.println("WOW YOU DONT WANT OUR FOOD?!?!?");

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

        String size = "";
        while (true) {
            System.out.print("Select size: 4, 8, or 12: ");
            size = scanner.nextLine();
            if (size.equals("4") ||
                    size.equals("8") ||
                    size.equals("12")) {
                break;
            }
            System.out.println("Invalid Bread selection");
        }

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
                "Add Meat? Waygu Steak, Ham, Salami, Roast Beef, Chicken, Bacon, or done: ");

        String meat = scanner.nextLine();

        if (meat.equalsIgnoreCase("done")) {
            break;
        }

        System.out.print("Extra meat? yes/no: ");
        boolean extra =
                scanner.nextLine()
                        .equalsIgnoreCase("yes");

        sandwich.addTopping(
                new Meat(meat,extra));
        }
    }
    private void addCheeses(Sandwich sandwich) {
        while (true) {
            System.out.print("Add Cheese? American, Pule from Serbia, Provolone, Cheddar, Swiss, or done:  ");

            String cheese = scanner.nextLine();

            if (cheese.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Extra cheese? yes/no: ");

            boolean extra = scanner.nextLine().equalsIgnoreCase("Yes");

            sandwich.addTopping(new Cheese(cheese, extra));
        }
    }
    private void addRegularToppings(Sandwich sandwich) {
        while(true) {
            System.out.print("Add Toppings? Banana peppers, Lettuce, Red Peppers, Green Peppers, Onion, Tomatoes, Jalapenos, Cucumber, Mushrooms, or done: ");

            String topping = scanner.nextLine();

            if (topping.equalsIgnoreCase("done")){
                break;
            }

            sandwich.addTopping( new RegularTopping(topping, false));
        }
    }

    private void addSauces(Sandwich sandwich) {
        while(true) {
            System.out.print("Add sauce? Special sauce, Mayo, Ketchup, Ranch, Thousand islands, Vinaigrette, Chic-fil-a sauce, or done: ");
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
            System.out.print("Add side? Au jus, Caviar, or done: ");

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

        String size = "";
        while (true) {
            System.out.print("Select size: Small, Medium, large: ");
            size = scanner.nextLine();
            if (size.equals("Small") ||
                    size.equals("Medium") ||
                    size.equals("Large")) {
                break;
            }
            System.out.println("Invalid Drink selection");
        }

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

        Chip chips = new Chip(type);

        currentOrder.addItem(chips);
        System.out.println("Chips added.");
    }
    private void checkout() {
        System.out.println("\n===== Checkout =====");

        System.out.println(currentOrder.getDetails());

        System.out.print("\nConfirm order? yes/no: ");
        String confirm = scanner.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {
            receiptFileManager.saveReceipt(currentOrder);
            System.out.println("Order Completed.");
        }  else {
            System.out.println(
                    "order canceled.");
        }
        currentOrder = null;
    }
}

