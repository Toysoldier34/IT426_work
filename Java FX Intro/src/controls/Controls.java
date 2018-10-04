package controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Controls extends Application
{

    public static final int WIN_WIDTH = 500;
    public static final int WIN_HEIGHT = 600;

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Working with Widgets");
        stage.setScene(assembleScene());
        stage.show();
    }

    private Scene assembleScene()
    {
        //create our main panel and scrolling
        VBox mainPanel = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(mainPanel);

        mainPanel.setStyle("-fx-background-color: rgb(61,230,137)");

        //create some spacing with our main panel
        mainPanel.setSpacing(10);
        mainPanel.setPadding(new Insets(10));

        mainPanel.getChildren().addAll(checkboxes(), radioButtons(), dropDowns(),
                textElements());

        return new Scene(scrollPane, WIN_WIDTH, WIN_HEIGHT);
    }

    private HBox checkboxes()
    {
        HBox panel = new HBox();
        panel.setSpacing(10);

        //create a few checkboxes
        String[] labels = {"red", "green", "blue", "orange"};
        CheckBox[] boxes = new CheckBox[labels.length];

        //create the nodes and add them to the hbox
        for (int i = 0; i < labels.length; i++)
        {
            boxes[i] = new CheckBox(labels[i]);
        }
        panel.getChildren().addAll(boxes);

        //add some event handling
        for (CheckBox box : boxes)
        {
            //we used a ChangeListener
            box.selectedProperty().addListener(
                    (observable, oldValue, newValue) ->
                            box.setText(newValue.toString()));
        }

        return panel;
    }

    private HBox radioButtons()
    {
        HBox panel = new HBox();

        //here is the group that groups together our radio buttons
        ToggleGroup group = new ToggleGroup();

        RadioButton[] buttons = new RadioButton[3];
        for (int i = 0; i < buttons.length; i++)
        {
            buttons[i] = new RadioButton("Choice " + i);
        }
        panel.getChildren().addAll(buttons);
        group.getToggles().addAll(buttons);

        return panel;
    }

    private VBox dropDowns()
    {
        VBox panel = new VBox();
        panel.setSpacing(10);

        //add dropdown
        ComboBox<String> list = new ComboBox<>();
        list.getItems().addAll("Flyer", "Newspaper", "From a friend",
                "Advertisement", "Word of mouth");
        panel.getChildren().add(list);

        //add a date picker
        panel.getChildren().add(new DatePicker());

        //add a color picker
        ColorPicker colors = new ColorPicker();
        panel.getChildren().add(colors);

        //add a rectangle region that displays a color
        Rectangle colorRegion = new Rectangle();
        colorRegion.setWidth(50);
        colorRegion.setHeight(50);
        panel.getChildren().add(colorRegion);

        colors.setOnAction(event -> {
            colorRegion.setFill(colors.getValue());
        });

        return panel;
    }

    private VBox textElements()
    {
        VBox parentPanel = new VBox();
        parentPanel.getChildren().addAll(
                createTextInput("Name: ", new TextField()),
                createTextInput("Bio: ", new TextArea()));
        parentPanel.setSpacing(10);

        return parentPanel;
    }

    private HBox createTextInput(String prompt, Node inputElement)
    {
        Label label = new Label(prompt);
        HBox panel = new HBox();
        panel.getChildren().addAll(label, inputElement);

        return panel;
    }
}










