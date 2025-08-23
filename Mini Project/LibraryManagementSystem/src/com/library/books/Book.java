package com.library.books;

public abstract class Book {
	protected String bookId;
	protected String title;
	protected String author;
	protected boolean isBorrowed;

	public static final String LIBRARY_NAME = "Central Library";
	public static final String LIBRARY_ADDRESS = "123 Main Street, City";

	public Book(String bookId, String title, String author) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.isBorrowed = false;
	}

	//Abstract 
	public abstract void displayInfo();
	public abstract void borrowBook() throws Exception;
	public abstract void returnBook() throws Exception;

	public String getBookId() {
		return bookId;
	}
}
