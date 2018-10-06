package model;

import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class FileData implements IColorsData
{
    private InMemoryData data;
    private String dataFilePath;

    public FileData(String dataFilePath)
    {
        data = new InMemoryData();
        this.dataFilePath = dataFilePath;
    }

    @Override
    public void addColor(String name, Color color)
    {
        data.addColor(name, color);
        saveToFile();
    }

    @Override
    public void removeColor(String name)
    {
        data.removeColor(name);
        saveToFile();
    }

    @Override
    public void update(String name, Color color)
    {
        data.update(name, color);
        saveToFile();
    }

    @Override
    public List<ColorPair> getColors()
    {
        readFromFile();
        return data.getColors();
    }

    private void readFromFile()
    {
        try (Scanner reader = new Scanner(new FileInputStream(dataFilePath)))
        {
            while (reader.hasNextLine())
            {
                String line = reader.nextLine();
                String[] parts = line.split(",");
                Color color = Color.color(Double.parseDouble(parts[1]),
                                          Double.parseDouble(parts[2]),
                                          Double.parseDouble(parts[3]),
                                          Double.parseDouble(parts[4]));

                data.addColor(parts[0], color);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error reading file: " + ex.getMessage());
        }
    }

    private void saveToFile()
    {
        //just overwrite the file
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(dataFilePath)))
        {
            for (ColorPair pair : data.getColors())
            {
                Color color = pair.getColor();
                writer.println(pair.getName() + ", " + color.getRed() + ", " +
                        color.getGreen() + ", " + color.getBlue() + ", " + color.getOpacity());
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }
}
