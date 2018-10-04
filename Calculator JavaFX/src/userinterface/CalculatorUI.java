package userinterface;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * This class provides a basic UI for a calculator.
 *
 * @author Tony Thompson
 * @version 1.0
 */
public class CalculatorUI extends Application{

    private static final int SCALE = 1;
    private static final int TOTAL_COLS = 4;
    private static final int WIN_WIDTH = 200 * SCALE;
    private static final int WIN_HEIGHT = 225 * SCALE;
    private static final int H_GAP = 10 * SCALE;
    private static final int V_GAP = 10 * SCALE;
    private static final int PADDING = 25 * SCALE;
    private static final int BUTTON_SMALL = 1;
    private static final int COL_WIDTH = 30 * SCALE;
    private static final String[] BUTTON_LABELS = new String[]{
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "Enter", null, "/"
    };


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

    //Setup Scene
    private Scene assembleScene() {
        GridPane panel = new GridPane();
        setPanelStyle(panel);
        columnConstraints(panel);
        createAllButtons(panel);
        return new Scene(panel, WIN_WIDTH, WIN_HEIGHT);
    }

    //Panel Style
    private void setPanelStyle(GridPane panel) {
        panel.setHgap(H_GAP);
        panel.setVgap(V_GAP);
        panel.setPadding(new Insets(PADDING));
        //panel.setGridLinesVisible(true);
    }

    //Column Constraints
    private void columnConstraints(GridPane panel) {
        ObservableList<ColumnConstraints> columns = panel.getColumnConstraints();
        for (int i = 0; i < TOTAL_COLS; i++)
        {
            columns.add(new ColumnConstraints(COL_WIDTH));
        }
    }

    //Create Text Display
    private void createTextField(GridPane panel) {
        TextField field = new TextField();
        panel.add(field, 0, 4, 4, 1);
    }


    //Create all Buttons
    private void createAllButtons(GridPane panel) {
        for (int i = 0; i < BUTTON_LABELS.length; i++) {
            setButtonSize(panel, newButton(BUTTON_LABELS[i]), i);
        }
        createTextField(panel);
    }

    //Create a new Button
    private Button newButton(String text) {
        return (text != null) ? new Button(""+text) : null;
    }

    //Calls add after determining if size change is needed
    private void setButtonSize(GridPane panel, Button button, int buttonPositionNum) {
        int buttonSize = BUTTON_SMALL;
        if (button != null) {  //skips large button parts
            if (button.getText().equals("Enter")) {
                buttonSize = 2;
            }
            addButtonToPanel(panel, button, buttonPositionNum, buttonSize, BUTTON_SMALL);
        }
    }

    //Adds button to panel
    private void addButtonToPanel(GridPane panel, Button button, int buttonPositionNum, int cSpan, int rSpan) {
        panel.add(button, buttonPositionNum % TOTAL_COLS, buttonPositionNum / TOTAL_COLS, cSpan, rSpan);
        setMaxButtonWidth(button);
    }

    //Sets button width to max value
    private void setMaxButtonWidth(Button button) {
        button.setPrefWidth(Double.MAX_VALUE);
    }

}
