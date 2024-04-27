package com.example.hackathon_tanyinghua;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private Library library;

    @Override
    public void start(Stage primaryStage) {
        library = new Library();
        library.addBook(new Book("Java Fundamentals", "John Doe", "Education", "1234567890"));
        library.addUser("admin", "admin123");

        VBox root = new VBox(10);
        TextField titleField = new TextField();
        TextField authorField = new TextField();
        TextField genreField = new TextField();
        TextField isbnField = new TextField();
        Button btnAddBook = new Button("Add Book");
        Button btnBorrowBook = new Button("Borrow Book");
        ListView<String> booksList = new ListView<>();

        btnAddBook.setOnAction(event -> {
            Book book = new Book(titleField.getText(), authorField.getText(), genreField.getText(), isbnField.getText());
            library.addBook(book);
            booksList.getItems().add(book.getTitle() + " by " + book.getAuthor());
        });

        btnBorrowBook.setOnAction(event -> {
            if (library.borrowBook(isbnField.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book borrowed successfully!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Book could not be borrowed!");
                alert.showAndWait();
            }
        });

        root.getChildren().addAll(new Label("Title:"), titleField,
                new Label("Author:"), authorField,
                new Label("Genre:"), genreField,
                new Label("ISBN:"), isbnField,
                btnAddBook, btnBorrowBook, booksList);

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

