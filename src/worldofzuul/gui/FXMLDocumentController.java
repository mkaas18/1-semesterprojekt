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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import worldofzuul.interfaces.IGame;
import worldofzuul.interfaces.IItem;
import worldofzuul.interfaces.IMonster;
import worldofzuul.interfaces.IPlayer;
import worldofzuul.logic.Game;

/**
 *
 * @author SteamyBlizzard
 */
public class FXMLDocumentController implements Initializable {

    IGame game = new Game();
    IPlayer player = game.getPlayer();
    IItem item;
    InventoryWindow inventoryWindow = new InventoryWindow(player);
    ShopWindow shopWindow = new ShopWindow(game.getCurrentRoom().getShop(), player);
    CombatWindow combatWindow = new CombatWindow();
    MonsterAI monster1Ai = new MonsterAI();
    MonsterAI monster2Ai = new MonsterAI();
    String output;
    MovementAnimation movementAni = new MovementAnimation();
    @FXML
    private ImageView kirbysprite;
    @FXML
    private AnchorPane inventoryPane, shopPane, combatPane;
    @FXML
    private Label goldCount, monsterName;
    @FXML
    private TextArea console, itemDescript, waresDescipt;
    @FXML
    private TextField combatInput;
    @FXML
    private ProgressBar hpBar, combatHpBar, combatMonsterHpBar, combatTimeLeft;
    @FXML
    private MenuItem itemSell, consumableSell;
    @FXML
    private TabPane shopMode;
    @FXML
    private ListView<IItem> playerItemList, playerConsumeList, waresList, consumableList;
    @FXML
    private Circle playerGui, playerHitbox, monster1, monster2, monsterCombat;
    @FXML
    private Rectangle north, south, east, west, down, up, shop;
    HashMap<String, Rectangle> exitMap = new HashMap<>();
    @FXML
    private Pane gameWindow;
    @FXML
    private Button focusButton;
    private Mover mover = new Mover();

    @FXML
    private void keyPressed(KeyEvent event) {
        mover.keyPressed(event);
        movementAni.AnimationStart();
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
            if (shop.getBoundsInParent().intersects(playerHitbox.getBoundsInParent())
                    && !shop.isDisabled()) {
                shopToggle();

            }
        }
        if (event.getCode() == KeyCode.B) {
            player.addHp(-35);
        }
        if (event.getCode() == KeyCode.C) {

        }
        if (event.getCode() == KeyCode.I) {

        }
    }

    @FXML
    private void keyReleased(KeyEvent event) {
        mover.keyReleased(event);
        movementAni.AnimationStop();

    }

    @FXML
    private void inventoryToggle(ActionEvent event) {
        if (inventoryPane.isVisible()) {
            inventoryPane.setVisible(false);
            inventoryPane.setDisable(true);
        } else {
            inventoryPane.setVisible(true);
            inventoryPane.setDisable(false);
        }

    }

    @FXML
    private void buyItem(ActionEvent event) {
        if (shopMode.getTabs().get(0) == shopMode.getSelectionModel().getSelectedItem()) {
            shopWindow.buyItem();
        } else if (shopMode.getTabs().get(1) == shopMode.getSelectionModel().getSelectedItem()) {
            shopWindow.buyConsumable();
        }
        goldCount.setText("Gold: " + player.getGold());

    }

    @FXML
    private void sellItem(ActionEvent event) {
        shopWindow.sellItem(inventoryWindow);
        goldCount.setText("Gold: " + player.getGold());
    }

    @FXML
    private void sellConsumable(ActionEvent event) {
        shopWindow.sellConsumable(inventoryWindow);
        goldCount.setText("Gold: " + player.getGold());
    }

    @FXML
    private void useConsumable(ActionEvent event) {
        inventoryWindow.useConsumable();
    }

    @FXML
    private void combatInput(ActionEvent event) {
        if(combatWindow.getCombatState()){
            combatWindow.playerTurn(combatInput, player, console);
        } else {
            combatWindow.endCombat(combatPane);
            if(monsterCombat.equals(monster1)){
                monster1Ai.monsterReset(monster1);
                monster2Ai.startMonsterMovement();
            } else {
                monster2Ai.monsterReset(monster2);
                monster1Ai.startMonsterMovement();
            }
            combatWindow.resetCombat(true);
            console.clear();
            console.appendText(game.getCurrentRoom().getLongDescription());
            moveTimer.start();
        }
        
    }

    @FXML
    private void shopToggle() {
        if (shopPane.isVisible()) {
            shopPane.setVisible(false);
            shopPane.setDisable(true);
            itemSell.setVisible(false);
            consumableSell.setVisible(false);
            shopWindow.stopShopHandler(waresList, consumableList);
            moveTimer.start();
        } else {
            shopPane.setVisible(true);
            shopPane.setDisable(false);
            itemSell.setVisible(true);
            consumableSell.setVisible(true);
            shopWindow = new ShopWindow(game.getCurrentRoom().getShop(), player);
            shopWindow.shopHandler(waresList, consumableList, waresDescipt);
            moveTimer.stop();

        }
    }

    private AnimationTimer moveTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (!mover.checkBorders(playerGui, playerHitbox, gameWindow)) {
                playerGui.setCenterX(mover.getPlayerX());
                playerGui.setCenterY(mover.getPlayerY());
                kirbysprite.setX(playerGui.getCenterX());
                kirbysprite.setY(playerGui.getCenterY());
                checkExits();
            }
            updateHealth();
            combatStart();

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
                setShops();
                monsterSpawner();
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

    private void setShops() {
        if (game.getCurrentRoom().isShop()) {
            shop.setVisible(true);
            shop.setDisable(false);
        } else {
            shop.setVisible(false);
            shop.setDisable(true);
        }
    }

    private void monsterSpawner() {
        monster1Ai.monsterReset(monster1);
        monster2Ai.monsterReset(monster2);
        if (monster1Ai.monsterSpawn(monster1, gameWindow)) {
            monster1Ai.startMonsterMovement();
        }
        if (monster2Ai.monsterSpawn(monster2, gameWindow)) {
            monster2Ai.startMonsterMovement();
        }
    }

    //sets the progressbar with the health percentage
    private void updateHealth() {
        double percentage = (double) player.getHp() / (double) player.getMaxHp();
        if (percentage < 0) {
            percentage = 0;
        }
        hpBar.setProgress(percentage);
        combatHpBar.setProgress(percentage);

    }

    private void combatStart() {
        if (monster1Ai.combatCheck()) {
            moveTimer.stop();
            combatWindow.startCombat(console, combatMonsterHpBar, combatPane, game.getCurrentRoom().getDifficulty());
//            hpBar.setVisible(false);
            monster2Ai.pauseMonsterMovement();
            monsterCombat = monster1;
        } else if(monster2Ai.combatCheck()){
            moveTimer.stop();
            combatWindow.startCombat(console, combatMonsterHpBar, combatPane, game.getCurrentRoom().getDifficulty());
//            hpBar.setVisible(false);
            monster1Ai.pauseMonsterMovement();
            monsterCombat = monster2;
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
        inventoryWindow.inventoryHandler(playerItemList, playerConsumeList, itemDescript);
        setExits();
        setShops();
        updateHealth();
        focusButton.requestFocus();
        moveTimer.start();
        goldCount.setText("Gold: " + player.getGold());
        monster1Ai.startMonsterMovement(monster1, playerGui);
        monster2Ai.startMonsterMovement(monster2, playerGui);
        movementAni.MovementAnimation(playerGui, kirbysprite);
    }

}
