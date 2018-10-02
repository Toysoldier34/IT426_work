package switchingscenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StoryBook extends Application
{
    public static final int WIN_SIZE = 300;
    public static final int DELAY = 3000;

    private Stage stage;
    private String[] headers = {"Part #1", "Part #2", "Part #3"};
    private String[] bodies = {
            "Today, in the news, unicorns invade Seattle...",
            "The killer clowns were there to stop them...",
            "The clowns prevailed... The end"
    };

    @Override
    public void start(Stage stage)
    {
        //record the stage for use later
        this.stage = stage;

        stage.setTitle("Welcome to Java FX");
        stage.setScene(getWaitScreen());
        stage.show();

        //wait a few seconds, to simulate load times, then display our story
        KeyFrame frame = new KeyFrame(Duration.millis(DELAY),
                event -> { stage.setScene(getStoryScreen(0)); });
        Timeline animation = new Timeline(frame);
        animation.play();
    }

    public Scene getWaitScreen()
    {
        //show a progress indicator and a message
        ProgressIndicator progress = new ProgressIndicator();
        Text message = new Text("Please wait...");

        return getSceneWithVBox(progress, message);
    }

    public Scene getSceneWithVBox(Node... elements)
    {
        VBox panel = new VBox();
        panel.getChildren().addAll(elements);

        return new Scene(panel, WIN_SIZE, WIN_SIZE);
    }

    public Scene getStoryScreen(int index)
    {
        Text header = new Text(headers[index]);
        Text body = new Text(bodies[index]);

        if (index != headers.length - 1)
        {
            //send the user to the next screen if they click the button
            Button button = new Button("Next");
            button.setOnAction(event -> stage.setScene(getStoryScreen(index + 1)));

            return getSceneWithVBox(header, body, button);
        }

        return getSceneWithVBox(header, body);
    }
}