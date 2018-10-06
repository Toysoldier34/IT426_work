package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InMemoryData implements IColorsData
{

    private Map<String, Color> colors;

    public InMemoryData() {
        colors = new TreeMap<>();

        //add a few test colors
        colors.put("Red", Color.RED);
        colors.put("Green", Color.GREEN);
    }

    @Override
    public void addColor(String name, Color color) {
        //only add the pair if the key (the color name) is not already in the map
        if (!colors.containsKey(name)) {
            colors.put(name, color);
        }
    }


    @Override
    public void removeColor(String name) {
        colors.remove(name);
    }


    @Override
    public void update(String name, Color color) {
        //I only want to update the map if the key is present in the map
        if (colors.containsKey(name)) {
            colors.put(name, color);
        }
    }


    @Override
    public List<ColorPair> getColors() {
        List<ColorPair> pairs = new ArrayList<>();
        //add all key-value pairs from the map to the list
        for (String name : colors.keySet()) {
            pairs.add(new ColorPair(name, colors.get(name)));
        }
        return pairs;
    }
}
