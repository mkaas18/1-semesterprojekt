/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.gui;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import worldofzuul.interfaces.IGame;
import worldofzuul.interfaces.IItem;
import worldofzuul.interfaces.IPlayer;
import worldofzuul.logic.Game;
import worldofzuul.logic.Item;

/**
 *
 * @author SteamyBlizzard
 */
public class FXMLDocumentController implements Initializable {
    
    IGame game = new Game();
    IPlayer player = game.getPlayer();
    IItem item;
    private final ObservableList<IItem> inventory = 
            FXCollections.observableArrayList();
    String output;
    @FXML
    private TextArea console;
    @FXML
    private ListView<IItem> invList;
    @FXML
    private Circle playerGui, playerHitbox;
    @FXML
    private Rectangle north, south, east, west, down, up;
    HashMap<String, Rectangle> exitMap = new HashMap<>();
    @FXML
    private Pane gameWindow;
    @FXML
    private Button focusButton;
    private Mover mover = new Mover();
    
    @FXML
    private void keyPressed(KeyEvent event) {
        mover.keyPressed(event);
        if (event.getCode() == KeyCode.E) {
            if (exitMap.get("down").getBoundsInParent().intersects(playerHitbox.getBoundsInParent())
                    && !exitMap.get("down").isDisabled()) {
                output = game.goRoom("down");
                console.appendText(output);
            }
            if (exitMap.get("up").getBoundsInParent().intersects(playerHitbox.getBoundsInParent())
                    && !exitMap.get("up").isDisabled()) {
                output = game.goRoom("up");
                console.appendText(output);
            }
        }
        if(event.getCode() == KeyCode.B){
            player.pickupItem(game.giveItem());
        }
    }
    
    @FXML
    private void keyReleased(KeyEvent event) {
        mover.keyReleased(event);
        System.out.println(game.getPlayer().getHP());
        System.out.println(player.getHP());
        
    }
    private AnimationTimer moveTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (!mover.checkBorders(playerGui, playerHitbox, gameWindow)) {
                playerGui.setCenterX(mover.getPlayerX());
                playerGui.setCenterY(mover.getPlayerY());
                checkExits();
            }
            
        }
    };
    
    private void checkExits() {
        for (Rectangle exit : exitMap.values()) {
            if (exit.getBoundsInParent().intersects(playerHitbox.getBoundsInParent())
                    && !exit.isDisabled()) {
                if (exit.equals(north)) {
                    output = game.goRoom("north");
                    console.appendText(output);
                    mover.setPlayerY(gameWindow.getHeight() / 2 - 20);
                    playerGui.setCenterY(mover.getPlayerY());
                    playerHitbox.setCenterY(mover.getPlayerYCheck());
                } else if (exit.equals(south)) {
                    output = game.goRoom("south");
                    console.appendText(output);
                    mover.setPlayerY(-gameWindow.getHeight() / 2 + 20);
                    playerGui.setCenterY(mover.getPlayerY());
                    playerHitbox.setCenterY(mover.getPlayerYCheck());
                } else if (exit.equals(west)) {
                    output = game.goRoom("west");
                    console.appendText(output);
                    mover.setPlayerX(gameWindow.getWidth() / 2 - 20);
                    playerGui.setCenterX(mover.getPlayerX());
                    playerHitbox.setCenterX(mover.getPlayerXCheck());
                } else if (exit.equals(east)) {
                    output = game.goRoom("east");
                    console.appendText(output);
                    mover.setPlayerX(-gameWindow.getWidth() / 2 + 20);
                    playerGui.setCenterX(mover.getPlayerX());
                    playerHitbox.setCenterX(mover.getPlayerXCheck());
                }
                setExits();
            }
        }
    }
    
    private void setExits() {
        for (String guiExits : exitMap.keySet()) {
            for (String exits : game.getCurrentRoom().getExits()) {
                if (guiExits.equals(exits)) {
                    exitMap.get(guiExits).setDisable(false);
                    exitMap.get(guiExits).setVisible(true);
                    game.getCurrentRoom().getExit(exits);
                    break;
                } else {
                    exitMap.get(guiExits).setDisable(true);
                    exitMap.get(guiExits).setVisible(false);
                }
            }
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        console.appendText(game.printWelcome());
        exitMap.put("north", north);
        exitMap.put("south", south);
        exitMap.put("west", west);
        exitMap.put("east", east);
        exitMap.put("down", down);
        exitMap.put("up", up);
        for(Item item : player.getInventory()){
            this.item = item;
            inventory.add(this.item);
            
        }
//        inventory.getPlayerInventory();
        setExits();
        focusButton.requestFocus();
        invList.setItems(inventory);
        invList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<IItem>() {
            @Override
            public void changed(ObservableValue<? extends IItem> observable, IItem oldValue, IItem newValue) {
                System.out.println("hej");
            }
        });
        moveTimer.start();
    }
    
}
