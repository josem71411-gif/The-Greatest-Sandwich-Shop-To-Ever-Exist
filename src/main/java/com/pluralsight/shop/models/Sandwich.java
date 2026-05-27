package com.pluralsight.shop.models;
import com.pluralsight.shop.toppings.Topping;

import java.util.ArrayList;
public class Sandwich implements OrderItem {
    private String size;
    private String bread;
    private boolean toasted;

    private ArrayList<Topping> toppings;


    public Sandwich(String size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        toppings = new ArrayList<>();
    }
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    @Override
    public double getPrice() {
        double total = getBasePrice();
        for (Topping topping : toppings) {
            total += topping.getPrice(size);
        }
        return total;
    }
    private double getBasePrice() {
        if (size.equals("4")) {
            return 5.50;
        } else if (size.equals("8")) {
            return 7.00;
        } else if (size.equals("12")) {
            return 8.50;
        }
        return 0;
    }
    @Override
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append(size)
                .append("\" ")
                .append(bread)
                .append(" sandwich");

        if (toasted) {
            details.append(" toasted");
        }else {
            details.append(" not toasted");
        }
        details.append(" - $")
                .append(String.format("%.2f", getPrice()))
                .append("\n");
        details.append("Toppings:\n");
        for (Topping topping : toppings) {
            details.append(" - ")
                    .append(topping.getName());
            if (topping.isExtra()) {
                details.append(" extra");
            }
            details.append("\n");
        }
        return details.toString();
    }
}
