package com.example.hackathon_tanyinghua;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> books;
    private Map<String, User> users;
    private User currentUser;

    public Library() {
        books = new ArrayList<>();
        users = new HashMap<>();
    }

    public void addUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            currentUser = user;
            return true;
        }
        return false;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                currentUser.borrowBook(book);
                return true;
            }
        }
        return false;
    }
    public List<Book> searchBooks(String keyword) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    public void removeBook(String isbn) {
        Book bookToRemove = books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Removed book: " + bookToRemove.getTitle());
        } else {
            System.out.println("No book found with ISBN: " + isbn);
        }
    }

    // Enhanced checkOutBook with detailed feedback
    public void checkOutBook(String isbn) {
        Book book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        if (book == null) {
            System.out.println("No book found with ISBN: " + isbn);
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("Book is already checked out.");
            return;
        }
        book.setAvailability(false);
        System.out.println("Book checked out successfully: " + book.getTitle());
    }

    // Enhanced returnBook with detailed feedback
    public void returnBook(String isbn) {
        Book book = books.stream()
                .filter(b -> b.getIsbn().equals(isbn) && !b.isAvailable())
                .findFirst()
                .orElse(null);
        if (book == null) {
            System.out.println("This book is not checked out or does not exist.");
            return;
        }
        book.setAvailability(true);
        System.out.println("Book returned successfully: " + book.getTitle());
    }
}

