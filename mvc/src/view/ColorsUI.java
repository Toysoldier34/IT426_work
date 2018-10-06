package view;

import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.ColorPair;

import java.util.List;

public class ColorsUI extends Application
{
    private Controller controller = new Controller();
    private FlowPane colorsPanel;

    @Override
    public void start(Stage stage)
    {
        stage.setScene(getScene());
        stage.setTitle("Working with MVC");
        stage.show();
    }

    private Scene getScene()
    {
        VBox mainPanel = new VBox();
        mainPanel.setPadding(new Insets(10));
        mainPanel.setSpacing(10);

        mainPanel.getChildren().addAll(entryForm(), colorsRegion());

        //load any colors that are saved in my model
        addColors(controller.handleGetColors());



        return new Scene(mainPanel, 600, 500);
    }

    private HBox entryForm()
    {
        Label enterLabel = new Label("Enter a new color: ");
        TextField nameEntry = new TextField();
        ColorPicker colorEntry = new ColorPicker();
        Button add = new Button("Add!");

        add.setOnAction(event -> {
            //save the new color to our model layer
            controller.handleNewColor(nameEntry.getText(), colorEntry.getValue());
            addColor(nameEntry.getText(), colorEntry.getValue());
        });

        HBox controlsPanel = new HBox();
        controlsPanel.setSpacing(10);
        controlsPanel.getChildren().addAll(enterLabel, nameEntry, colorEntry, add);

        return controlsPanel;
    }

    private FlowPane colorsRegion()
    {
        colorsPanel = new FlowPane();
        colorsPanel.setHgap(10);
        colorsPanel.setVgap(10);
        return colorsPanel;
    }

    //this will add a group of colors to our flow panel
    private void addColors(List<ColorPair> pairs) {
        for (ColorPair pair : pairs) {
            addColor(pair.getName(), pair.getColor());
        }
    }

    //this will add a single color to our flow panel
    private void addColor(String name, Color color) {
        Rectangle square = new Rectangle();
        square.setWidth(40);
        square.setHeight(40);
        square.setFill(color);

        //add a tooltip with the name of the color
        Tooltip tip = new Tooltip(name);
        Tooltip.install(square, tip);

        colorsPanel.getChildren().add(square);
    }



}


























