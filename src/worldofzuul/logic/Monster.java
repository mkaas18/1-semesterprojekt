package worldofzuul.logic;

import java.util.Random;
import java.util.Scanner;
import worldofzuul.interfaces.IMonster;

public class Monster implements IMonster {
    
    private String name;
    private Question questions;
    private int difficulty;
    private int damage;
    public String monsterName;
    public String bossName;
    private final int MAX_HP;
    private int hp;
    private String type;
    private int nochange;
    
    public Monster() {
        this.hp = 100;
        this.MAX_HP = hp;
    }
    
    public Monster(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        switch (difficulty) {
            case 1:
                questions = new QuestionEasy();
                break;
            case 2:
                questions = new QuestionNormal();
                break;
            case 3:
                questions = new QuestionHard();
                break;
        }
        this.type = type;
        this.hp = 100;
        this.MAX_HP = hp;
        this.damage = 35;
        this.nochange = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public String getType() {
        return type;
    }
    
    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getMAX_HP() {
        return MAX_HP;
    }
    
    public void changeHp(int hp) {
        this.hp += hp;
    }
    
    int getDifficulty() {
        return this.difficulty;
    }
    
    
    @Override
    public boolean monsterSpawnDiceroll() {
        if (new Random().nextInt(100) + 1 > 80) {
            return true;
        }
        return false;
    }

//Monster QuestionResults
    @Override
    public String answerChecker(QuestionResults results, double input, Player player) {
        if (input == results.getAnswer()) {
            changeHp((-(player.getDamage()) +(-player.getStrength())));
            player.setQuestionsCorrectAnswered(1);
            return "\nYou answered correct!\nThe monster takes " + (damage + player.getStrength())+ " damage" + "\n";
        } else {
            if(player.getAgility() == 0){player.addHp(-(damage - player.getEndurance()));
            return "\nYou answered incorrect!\nYou take damage! " + (-(damage - player.getEndurance())) + "\n";
            } else { if(new Random().nextInt(100) + (player.getAgility())
                      > 99) {
            player.addHp((nochange));
            return "\nYou answered incorret!\nRolling dice of agility --> jAckpot and you lost no hp! attack the monster again " +"\n";
                    } else {
                    player.addHp(-(damage - player.getEndurance()));
            return "\nYou answered incorrect!\nYou lost dice of agility. You take damage! " + (-(damage - player.getEndurance())) + "\n";
        }
               }     
                
                
                    }
       }
    
    
    @Override
    public QuestionResults questionPicker() {
        switch ((int) Math.floor(Math.random() * 4)) {
            case 0:
                return questions.addition();
            case 1:
                return questions.subtraction();
            case 2:
                return questions.multiplication();
            case 3:
                return questions.division();
            default:
                return questions.addition();
        }
    }
}
