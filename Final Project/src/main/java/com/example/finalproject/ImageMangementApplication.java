package com.example.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ImageMangementApplication extends Application {

    // This method starts the application by initializing the GUI for an image management tool.
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file containing the GUI layout
        FXMLLoader fxmlLoader = new FXMLLoader(ImageMangementApplication.class.getResource("hello-view.fxml"));
        // Create a new stage to display the GUI
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800); // Set the size of the scene
        stage.setTitle("Image Management Tool"); // Set the title of the stage
        stage.setScene(scene); // Set the scene to the stage
        stage.show(); // Show the stage
    }

    // The main method that launches the application.
    public static void main(String[] args) {
        launch(); // Launch the application
    }
}
