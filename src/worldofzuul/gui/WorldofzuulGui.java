package worldofzuul.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author SteamyBlizzard
 */
public class WorldofzuulGui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLSTARTUP.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Wrath of the Mathknight");
        stage.getIcons().add(new Image("playerSprite.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
