package ecommerce;

import java.io.*;
import java.util.Scanner;

public class FileManager {

    private static final String FILE_NAME = "orders.txt";

    public static void saveOrder(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Customer: " + order.getCustomer().getName() +
                         " | Email: " + order.getCustomer().getEmail() + "\n");

            for (Product p : order.getProducts()) {
                writer.write("Product: " + p.getName() + " | ID: " + p.getId() +
                             " | Price: ₹" + p.getPrice() + "\n");
            }

            writer.write("Total: ₹" + order.getTotalAmount() + "\n");
            writer.write("Status: " + (order.isCancelled() ? "Cancelled" : "Confirmed") + "\n");
            writer.write("----------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readOrders() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n📄 Saved Orders:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No previous orders found.");
        }
    }

    public static void cancelOrderByEmail(String customerEmail) {
        File inputFile = new File(FILE_NAME);
        File tempFile = new File("temp_orders.txt");

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
             Scanner sc = new Scanner(System.in)) {

            String line;
            boolean skip = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Email: " + customerEmail)) {
                    System.out.print("Are you sure you want to cancel the order for " + customerEmail + "? (yes/no): ");
                    String confirm = sc.nextLine().trim().toLowerCase();

                    if (confirm.equals("yes")) {
                        found = true;
                        skip = true;
                        // Skip lines until separator
                        while ((line = reader.readLine()) != null && !line.equals("----------")) {}
                        continue;
                    }
                }

                if (!skip) {
                    writer.write(line);
                    writer.newLine();
                }

                if (line.equals("----------")) {
                    skip = false;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Replace original file
        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
        }

        if (found) {
            System.out.println("✅ Order cancelled and removed from file.");
        } else {
            System.out.println("❌ No order found for the given email.");
        }
    }
}
