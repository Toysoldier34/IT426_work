package launch;

import calculator.Calculator;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import userinterface.CalculatorUI;

/**
 * Controls calculator and handles the logic behind each button
 * @author Tony Thompson
 * @version 1.0
 */
public class Controller {

    private static final String DEFAULT_DISPLAY_NUMBER = "0";
    private Calculator calculator = new Calculator();

    private void appendNumber(TextField field, String number) {
        displayNewNumber(clearZero(field.getText()) + number);
    }

    private void displayNewNumber(String newNumber) {
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


    /**
     * determines type of given button then assigns the the correct event
     * @param button button to add event to
     * @param field text field display
     */
    public void setButtonEvent(Button button, TextField field) {
        String buttonText = button.getText();
        if (isNumeric(buttonText)){
            setNumberEvent(button, field);
        } else if (buttonText.equals("Enter")) {
            setEnterEvent(button, field);
        } else if (buttonText.equals("C")){
            setClearEvent(button);
        } else if (buttonText.equals("√")){
            setSqrtEvent(button, field);
        } else {
            setOperandEvent(button, field);
        }
    }

    //Adds click event to given button
    private void setNumberEvent(Button button, TextField field) {
        button.setOnAction(event -> appendNumber(field, button.getText()));
    }

    //Adds click event to given button
    private void setEnterEvent(Button button, TextField field) {
        button.setOnAction(event -> calculate(field));
    }

    //Adds click event to given button
    private void setSqrtEvent(Button button, TextField field) {
        button.setOnAction(event -> {
            setOperand("√");
            calculate(field);
        });
    }

    private void calculate(TextField field) {
        double answer = calculateAnswer(fieldNumber(field));
        setOperator(answer);
        displayNewNumber(Double.toString(answer));
    }

    //Adds click event to given button
    private void setClearEvent(Button button) {
        button.setOnAction(event -> clearDisplay());
    }

    //Adds click event to given button
    private void setOperandEvent(Button button, TextField field) {
        System.out.println(button.getText());
        button.setOnAction(event -> {
            System.out.println(button.getText());
            setOperand(button.getText());
            setOperator(field);
            clearDisplay();
        });
    }

    private void clearDisplay() {
        displayNewNumber(DEFAULT_DISPLAY_NUMBER);
    }

    private char operand() {
        return calculator.getOperand();
    }

    private void setOperand(String operand) {
        calculator.setOperand(operand.charAt(0));
    }

    private double operator() {
        return calculator.getOperator();
    }

    private void setOperator(double operator) {
        calculator.setOperator(operator);
    }

    private void setOperator(TextField field) {
        if (fieldNumber(field) != 0) { setOperator(fieldNumber(field)); }
    }

    private double fieldNumber(TextField field) {
        return Double.parseDouble(field.getText());
    }

    private double calculateAnswer(double newOperator) {
        double storedOperator = operator();
        switch (operand()) {
            case '+':  return storedOperator + newOperator;
            case '-':  return storedOperator - newOperator;
            case '*':  return storedOperator * newOperator;
            case '/':  return storedOperator / divideZeroPrevention(newOperator);
            case '√':  return Math.sqrt(newOperator);
            case '^':  return Math.pow(storedOperator, newOperator);
            case '%':  return storedOperator % newOperator;
        }
        return 0;
    }

    private double divideZeroPrevention(double newOperator) {
        if (newOperator == 0.0) { return 1.0; }
        return newOperator;
    }


    @Override
    public String toString() {
        return "This controls the calculator and defaults display to 0";
    }
}
