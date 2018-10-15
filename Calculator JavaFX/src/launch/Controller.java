package launch;

import calculator.Calculator;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import userinterface.CalculatorUI;

public class Controller {


    public static final String DEFAULT_DISPLAY_NUMBER = "0";
    private Calculator calculator = new Calculator();

    public void appendNumber(TextField field, String number) {
        displayNewNumber(clearZero(field.getText()) + number);
    }

    public void displayNewNumber(String newNumber) {
        CalculatorUI.updateTextField(newNumber);
    }

    private String clearZero(String currentField){
        if (currentField.equals("0")) {
            currentField = "";
        }
        return currentField;
    }


    private static boolean isNumeric(String strNum) {
        try {
            Double.parseDouble(strNum);
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }


    public void setButtonEvent(Button button, TextField field) {
        String buttonText = button.getText();
        if (buttonText.equals("Enter")){
            setEnterEvent(button, field);
        } else if (isNumeric(buttonText)) {
            setNumberEvent(button, field);
        } else {
            setOperandEvent(button, field);
        }
    }

    //Adds click event to given button
    private void setNumberEvent(Button button, TextField field) {
        button.setOnAction(event -> {
            appendNumber(field, button.getText());
        });
    }

    //Adds click event to given button
    private void setEnterEvent(Button button, TextField field) {
        button.setOnAction(event -> {
            double answer = calculateAnswer(fieldNumber(field));
            System.out.println("Answer: " + answer + " | getOperator:" + calculator.getOperator() + " | field.getText:" + field.getText());
            setOperator(answer);
            displayNewNumber(Double.toString(answer));
        });
    }

    //Adds click event to given button
    private void setOperandEvent(Button button, TextField field) {
        button.setOnAction(event -> {
            setOperand(button.getText());
            setOperator(field);
            displayNewNumber(DEFAULT_DISPLAY_NUMBER);
        });
    }

    private void setOperand(String operand) {
        calculator.setOperand(operand.charAt(0));
    }

    private void setOperator(TextField field) {
        setOperator(fieldNumber(field));
    }

    private double fieldNumber(TextField field) {
        return Double.parseDouble(field.getText());
    }

    private char operand() {
        return calculator.getOperand();
    }

    public double operator() {
        return calculator.getOperator();
    }

    private void setOperator(double operator) {
        calculator.setOperator(operator);
    }

    public double calculateAnswer(double newOperator) {
        double storedOperator = operator();
        switch (operand()) {
            case '+':  return storedOperator + newOperator;
            case '-':  return storedOperator - newOperator;
            case '*':  return storedOperator * newOperator;
            case '/':  return storedOperator / divideZeroPrevention(newOperator);
        }
        return 0;
    }

    private double divideZeroPrevention(double newOperator) {
        if (newOperator == 0.0) return 1.0;
        return newOperator;
    }


}
