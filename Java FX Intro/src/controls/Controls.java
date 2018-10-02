package controls;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controls extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Working with Widgets");
        stage.setScene(assembleScene());
        stage.show();
    }




    private Scene assembleScene() {
        //create our main panel and scrolling
        VBox mainPanel = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(mainPanel);

        mainPanel.setStyle("-fx-background-color: rgb(150, 200, 30)");

        //create some spacing with main panel
        mainPanel.setSpacing(10);
        mainPanel.setPadding(new Insets(10));

        mainPanel.getChildren().addAll(checkboxes(), radioButtons(), dropDown());

        return new Scene(scrollPane, 500, 600);

    }


    private HBox checkboxes() {
        HBox panel = new HBox();
        panel.setSpacing(10);

        String[] labels = {"red", "green", "blue", "orange"};
        CheckBox[] boxes = new CheckBox[labels.length];

        //create the nodes and add them to the hbox
        for (int i =  0; i < labels.length; i++) {
            boxes[i] = new CheckBox(labels[i]);
        }
        panel.getChildren().addAll(boxes);

        //add some event handling
        for (CheckBox box : boxes) {
            //we used a ChangeListener
            box.selectedProperty().addListener((observable, oldValue, newValue) -> {
                box.setText(newValue.toString());
            });
        }

        return panel;
    }

    private HBox radioButtons() {
        HBox panel = new HBox();

        //group that groups together radio buttons
        ToggleGroup group = new ToggleGroup();

        RadioButton[] buttons = new RadioButton[3];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new RadioButton("Choice " + i);
        }
        panel.getChildren().addAll(buttons);
        group.getToggles().addAll(buttons);


        return panel;
    }


    private VBox dropDown() {
        VBox panel = new VBox();

        //add dropdown
        ComboBox<String> list = new ComboBox<>();
        list.getItems().addAll("Flyer", "Newspaper", "From a friend", "Advertisement");
        panel.getChildren().add(list);

        //add a date picker
        panel.getChildren().add(new DatePicker());


        //add a color picker
        panel.getChildren().add(new ColorPicker());

        return panel;
    }






}



