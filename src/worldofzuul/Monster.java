/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

import java.util.Scanner;

/**
 *
 * @author SteamyBlizzard
 */
public class Monster {

    private String name;
    private int damage;
    private int hp;
    private String type;

    public Monster(String name, String type) {
        this.name = name;
        this.hp = 100;
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }
    
    public void changeHp(int hp){
        this.hp += hp;
    }
    
    public void combat(QuestionResults results, Player player) {
        Scanner getAnswer = new Scanner(System.in);
        double answer;
        
        System.out.println(results.getQuestion());
        answer = getAnswer.nextDouble();
        if (answer == results.getAnswer()) {
            System.out.println("The answer was correct!");
            this.changeHp(-35);
            
        } else {
            System.out.println("Wrong answer :(");
            player.addHp(-35);
        }

    }

    public void combatInitiate(Questions question, Player player) {
        System.out.println("A " + this.name + " approaches!");
        while (player.getHp()> 0 && this.getHp() > 0) {
            switch (this.getType()) {
                case "add":
                    combat(question.addition(), player);
                    break;
                case "sub":
                    combat(question.subtraction(), player);
                    break;
                case "multi":
                    combat(question.multiplication(), player);
                    break;
                case "divi":
                    combat(question.division(), player);
                    break;
            }
        }
        if(player.getHp()<0){
            System.out.println("Du døde :(");
        }else {
            System.out.println("The " + this.name + " perished");
        }
    }
}
