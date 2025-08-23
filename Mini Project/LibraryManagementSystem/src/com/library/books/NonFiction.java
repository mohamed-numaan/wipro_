package com.library.books;

public class NonFiction extends Book implements Borrowable {
    public NonFiction(String bookId, String title, String author) {
        super(bookId, title, author);
    }

    @Override
    public void displayInfo() {
        System.out.println("Non-Fiction Book: " + title + " by " + author + " (ID: " + bookId + ")");
    }

    @Override
    public void borrowBook() throws Exception {
        if (isBorrowed) {
            throw new Exception("Book already borrowed!");
        }
        isBorrowed = true;
        System.out.println(title + " borrowed successfully.");
    }

    @Override
    public void returnBook() throws Exception {
        if (!isBorrowed) {
            throw new Exception("Book was not borrowed!");
        }
        isBorrowed = false;
        System.out.println(title + " returned successfully.");
    }
}
