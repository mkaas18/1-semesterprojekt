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
import javafx.scene.control.Tab;
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
import worldofzuul.interfaces.IHighscore;
import worldofzuul.interfaces.IItem;
import worldofzuul.interfaces.IItemGenerator;
import worldofzuul.interfaces.IMonster;
import worldofzuul.interfaces.IPlayer;
import worldofzuul.logic.Game;
import worldofzuul.logic.Item;
import worldofzuul.logic.ItemGenerator;
import worldofzuul.logic.Player;

/**
 *
 * @author SteamyBlizzard
 */
public class FXMLDocumentController implements Initializable {

    private IGame game = new Game();
    private IPlayer player = game.getPlayer();
    private IItem item;
    private IHighscore highscore;
    private InventoryWindow inventoryWindow = new InventoryWindow(player);
    private ShopWindow shopWindow = new ShopWindow(game.getCurrentRoom().getShop(), player);
    private CombatWindow combatWindow = new CombatWindow();
    private MonsterAI monster1Ai = new MonsterAI();
    private MonsterAI monster2Ai = new MonsterAI();
    private String output;
    private IItemGenerator itemGen = new ItemGenerator();
    private Item droppedItem;
    private Mover mover = new Mover();
    private HashMap<String, Rectangle> exitMap = new HashMap<>();
    private HashMap<String, ImageView> exitGuiMap = new HashMap<>();
    @FXML
    private AnchorPane inventoryPane, shopPane, combatPane, lostPane;
    @FXML
    private Label goldCount, monsterName, highscoreLabel;
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
    private Circle playerGui;
    @FXML
    private Circle playerHitbox;
    @FXML
    private Circle monster1, monster2, monsterCombat;
    @FXML
    private Rectangle north, south, east, west, down, up, shop;
    @FXML
    private Pane gameWindow;
    @FXML
    private Button focusButton;
    @FXML
    private TabPane shopMode1;
    @FXML
    private Tab hello1;
    @FXML
    private Button inventoryButton;
    @FXML
    private Tab hello;
    @FXML
    private ImageView playerSprite;
    @FXML
    private ImageView monsterSprite;
    @FXML
    private Label playerMaxHPLabel;
    @FXML
    private Label playerMinHPLabel;
    @FXML
    private ImageView stairUpImg;
    @FXML
    private ImageView stairDownImg;
    @FXML
    private ImageView doorWest;
    @FXML
    private ImageView doorEast;
    @FXML
    private ImageView doorSouth;
    @FXML
    private ImageView doorNorth;
    @FXML
    private ImageView shopImg;
    @FXML
    private ImageView playerImg;
    
    // Sets the player name typing in at the text in FXMLSTARTUP
    public void setPlayerName(String playerName) {
        player.setName(playerName);
        System.out.println(player.toString());
        highscore = game.getHighscore();
        highscore.setName((Player)player);
    }

    @FXML
    private void keyPressed(KeyEvent event) {
        mover.keyPressed(event, playerImg);
        if (event.getCode() == KeyCode.E) {
            if (exitMap.get("down").getBoundsInParent().intersects(playerHitbox.getBoundsInParent())
                    && !exitMap.get("down").isDisabled() && player.getKillCounter() >= game.getCurrentRoom().getKillRequirement()) {
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
            highscore.writeHighscoreList();

        }
        if (event.getCode() == KeyCode.I) {
            System.out.println(highscore.readHighscoreList());

        }
    }

    @FXML
    private void keyReleased(KeyEvent event) {
        mover.keyReleased(event);

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

    //This method is executed everytime you submit an answer during combat
    @FXML
    private void combatInput(ActionEvent event) {
        if (combatWindow.getCombatState()) {
            combatWindow.playerTurn(combatInput, player, console);
        } else {
            combatWindow.endCombat(combatPane);
            if (monsterCombat.equals(monster1)) {
                monster1Ai.monsterReset(monster1);
                monster2Ai.startMonsterMovement();
            } else {
                monster2Ai.monsterReset(monster2);
                monster1Ai.startMonsterMovement();
            }
            combatWindow.resetCombat(true);
            player.setKillCounter();
            droppedItem = itemGen.generateItem(game.getCurrentRoom().getDifficulty());
            player.pickupItem(droppedItem);
            player.setGold(game.getCurrentRoom().getDifficulty());
            console.clear();
            console.appendText(game.getCurrentRoom().getLongDescription());
            System.out.println(player.getHp());
            if (player.getHp() < 0) {
                highscoreLabel.setText(highscore.toString());
                highscore.writeHighscoreList();
            } else {
                moveTimer.start();
            }

        }

    }

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
                playerImg.setX(mover.getPlayerX());
                playerGui.setCenterY(mover.getPlayerY());
                playerImg.setY(mover.getPlayerY());
                checkExits();
            }
            updateHealth();
            combatStart();
            highscore.setScore((Player) player);

        }
    };

    private void checkExits() {
        for (Rectangle exit : exitMap.values()) {
            if (exit.getBoundsInParent().intersects(playerHitbox.getBoundsInParent())
                    && !exit.isDisabled()) {
                if (exit.equals(north)) {
                    output = game.goRoom("north");
                    console.appendText(output);
                    mover.setPlayerY(gameWindow.getHeight() / 2 - 25);
                    playerGui.setCenterY(mover.getPlayerY());
                    playerHitbox.setCenterY(mover.getPlayerYCheck());
                    monsterSpawner();
                } else if (exit.equals(south)) {
                    output = game.goRoom("south");
                    console.appendText(output);
                    mover.setPlayerY(-gameWindow.getHeight() / 2 + 25);
                    playerGui.setCenterY(mover.getPlayerY());
                    playerHitbox.setCenterY(mover.getPlayerYCheck());
                    monsterSpawner();
                } else if (exit.equals(west)) {
                    output = game.goRoom("west");
                    console.appendText(output);
                    mover.setPlayerX(gameWindow.getWidth() / 2 - 25);
                    playerGui.setCenterX(mover.getPlayerX());
                    playerHitbox.setCenterX(mover.getPlayerXCheck());
                    monsterSpawner();
                } else if (exit.equals(east)) {
                    output = game.goRoom("east");
                    console.appendText(output);
                    mover.setPlayerX(-gameWindow.getWidth() / 2 + 25);
                    playerGui.setCenterX(mover.getPlayerX());
                    playerHitbox.setCenterX(mover.getPlayerXCheck());
                    monsterSpawner();
                }
                setExits();
                setShops();
            }
        }
    }

    private void setExits() {
        for (String guiExits : exitMap.keySet()) {
            for (String exits : game.getCurrentRoom().getExits()) {
                if (guiExits.equals(exits)) {
                    exitMap.get(guiExits).setDisable(false);
                    exitGuiMap.get(guiExits).setVisible(true);
                    game.getCurrentRoom().getExit(exits);
                    break;
                } else {
                    exitMap.get(guiExits).setDisable(true);
                    exitGuiMap.get(guiExits).setVisible(false);
                }

            }
        }
    }

    private void setShops() {
        if (game.getCurrentRoom().isShop()) {
            shopImg.setVisible(true);
            shop.setDisable(false);
        } else {
            shopImg.setVisible(false);
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

    }

    private void combatStart() {
        if (monster1Ai.combatCheck()) {
            moveTimer.stop();
            combatWindow.startCombat(console, combatMonsterHpBar, combatHpBar, combatPane, game.getCurrentRoom().getDifficulty(), player, monsterName, lostPane);
//            hpBar.setVisible(false);
            monster2Ai.pauseMonsterMovement();
            monsterCombat = monster1;
        } else if (monster2Ai.combatCheck()) {
            moveTimer.stop();
            combatWindow.startCombat(console, combatMonsterHpBar, combatHpBar, combatPane, game.getCurrentRoom().getDifficulty(), player, monsterName, lostPane);
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
        exitGuiMap.put("north", doorNorth);
        exitGuiMap.put("south", doorSouth);
        exitGuiMap.put("west", doorWest);
        exitGuiMap.put("east", doorEast);
        exitGuiMap.put("down", stairDownImg);
        exitGuiMap.put("up", stairUpImg);
        inventoryWindow.inventoryHandler(playerItemList, playerConsumeList, itemDescript);
        setExits();
        setShops();
        updateHealth();
        focusButton.requestFocus();
        moveTimer.start();
        goldCount.setText("Gold: " + player.getGold());
        monster1Ai.startMonsterMovement(monster1, playerGui);
        monster2Ai.startMonsterMovement(monster2, playerGui);
    }

}
