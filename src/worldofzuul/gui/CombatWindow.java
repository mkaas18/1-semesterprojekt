/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul.gui;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import worldofzuul.interfaces.IMonster;
import worldofzuul.interfaces.IMonsterGenerator;
import worldofzuul.interfaces.IPlayer;
import worldofzuul.interfaces.IQuestionResults;
import worldofzuul.logic.MonsterGenerator;
import worldofzuul.logic.Player;
import worldofzuul.logic.QuestionResults;

/**
 *
 * @author fredd
 */
public class CombatWindow {

    IMonsterGenerator monsterGen = new MonsterGenerator();
    IMonster monster;
    IQuestionResults questionResults;
    private boolean combatInitialized = true;
    private AnimationTimer combatTimer;
    boolean playerTurn = false;

    public void startCombat(TextArea textarea, ProgressBar monsterHealth, AnchorPane combatPane, int difficulty, IPlayer player, Label monsterNameLabel) {
        monster = monsterGen.generateMonster(difficulty);
        monsterNameLabel.setText(monster.getName());
        playerTurn = false;
        combatWindowToggle(combatPane);
        textarea.clear();
        combatTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!playerTurn) {
                    monsterTurn(textarea);
                }
                updateMonsterHealth(monsterHealth);
                if (monster.getHp() < 0) {
                    combatInitialized = false;
                    textarea.clear();
                    textarea.appendText("The monster dropped an item\n");
                    textarea.appendText("You win! Press 'ENTER' to exit combat");
                }
            }

        };
        combatTimer.start();
    }

    public void monsterTurn(TextArea textarea) {
        questionResults = monster.questionPicker();
        textarea.appendText(questionResults.getQuestion());
        playerTurn = true;
    }

    public void playerTurn(TextField combatInput, IPlayer player, TextArea textArea) {
        boolean noException = false;
        double input = 0;
        if (playerTurn) {
            try {
                input = Double.parseDouble(combatInput.getText());
                noException = true;
            } catch (NumberFormatException e) {

            }
            if (noException) {
                textArea.appendText(monster.answerChecker((QuestionResults) questionResults, input, (Player) player));
                combatInput.clear();
                playerTurn = false;
            }

        }
    }

    public void updateMonsterHealth(ProgressBar monsterHealth) {
        double percentage = (double) monster.getHp() / (double) monster.getMAX_HP();
        if (percentage < 0) {
            percentage = 0;
        }
        monsterHealth.setProgress(percentage);
    }

    public void combatWindowToggle(AnchorPane combatPane) {

        combatPane.setVisible(true);
        combatPane.setDisable(false);

    }

    public void endCombat(AnchorPane combatPane) {
        combatPane.setVisible(false);
        combatPane.setDisable(true);
        combatTimer.stop();

    }

    public boolean getCombatState() {
        return combatInitialized;
    }
    
    public void resetCombat(Boolean combatState){
        this.combatInitialized = combatState;
        
    }
}
