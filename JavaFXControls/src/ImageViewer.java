import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class ImageViewer extends Application
{

    private ImageView myImageView = new ImageView();


    public void start(Stage stage)
    {
        stage.setTitle("Image Viewer Application");
        stage.setScene(assembleScene("cat"));
        stage.show();
    }

    public Scene assembleScene(String name)
    {
        VBox mainPanel = new VBox();
        mainPanel.getChildren().addAll(radioButtons().myImageView);
        return new Scene(mainPanel, 600, 600);
    }

    public HBox radioButtons()
    {
        HBox panel = new HBox();
        panel.setSpacing(10);

        ToggleGroup group = new ToggleGroup();

        RadioButton button1 = new RadioButton("bear");
        RadioButton button2 = new RadioButton("cat");
        RadioButton button3 = new RadioButton("owl");
        RadioButton button4 = new RadioButton("parrot");

        button1.setToggleGroup(group);
        button2.setToggleGroup(group);
        button3.setToggleGroup(group);
        button4.setToggleGroup(group);

        panel.getChildren().addAll(button1,button2,button3,button4);


        butts(button1);
        butts(button2);
        butts(button3);
        butts(button4);


        return panel;
    }

   private HBox butts(RadioButton button) {
        HBox image = new HBox();
        button.selectedProperty().addListener((ChangeListener) (observable, oldValue, newValue) -> {
            setImageString(button.getText());
        });


        return image;
    }


    private void setImageString(String file) {
        try{
            Image image = new Image(new File("images/images/"+file+".jpg").toURI().toURL().toString(), true);
            myImageView.setImage(image);
        }catch(Exception MalformedURLException)
        {
            System.out.println("BAD URL");
        }
    }

}
