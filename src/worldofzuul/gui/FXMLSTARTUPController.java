package worldofzuul.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import worldofzuul.interfaces.IHighscore;
import worldofzuul.logic.Highscore;

public class FXMLSTARTUPController implements Initializable {

    private String playerName;
    private Highscore highscore = new Highscore(playerName);
    private ObservableList<String> obsHighscoreList;

    @FXML
    private ListView<String> listViewTable;
    @FXML
    private TextField playernameTxtField;
    @FXML
    private Button playBTN;
    @FXML
    private Button exitBTN;
    @FXML
    private Button HighscoreBTN;
    @FXML
    private Button backToMainMenuBTN;
    @FXML
    private AnchorPane mainMenuPane;
    @FXML
    private AnchorPane highscorePane;
    @FXML
    private Button introMainMenuBTN;
    @FXML
    private Button introExitBTN;

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    
    // When Play button is pressed it loads the game and hide the first window
    @FXML
    public void handlePlayBtn(ActionEvent event) throws IOException {

        this.playerName = playernameTxtField.getText();
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
        try {

            Scene scene = new Scene(Loader.load());
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

        FXMLDocumentController gameController = Loader.getController();
        gameController.setPlayerName(playerName);
    }

    // When Exit button on main menu is pressed it closes the application
    @FXML
    public void handleExitBtn(ActionEvent event) {
        System.exit(1);
    }

    // This method make you able to press "enter" when you typed in your Playername and starts the game, instead of pressing the play button
    @FXML
    private void handleTxtFieldPlayGame(KeyEvent e) throws IOException {
        if (e.getCode() == KeyCode.ENTER) {
            this.playerName = playernameTxtField.getText();
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            try {

                Scene scene = new Scene(Loader.load());
                Stage stage = new Stage();
                stage.setTitle("Wrath of the Mathknight");
                stage.setScene(scene);
                stage.show();

                // Hide this current window (if this is what you want)
                ((Node) (e.getSource())).getScene().getWindow().hide();

            } catch (IOException ex) {
                Logger logger = Logger.getLogger(getClass().getName());
                logger.log(Level.SEVERE, "Failed to create new Window.", ex);
            }

            FXMLDocumentController gameController = Loader.getController();
            gameController.setPlayerName(playerName);
        }
    }

    // Makes you see the highscores that have been made in the game
    @FXML
    private void handleHighscoreBTN(ActionEvent event) {

        obsHighscoreList = highscore.getObsHighscoreList();
        listViewTable.setItems(obsHighscoreList);

        mainMenuPane.setVisible(false);
        mainMenuPane.setDisable(true);

        highscorePane.setVisible(true);
        highscorePane.setDisable(false);

    }

    // Back button from the highscore view
    @FXML
    private void handleBackBTN(ActionEvent event) {
        mainMenuPane.setVisible(true);
        mainMenuPane.setDisable(false);

        highscorePane.setVisible(false);
        highscorePane.setDisable(true);

    }

    // Makes you head into the main menu after the intro
    @FXML
    private void handleintroMainMenuBTN(ActionEvent event) {
        // TODO
    }

    // Makes you able to exit the application on the intro scene.
    @FXML
    private void handleIntroExitBTN(ActionEvent event) {
        // TODO
    }
}
