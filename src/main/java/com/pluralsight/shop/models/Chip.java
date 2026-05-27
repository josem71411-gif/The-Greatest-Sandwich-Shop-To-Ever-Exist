package com.pluralsight.shop.models;

public class Chip implements OrderItem{

    private String type;

    public Chip(String type) {
        this.type=type;
    }
    @Override
    public double getPrice() {
        return 1.50;
    }
    @Override
    public String getDetails() {
        return type +
                " chips - $" +
                String.format("%.2f", getPrice());
    }

}
