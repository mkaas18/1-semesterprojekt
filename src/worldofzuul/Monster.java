package worldofzuul;

import java.util.Scanner;

public class Monster {

    private String name;
    private int difficulty;
    private int damage;
    public String monsterName;
    public String bossName;
    private int hp;
    private String type;

    public Monster() {
        this.hp = 100;
    }
    
//Monster properties, the if statement is currently not in use till we implement the boss which has the difficulty "4"
    public Monster(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.type = type;
        if (difficulty > 3) {
            hp = 250;
        } else {
            hp = 100;
        }
        this.hp = 100;
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

    public int getHp() {
        return hp;
    }

    public void changeHp(int hp) {
        this.hp += hp;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

//Monster QuestionResults
    public void combat(QuestionResults results, Player player) {
        Scanner getAnswer = new Scanner(System.in);
        double answer;

        System.out.println(results.getQuestion());
        answer = getAnswer.nextDouble();
        if (answer == results.getAnswer()) {
            System.out.println("Correct!");//If the answer is correct, the monster is damaged for 50 Health Points
            this.changeHp(-50);

        } else {
            System.out.println("Wrong answer!");//If the answer is wrong, the player is damaged for xx(in this case 35) damage
            player.addHP(-35);
        }

    }

//Combat initiation which asks 1 of 4 question cases.
    public void combatInitiate(Question question, Player player) {
        System.out.println("A " + this.name + " approaches!");
        while (player.getHP() > 0 && this.getHp() > 0) {
            switch ((int) Math.floor(Math.random() * 4)) {
                case 0:
                    combat(question.addition(), player);
                    break;
                case 1:
                    combat(question.subtraction(), player);
                    break;
                case 2:
                    combat(question.multiplication(), player);
                    break;
                case 3:
                    combat(question.division(), player);
                    break;
            }
        }
        if (player.getHP() < 0) {
            System.out.println("Game over.");//If the player has less than 0 health the player dies
        } else {
            //Makes a monster drop an item.
            Item droppedItem = new ItemGenerator().generateItem(1);
            System.out.println("The " + this.name + " perished and dropped " + droppedItem.getName());
            
            //Makes a monster to drop a healing potion randomly.
            if ((int) Math.floor(Math.random() * 10) > 4) {
                Consumable healingPot = new Consumable(30);
                player.pickupPot(healingPot);
                System.out.println("The monster dropped a healing potion aswell!");
            }
            //Makes the player pick up the item dropped.
            player.pickupItem(droppedItem);

        }
    }
}
