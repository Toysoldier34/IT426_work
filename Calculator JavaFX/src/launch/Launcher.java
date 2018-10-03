package launch;

import javafx.application.Application;
import userinterface.CalculatorUI;

/**
 * Launcher for Calculator program
 * @author Tony Thompson
 * @version 1.0
 */
public class Launcher {
    /**
     * Main method to launch Calculator
     * @param args no parameters
     */
    public static void main(String[] args) {
        Application.launch(CalculatorUI.class, args);
    }

}
