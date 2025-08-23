package filehandling;

import java.io.File;
import java.util.Scanner;

public class Task15_Directories {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = sc.nextLine();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null && files.length > 0) {
                System.out.println("\nContents of directory: " + path);
                for (File file : files) {
                    String type = file.isDirectory() ? "Directory" : "File";
                    long size = file.length();
                    System.out.println(file.getName() + " | Type: " + type + " | Size: " + size + " bytes");
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("Directory does not exist or is not valid.");
        }

        sc.close();
    }
}
