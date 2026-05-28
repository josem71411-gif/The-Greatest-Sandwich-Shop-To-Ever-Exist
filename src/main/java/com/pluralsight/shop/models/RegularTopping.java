package com.pluralsight.shop.models;

public class RegularTopping extends Topping {

    public RegularTopping(String name, boolean extra) {
        super(name, extra);
    }
    @Override
    public double getPrice(String sandwichSize) {
        return 0;
    }
}
