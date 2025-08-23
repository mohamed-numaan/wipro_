package com.library.books;

public interface Borrowable {
	void borrowBook() throws Exception;
	void returnBook() throws Exception;

	// Default method
	default void returnPolicy() {
		System.out.println("Return Policy: Books must be returned within 14 days.");
	}
}
