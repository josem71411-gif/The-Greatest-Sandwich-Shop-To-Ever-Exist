package com.pluralsight.shop.toppings;

public class Sauce extends Topping{
    public Sauce(String name, boolean extra) {
        super(name, extra);
    }

    @Override
    public double getPrice(String sandwichSize) {
        return 0;
    }
}
