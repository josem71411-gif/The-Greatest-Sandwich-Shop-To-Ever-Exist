package com.pluralsight.shop.models;

public class Meat extends Topping {
    public Meat(String name, boolean extra) {
        super(name, extra);
    }
@Override
    public double getPrice(String sandwichSize) {
        if (sandwichSize.equals("4")){
            return isExtra() ? 1.50 :1.00;
        } else if (sandwichSize.equals("8")) {
            return isExtra() ? 3.00 : 2.00;
        } else if (sandwichSize.equals("12")) {
            return isExtra() ? 4.50 :3.00;
        }
        return 0;
    }
}
