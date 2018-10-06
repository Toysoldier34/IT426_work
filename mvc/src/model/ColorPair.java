package model;

import javafx.scene.paint.Color;

public class ColorPair
{
    private String name;
    private Color color;

    public ColorPair(String name, Color color)
    {
        this.name = name;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public Color getColor()
    {
        return color;
    }

    @Override
    public String toString()
    {
        return name + " - " + color;
    }
}
