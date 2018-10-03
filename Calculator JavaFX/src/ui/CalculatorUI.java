package ui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CalculatorUI extends Application{


    private static final int NUM_COLS = 4;
    private static final int TOTAL_COLS = 4;
    private static final int WIN_WIDTH = 500;
    private static final int WIN_HEIGHT = 500;
    private static final int H_GAP = 10;
    private static final int V_GAP = 10;
    private static final int PADDING = 40;
    public static final int BUTTON_SMALL = 1;
    public static final int COL_WIDTH = 40;


    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(assembleScene());
        primaryStage.setTitle("Mathless Calculator");
        primaryStage.show();
    }

    private Scene assembleScene() {
        GridPane panel = new GridPane();
        setPanelStyle(panel);
        columnConstraints(panel);
        createButtons(panel);
        createTextArea(panel);
        return new Scene(panel, WIN_WIDTH, WIN_HEIGHT);
    }

    //Panel Style
    private void setPanelStyle(GridPane panel) {
        panel.setHgap(H_GAP);
        panel.setVgap(V_GAP);
        //panel.setGridLinesVisible(true);
        panel.setPadding(new Insets(PADDING));
    }

    //Column Constraints
    private void columnConstraints(GridPane panel) {
        ObservableList<ColumnConstraints> columns = panel.getColumnConstraints();
        for (int i = 0; i < TOTAL_COLS; i++)
        {
            columns.add(new ColumnConstraints(COL_WIDTH));
        }
    }


    private void createTextArea(GridPane panel) {
        TextField field = new TextField();
        panel.add(field, 0, 4, 4, 1);
    }


    //Create Buttons
    private void createButtons(GridPane panel) {
        //createNumberButtons(panel);
        //other buttons here
        String[] buttonLabels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "0", null, null, "/"
        };
        for (int i = 0; i < buttonLabels.length-1; i++) {
            addNewButton(panel, newButton(buttonLabels[i]), i);
        }

        addNewButton(panel, newButton("Enter"), 13);
    }

    private Button newButton(String text) {
        return (text != null) ? new Button(""+text) : null;
    }


    private void createNumberButtons(GridPane panel) {
        for (int i = 0; i < 10; i++ ) {
            int displayNum = Math.abs(i - 9);
            Button numberButton = new Button(""+ displayNum);
            addNewButton(panel, numberButton, i, BUTTON_SMALL, BUTTON_SMALL);
            //TODO setMaxButtonSize(numberButton);
        }
    }


    private void addNewButton(GridPane panel, Button button, int buttonPositionNum) {
        if (button != null) {  //skips large button parts
            addNewButton(panel, button, buttonPositionNum, BUTTON_SMALL, BUTTON_SMALL);
        }
    }
    private void addNewButton(GridPane panel, Button button, int buttonPositionNum, int cSpan, int rSpan) {
        panel.add(button, buttonPositionNum % TOTAL_COLS, buttonPositionNum / TOTAL_COLS, cSpan, rSpan);
//calcButtonColumn((buttonPositionNum +2) % 3)
    }

    //add 2 to num before mod

    private int calcButtonColumn(int position) {
        switch (position % NUM_COLS) {
            case 0:  return 2;
            case 1:  return 1;
            default: return 0;
        }
    }

    private void setMaxButtonSize(Button button) {
        setMaxButtonWidth(button);
        setMaxButtonHeight(button);
    }

    private void setMaxButtonWidth(Button button) {
        button.setPrefWidth(Double.MAX_VALUE);
    }

    private void setMaxButtonHeight(Button button) {
        button.setPrefHeight(Double.MAX_VALUE);
    }


/*
    private void test() {
        testArray =
        //TODO add code that manually builds calc, can reduce later
        //TODO create 2d array with strings of numbers
        //TODO add button class

                ["text", ]
        addNewButton();
    }
*/


}
