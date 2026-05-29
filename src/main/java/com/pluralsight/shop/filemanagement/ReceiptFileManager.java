package com.pluralsight.shop.filemanagement;
import com.pluralsight.shop.models.Order;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReceiptFileManager {
    public void saveReceipt(Order order) {
        try {
            File folder = new File("receipts");

            if (!folder.exists()) {
                folder.mkdir();
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
            String fileName = order.getOrderDateTime().format(formatter) + ".txt";

            FileWriter writer = new FileWriter("receipts/" + fileName);

            writer.write(order.getDetails());

            writer.close();

            System.out.println("Receipt saved to receipts/." + fileName);
        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }

    public void displayReceipts() {
        File folder = new File("receipts");
        if (!folder.exists()) {
            System.out.print("No receipts found.");
            return;
        }
        File[] receipts = folder.listFiles();
        if (receipts == null || receipts.length == 0) {
            System.out.print("No receipts found. ");
            return;
        }
        System.out.println("\n===== Receipts ======");
        for (int i = 0; i < receipts.length; i++) {
            System.out.println((i + 1) + ") " + receipts[i].getName());
        }
        System.out.print("Choose receipt number to view");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice < 1 || choice > receipts.length) {
            System.out.println("Invalid receipt number.");
            return;
        }
        File selectedReceipt = receipts[choice - 1];
        try {
            Scanner fileScanner = new Scanner(selectedReceipt);
            System.out.println("\n===== Receipt Details =====");

            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("Error reading receipt.");
        }
    }
}