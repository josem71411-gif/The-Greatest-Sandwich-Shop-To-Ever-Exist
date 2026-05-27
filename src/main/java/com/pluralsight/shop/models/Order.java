package com.pluralsight.shop.models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
public class Order {

    private ArrayList<OrderItem> items;
    private LocalDateTime orderDateTime;

    public Order() {
        items = new ArrayList<>();
        orderDateTime = LocalDateTime.now();
    }
    public void addItem(OrderItem item) {
        items.add(item);
    }
    public ArrayList<OrderItem> getItemsNewestFirst() {
        ArrayList<OrderItem> reversed =
                new ArrayList<>(items);
        Collections.reverse(reversed);
        return reversed;
    }
    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }
    public String getDetails() {
        StringBuilder details = new StringBuilder();
        details.append("===== THE WORLDS GREATEST DELI=====\n");
        details.append(orderDateTime).append("\n\n");

        for (OrderItem item : getItemsNewestFirst()) {
            details.append(item.getDetails()).append("\n");
        }
        details.append("\nTotal: $")
                .append(String.format("%.2f",getTotal()));
        return details.toString();
    }

}
