package model;

import javafx.scene.paint.Color;

import java.util.List;

public interface IColorsData
{
    //CRUD access (create, read, update, delete)
    void addColor(String name, Color color);
    void removeColor(String name);
    void update(String name, Color color);
    public List<ColorPair> getColors();
}
