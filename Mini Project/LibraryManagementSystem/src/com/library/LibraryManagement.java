package com.library;

import com.library.books.*;
import com.library.users.User;

public class LibraryManagement {
	public static void main(String[] args) {
		System.out.println("Welcome to " + Book.LIBRARY_NAME);
		System.out.println("Located at: " + Book.LIBRARY_ADDRESS);

		Book b1 = new FictionBook("F101", "Harry Potter", "J.K. Rowling");
		Book b2 = new NonFiction("NF201", "A Brief History of Time", "Stephen Hawking");

		User user1 = new User("U001", "Alice");
		b1.displayInfo();
		b2.displayInfo();

		// Borrowing and returning
		user1.borrow(b1);
		user1.borrow(b1); 
		user1.returnBook(b1);
		user1.returnBook(b1); 

		// Borrow and return
		user1.borrow(b2);
		user1.returnBook(b2);

		// return policy
		Borrowable borrowable = (Borrowable) b1;
		borrowable.returnPolicy();
	}
}
