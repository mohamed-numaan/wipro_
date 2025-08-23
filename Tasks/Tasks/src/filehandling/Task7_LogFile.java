package filehandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task7_LogFile {

    public static void main(String[] args) {
        // Format: [2025-08-01 10:23:45]
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        String logMessage = "[" + timestamp + "] Application started";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("app.log", true))) {
            writer.write(logMessage);
            writer.newLine();
            System.out.println("Log entry added to app.log");
        } catch (IOException e) {
            System.out.println("Failed to write to log file: " + e.getMessage());
        }
    }
}
