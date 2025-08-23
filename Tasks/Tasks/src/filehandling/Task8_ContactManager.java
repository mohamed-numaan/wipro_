package filehandling;

import java.io.*;
import java.util.*;

public class Task8_ContactManager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n--- Contact Manager ---");
			System.out.println("1. Add Contact");
			System.out.println("2. Display All Contacts");
			System.out.println("3. Search Contact by Name");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				addContact(scanner);
				break;
			case 2:
				displayContacts();
				break;
			case 3:
				searchContact(scanner);
				break;
			case 4:
				System.out.println("Exiting Contact Manager.");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}

		} while (choice != 4);

		scanner.close();
	}

	// 1. Add a new contact
	private static void addContact(Scanner scanner) {
		try {
			System.out.print("Enter Name: ");
			String name = scanner.nextLine();

			System.out.print("Enter Phone Number: ");
			String phone = scanner.nextLine();

			BufferedWriter writer = new BufferedWriter(new FileWriter("contacts.txt", true));
			writer.write(name + "," + phone);
			writer.newLine();
			writer.close();

			System.out.println("Contact saved successfully!");

		} catch (IOException e) {
			System.out.println("Error saving contact: " + e.getMessage());
		}
	}

	// 2. Display all contacts
	private static void displayContacts() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"));
			String line;
			System.out.println("\n--- All Contacts ---");
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					System.out.println("Name: " + parts[0] + ", Phone: " + parts[1]);
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error reading contacts: " + e.getMessage());
		}
	}

	// 3. Search by name
	private static void searchContact(Scanner scanner) {
		try {
			System.out.print("Enter name to search: ");
			String searchName = scanner.nextLine().toLowerCase();

			BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"));
			String line;
			boolean found = false;
			System.out.println("\n--- Search Results ---");
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2 && parts[0].toLowerCase().contains(searchName)) {
					System.out.println("Name: " + parts[0] + ", Phone: " + parts[1]);
					found = true;
				}
			}
			reader.close();

			if (!found) {
				System.out.println("No contact found with the name: " + searchName);
			}

		} catch (IOException e) {
			System.out.println("Error searching contact: " + e.getMessage());
		}
	}
}


