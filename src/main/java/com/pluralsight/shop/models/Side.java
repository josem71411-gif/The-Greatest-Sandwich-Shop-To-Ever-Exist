package com.pluralsight.shop.models;

public class Side  extends Topping {
    public Side(String name, boolean extra) {
        super(name,extra);
    }
    @Override
    public double getPrice(String sandwichSize) {
        return 0;
    }
}
