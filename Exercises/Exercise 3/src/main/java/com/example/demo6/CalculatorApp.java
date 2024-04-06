package com.example.demo6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField display;

    private double num1 = 0;
    private double num2 = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        // Create the display TextField
        display = new TextField();
        display.setEditable(false);
        display.setPrefColumnCount(15);

        // Create the numeric buttons
        Button btn0 = new Button("0");
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");

        // Create the operator buttons
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnMultiply = new Button("*");
        Button btnDivide = new Button("/");
        Button btnEquals = new Button("=");

        // Create the clear button
        Button btnClear = new Button("C");

        // Set the event handlers for numeric buttons
        btn0.setOnAction(e -> appendNumber("0"));
        btn1.setOnAction(e -> appendNumber("1"));
        btn2.setOnAction(e -> appendNumber("2"));
        btn3.setOnAction(e -> appendNumber("3"));
        btn4.setOnAction(e -> appendNumber("4"));
        btn5.setOnAction(e -> appendNumber("5"));
        btn6.setOnAction(e -> appendNumber("6"));
        btn7.setOnAction(e -> appendNumber("7"));
        btn8.setOnAction(e -> appendNumber("8"));
        btn9.setOnAction(e -> appendNumber("9"));

        // Set the event handlers for operator buttons
        btnPlus.setOnAction(e -> handleOperator("+"));
        btnMinus.setOnAction(e -> handleOperator("-"));
        btnMultiply.setOnAction(e -> handleOperator("*"));
        btnDivide.setOnAction(e -> handleOperator("/"));
        btnEquals.setOnAction(e -> calculateResult());

        // Set the event handler for the clear button
        btnClear.setOnAction(e -> clearDisplay());

        // Create the layout grid
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10));

// Add display TextField to the first row and make it span all columns
        gridPane.addRow(0, display);
        GridPane.setColumnSpan(display, 4);

// Add buttons to subsequent rows
        gridPane.addRow(1, btn7, btn8, btn9, btnPlus);
        gridPane.addRow(2, btn4, btn5, btn6, btnMinus);
        gridPane.addRow(3, btn1, btn2, btn3, btnMultiply);
        gridPane.addRow(4, btn0, btnClear, btnEquals, btnDivide);

        // Create the scene and set it on the stage
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void appendNumber(String number) {
        if (startNewNumber) {
            display.setText(number);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + number);
        }
    }

    private void handleOperator(String op) {
        if (!startNewNumber) {
            num1 = Double.parseDouble(display.getText());
            operator = op;
            startNewNumber = true;
        }
    }

    private void calculateResult() {
        if (!startNewNumber) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    display.setText(Double.toString(num1 + num2));
                    break;
                case "-":
                    display.setText(Double.toString(num1 - num2));
                    break;
                case "*":
                    display.setText(Double.toString(num1 * num2));
                    break;
                case "/":
                    if (num2 != 0) {
                        display.setText(Double.toString(num1 / num2));
                    } else {
                        display.setText("Error");
                    }
                    break;
            }
            startNewNumber = true;
        }
    }

    private void clearDisplay() {
        display.clear();
        num1 = 0;
        num2 = 0;
        operator = "";
        startNewNumber = true;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
