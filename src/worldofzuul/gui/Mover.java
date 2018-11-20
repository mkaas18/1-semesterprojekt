/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.gui;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 *
 * @author SteamyBlizzard
 */
public class Mover {

    private double playerX = 0, playerY = 0;
    private double playerDX = 0, playerDY = 0;
    private double playerDAngle = 0;
    private final int MOVESPEED = 5;
    
    public Mover() {

    }

    public void keyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case S:
                playerDY = MOVESPEED;
                break;
            case W:
                playerDY = -MOVESPEED;
                break;
            case A:
                playerDX = -MOVESPEED;
                break;
            case D:
                playerDX = MOVESPEED;
                break;
        }
    }

    public void keyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case W:
            case S:
                playerDY = 0;
                break;
            case A:
            case D:
                playerDX = 0;
                break;
        }
    }
    
    public boolean checkBorders(Circle player, Circle playerHitbox, Pane gameWindow) {
        playerHitbox.setCenterX(this.getPlayerXCheck());
        playerHitbox.setCenterY(this.getPlayerYCheck());
        double pHMinY = playerHitbox.getBoundsInParent().getMinY();
        double pHMinX = playerHitbox.getBoundsInParent().getMinX();
        double pHMaxY = playerHitbox.getBoundsInParent().getMaxY();
        double pHMaxX = playerHitbox.getBoundsInParent().getMaxX();
        if (pHMinX < 0 || pHMaxX > gameWindow.getWidth() || pHMinY < 0
                || pHMaxY > gameWindow.getHeight()) {
            playerHitbox.setCenterX(player.getCenterX());
            playerHitbox.setCenterY(player.getCenterY());
            return true;
        } else {
            return false;
        }
    }

    public double getPlayerX() {
        playerX += playerDX;
        return playerX;
    }

    public double getPlayerY() {
        playerY += playerDY;
        return playerY;
    }

    public void setPlayerX(double playerX) {
        this.playerX = playerX;
    }

    public void setPlayerY(double playerY) {
        this.playerY = playerY;
    }
    
    public double getPlayerXCheck() {     
        return playerX + playerDX;
    }

    public double getPlayerYCheck() {
        return playerY + playerDY;
    }

}
