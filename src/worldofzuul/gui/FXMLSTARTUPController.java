package worldofzuul.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class FXMLSTARTUPController implements Initializable {

    private String playerName;

    @FXML
    private TextField playernameTxtField;
    @FXML
    private Button playBTN;
    @FXML
    private Button exitBTN;

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handlePlayBtn(ActionEvent event) throws IOException {
        try {
            this.playerName = playernameTxtField.getText();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Wrath of the Mathknight");
            stage.setScene(scene);
            stage.show();

            // Hide this current window (if this is what you want)
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    public void handleExitBtn(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    private void handleTxtFieldPlayGame(KeyEvent e) throws IOException {
        if (e.getCode() == KeyCode.ENTER) {
            try {
                this.playerName = playernameTxtField.getText();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Wrath of the Mathknight");
                stage.setScene(scene);
                stage.show();

                // Hide this current window (if this is what you want)
                ((Node) (e.getSource())).getScene().getWindow().hide();

            } catch (IOException ex) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", e);
            }

        }
    }
}
