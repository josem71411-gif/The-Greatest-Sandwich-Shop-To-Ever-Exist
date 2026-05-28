package com.pluralsight.shop.models;

public class Cheese extends Topping {

    public Cheese (String name, boolean extra) {
        super(name, extra);
    }


    @Override
    public double getPrice(String sandwichSize) {

        if (sandwichSize.equals("4")){
            return isExtra()?1.05:0.75;
        } else if (sandwichSize.equals("8")) {
            return isExtra()?2.10:1.50;
        } else if (sandwichSize.equals("12")) {
            return isExtra()?3.15:2.25;
        }
        return 0;
    }
}
