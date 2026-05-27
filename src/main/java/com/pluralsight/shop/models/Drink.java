package com.pluralsight.shop.models;

public class Drink implements OrderItem{
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }
    @Override
    public double getPrice() {
        if (size.equalsIgnoreCase("Small")){
            return 2.00;
        } else if (size.equalsIgnoreCase("Medium")) {
            return 2.50;
        } else if (size.equalsIgnoreCase("large")) {
            return 3.00;
        }
        return 0;
    }
    @Override
    public String getDetails() {
        return size + " " +
                flavor +
                "drink - $" +
                String.format("%.2f",getPrice());
    }
}
