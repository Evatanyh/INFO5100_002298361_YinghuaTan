package com.example.hackathon_tanyinghua;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Book> borrowedBooks;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailability(false);
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        book.setAvailability(true);
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}

