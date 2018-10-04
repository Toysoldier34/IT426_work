package layouts;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPanelExample extends Application
{
    public static final int NUM_COLS = 3;
    public static final int WIN_WIDTH = 500;
    public static final int WIN_HEIGHT = 500;

    @Override
    public void start(Stage stage)
    {
        stage.setScene(assembleScene());
        stage.setTitle("Working in a grid");
        stage.show();
    }

    private Scene assembleScene()
    {
        GridPane panel = new GridPane();

        //some style settings
        panel.setHgap(10);
        panel.setVgap(10);
        panel.setGridLinesVisible(true);
        panel.setPadding(new Insets(10));

        //define our columns or rows
        ObservableList<ColumnConstraints> columns = panel.getColumnConstraints();
        for (int i = 0; i < NUM_COLS; i++)
        {
            columns.add(new ColumnConstraints(80));
        }

        //add some checkboxes to the top row
        CheckBox[] boxes = {new CheckBox("A"), new CheckBox("B"),
                new CheckBox("C")};
        for (int i = 0; i < NUM_COLS; i++)
        {
            panel.add(boxes[i], i, 0);
        }

        Button clickMe = new Button("Please click here");
        panel.add(clickMe, 0,1,3,1);
        clickMe.setPrefWidth(Double.MAX_VALUE);

        TextArea area = new TextArea();
        panel.add(area, 0, 2, 2,2);

        Button meToo = new Button("Me too!");
        panel.add(meToo, 2, 2);

        return new Scene(panel, WIN_WIDTH, WIN_HEIGHT);
    }
}