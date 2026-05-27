package com.pluralsight.shop.filemanagement;
import com.pluralsight.shop.models.Order;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    public void saveReceipt(Order order) {
        try {
            File folder = new File("receipts");

            if (!folder.exists()) {
                folder.mkdir();
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String fileName = order.getOrderDateTime().format(formatter)+".txt";

            FileWriter writer = new FileWriter("receipts/" + fileName);

            writer.write(order.getDetails());

            writer.close();

            System.out.println("Receipt saved.");
        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }
}
