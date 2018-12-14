package worldofzuul.logic;

import java.util.Random;
import java.util.Scanner;
import worldofzuul.interfaces.IBoss;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Boss implements IBoss {
    
    private String name;
    private Question questions;
    private int difficulty = 4;
    private int damage;
    public String bossName;
    private final int MAX_HP;
    private int hp;
    private String type;
    private int nochange;
    
    public Boss() {
        this.hp = 300;
        this.MAX_HP = hp;
    }
    
    
    public Boss(String name, int difficulty) {
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
            case 4:
                questions = new QuestionHard();
                break;
        }
        this.type = type;
        this.hp = 300;
        this.MAX_HP = hp;
        this.damage = 50;
        this.nochange = 0;
    }
     
    @Override
    public String getBossName() {
        return name;
    }
    
    public void setBossName(String name) {
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
    

//Monster QuestionResults
    @Override
    public String answerChecker(QuestionResults results, double input, Player player) {
        QuestionTimer timer1 = new QuestionTimer(player); 
        timer1.start();
        
        if (input == results.getAnswer()) {
            changeHp((-(player.getDamage()) +(-player.getStrength())));
            player.setQuestionsCorrectAnswered(1);
            return "\nYou answered correct!\nThe boss takes " + (damage + player.getStrength())+ " damage" + "\n";
        } else {
            if(player.getAgility() == 0){player.addHp(-(damage - player.getEndurance()));
            return "\nYou answered incorrect!\nYou take damage! " + (-(damage - player.getEndurance())) + "\n";
            } else { if(new Random().nextInt(100) + (player.getAgility())
                      > 99) {
            player.addHp((nochange));
            return "\nYou answered incorret!\nRolling dice of agility --> Jackpot, you took no damage! Attack the boss again " +"\n";
                    } else {
                    player.addHp(-(damage - player.getEndurance()));
            return "\nYou answered incorrect!\nYour dice roll didn't win. You take damage! " + (-(damage - player.getEndurance())) + "\n";
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

