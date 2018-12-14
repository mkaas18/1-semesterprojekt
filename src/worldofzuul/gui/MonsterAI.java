/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.gui;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import worldofzuul.interfaces.IMonster;
import worldofzuul.logic.Monster;

/**
 *
 * @author fredd
 */
public class MonsterAI {

    private IMonster monster = new Monster();
    private Mover monsterMover = new Mover();
    private AnimationTimer monsterAnimation;
    private boolean combatInitiated = false;
    private final static int MONSTER_SPEED = 0;
    


    public void monsterMovement(Circle monster, Circle player) {
        double startX, startY, endX, endY, deltaX, deltaY, angle;
        startX = monster.getBoundsInParent().getMinX() + monster.getBoundsInParent().getWidth() / 2;
        startY = monster.getBoundsInParent().getMinY() + monster.getBoundsInParent().getHeight() / 2;
        endX = player.getBoundsInParent().getMinX() + player.getBoundsInParent().getWidth() / 2;
        endY = player.getBoundsInParent().getMinY() + player.getBoundsInParent().getHeight() / 2;
        deltaX = startX - endX;
        deltaY = startY - endY;
        angle = Math.atan2(deltaX, deltaY);
        monster.setCenterX(monster.getCenterX() - MONSTER_SPEED * Math.sin(angle));
        monster.setCenterY(monster.getCenterY() - MONSTER_SPEED * Math.cos(angle));
    }

    public boolean monsterSpawn(Circle monster, Pane gamewindow) {
        if (this.monster.monsterSpawnDiceroll()) {
            monster.setVisible(true);
            monster.setDisable(false);
            monster.setCenterX(new Random().nextInt((int) gamewindow.getWidth()));
            monster.setCenterY(new Random().nextInt((int) gamewindow.getHeight()));
            return true;
        }
        return false;
    }

    public void monsterReset(Circle monster) {
        if (monster.isVisible() == true && monster.isDisabled() == false) {
            monster.setVisible(false);
            monster.setDisable(true);
            combatInitiated = false;
            pauseMonsterMovement();
        }
    }

    public void startMonsterMovement(Circle monster, Circle player) {
        monsterAnimation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                monsterMovement(monster, player);
                if (monster.getBoundsInParent().intersects(player.getBoundsInParent()) && monster.isDisabled()==false) {
                    combatInitiated = true;
                    combatCheck();
                    pauseMonsterMovement();
                }
            }

        };
        monsterAnimation.start();

    }

    public void pauseMonsterMovement() {
        monsterAnimation.stop();
    }

    public void startMonsterMovement() {
        monsterAnimation.start();
    }
    
    public boolean combatCheck(){
        return combatInitiated;
    }

}
