package controller;

import javafx.scene.paint.Color;
import model.ColorPair;
import model.FileData;
import model.IColorsData;
import model.InMemoryData;

import java.util.List;

public class Controller
{
    private IColorsData model;

    public Controller() {
        model = new FileData("files/colors.dat");
    }

    //this function will accept color data from the view and pass it to the model
    public boolean handleNewColor(String name, Color color) {
        //perform a little validation
        if (name == null || name.equals("") || color == null) {
            return false;
        }

        //store the new color (name and rgb values) in our model
        model.addColor(name, color);
        return false;
    }

    public List<ColorPair> handleGetColors() {

        return model.getColors();
    }

}
