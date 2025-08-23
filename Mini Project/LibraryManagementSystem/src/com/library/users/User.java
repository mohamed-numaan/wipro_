package com.library.users;

import com.library.books.Book;

public class User {
	private String userId;
	private String name;

	public User(String userId, String name) {
		this.userId = userId;
		this.name = name;
	}

	public void borrow(Book book) {
		try {
			book.borrowBook();
		} catch (Exception e) {
			System.out.println("Error borrowing: " + e.getMessage());
		}
	}

	public void returnBook(Book book) {
		try {
			book.returnBook();
		} catch (Exception e) {
			System.out.println("Error returning: " + e.getMessage());
		}
	}

	public String getName() {
		return name;
	}
}
