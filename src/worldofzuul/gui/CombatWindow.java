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
import worldofzuul.interfaces.IQuestionTimer;
import worldofzuul.logic.MonsterGenerator;
import worldofzuul.logic.Player;
import worldofzuul.logic.QuestionResults;
import worldofzuul.logic.QuestionTimer;

/**
 *
 * @author fredd
 */
public class CombatWindow {

    IMonsterGenerator monsterGen = new MonsterGenerator();
    IMonster monster;
    IQuestionResults questionResults;
    IQuestionTimer questionTimer = new QuestionTimer();
    private boolean combatInitialized = true;
    private AnimationTimer combatTimer;
    boolean playerTurn = false;

    public void startCombat(TextArea textarea, ProgressBar monsterHealth, ProgressBar combatTimeLeft, ProgressBar playerHealth, AnchorPane combatPane, int difficulty, IPlayer player, Label monsterNameLabel, AnchorPane lostPane) {
        monster = monsterGen.generateMonster(difficulty);
        questionTimer.setTime((Player) player);

        monsterNameLabel.setText(monster.getName());
        playerTurn = false;
        combatWindowToggle(combatPane);
        textarea.clear();
        combatTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!playerTurn) {
                    monsterTurn(textarea);
                    questionTimer.startTimer();
                }
                updatePlayerHealth(player, playerHealth);
                updateMonsterHealth(monsterHealth);
                System.out.println(questionTimer.getTime());
                updateTimeLeft(combatTimeLeft);
                checkTimeLeft(questionTimer.getTime(), textarea, player);
                if (monster.getHp() < 0) {
                    combatInitialized = false;
                    questionTimer.stopTimer();
                    textarea.clear();
                    textarea.appendText("The monster dropped an item\n");
                    textarea.appendText("You win! Press 'ENTER' to exit combat");
                } else if (player.getHp() < 0) {
                    questionTimer.stopTimer();
                    lostPane.setVisible(true);
                    lostPane.setDisable(false);
                    combatInitialized = false;

                }
            }

        };
        combatTimer.start();
    }

    public void monsterTurn(TextArea textarea) {
        while (true) {
            questionResults = monster.questionPicker();
            if (questionResults != null) {
                break;
            }
        }
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
                System.out.println(player.getHp());
                combatInput.clear();
                questionTimer.stopTimer();
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

    public void updateTimeLeft(ProgressBar combatTimeLeft) {
        double percentage = (double) questionTimer.getTime() / (double) questionTimer.getMaxTime();
        if (percentage < 0) {
            percentage = 0;
        }
        combatTimeLeft.setProgress(percentage);
    }

    public void updatePlayerHealth(IPlayer player, ProgressBar playerHealth) {
        double percentage = (double) player.getHp() / (double) player.getMaxHp();
        if (percentage < 0) {
            percentage = 0;
        }
        playerHealth.setProgress(percentage);
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

    public void resetCombat(Boolean combatState) {
        this.combatInitialized = combatState;

    }

    public void checkTimeLeft(int timeleft, TextArea textArea, IPlayer player) {
        if (timeleft == 0) {
            textArea.appendText("You ran out of time! The monster attacks!\n");
            textArea.appendText(monster.monsterAttack((Player) player));
            questionTimer.stopTimer();
            playerTurn = false;
        }
    }
}
