package com.example.finalproject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;

public class ImageController {

    @FXML private ImageView imageView; // The ImageView to display the selected image
    @FXML private Label infoTextLabel; // Label to show information about the selected image

    @FXML private ComboBox<String> formatComboBox; // ComboBox to choose the output image format

    private File selectedImageFile; // File representing the selected image
    private File convertedImageFile; // File representing the converted image

    @FXML
    // Initializes the controller after its root element has been completely processed
    public void initialize() {
        // Populate the formatComboBox with available image formats
        formatComboBox.getItems().addAll("PNG", "JPEG", "GIF");
        // Set the default selection of the ComboBox to the first item in the list
        formatComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    // Method to handle image selection
    public void selectImage() {
        // Display a file selection dialog to choose an image file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Please Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(imageView.getScene().getWindow());
        if (selectedFile != null) {
            selectedImageFile = selectedFile;
            // Load the selected image into the ImageView
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            // Display image width and height information
            infoTextLabel.setText(String.format("Width: %.0f, Height: %.0f", image.getWidth(), image.getHeight()));
        }
    }

    @FXML
    // Method to convert the selected image to the chosen format
    public void convertImage() {
        // Check if an image has been selected
        if (imageView.getImage() == null) {
            infoTextLabel.setText("Please select an image first.");
            return;
        }
        try {
            // Get the input file, output format, and create a new file for the converted image
            File inputFile = selectedImageFile;
            String outputFileExtension = formatComboBox.getValue().toLowerCase();
            convertedImageFile = new File(inputFile.getParent(), "new_" + inputFile.getName().split("\\.")[0] + "." + outputFileExtension);
            // Call the convert method to perform the conversion
            convert(inputFile, convertedImageFile, outputFileExtension);
            System.out.println("Image converted successfully!");
        } catch (IOException e) {
            // Handle conversion errors
            System.out.println("Warning: Image conversion failed !");
            e.printStackTrace();
        }
    }

    @FXML
    // Method to save the converted image
    public void saveImage() {
        // Check if the converted image exists
        if (convertedImageFile == null || !convertedImageFile.exists()) {
            infoTextLabel.setText("Please do image conversion first.");
            return;
        }
        // Show a file chooser dialog to choose the save location and file name
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*." + formatComboBox.getValue().toLowerCase())
        );
        fileChooser.setInitialFileName(convertedImageFile.getName());
        File saveFile = fileChooser.showSaveDialog(imageView.getScene().getWindow());
        // Rename the converted image file and show a message confirming the save
        if (saveFile != null) {
            convertedImageFile.renameTo(saveFile);
            infoTextLabel.setText("Image saved successfully.");
        }
    }

    // Method to perform the image conversion
    private static void convert(File inputFile, File outputFile, String outputFormat) throws IOException {
        BufferedImage image = ImageIO.read(inputFile); // Read the input image
        ImageIO.write(image, outputFormat, outputFile); // Write the image to the output file with the specified format
    }
}
