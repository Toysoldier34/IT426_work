package intro;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;

/**
 * This is our first Java FX app.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class HelloWorld extends Application
{
    public static final int WIN_SIZE = 300;
    public static final int DEF_FONT_SIZE = 30;

    @Override
    public void start(Stage stage)
    {
        //perform a few setup tasks
        stage.setTitle("Welcome to Java FX");
        stage.setScene(buildScene());
        stage.show();
    }

    /**
     * Assembles our UI.
     * @return a new scene object
     */
    public Scene buildScene() //assemble our UI
    {
        //create a panel and an element to place inside of it
        VBox panel = new VBox();
        Text info = new Text("Hello world!");

        //add a few styles
        panel.setAlignment(Pos.CENTER);
        info.setFont(Font.font("Verdana", FontWeight.BOLD, DEF_FONT_SIZE));

        panel.getChildren().add(info);

        return new Scene(panel, WIN_SIZE, WIN_SIZE);
    }
}