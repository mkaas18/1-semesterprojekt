package worldofzuul;

import java.util.Scanner;

public class Monster {
<<<<<<< HEAD
    
=======

>>>>>>> origin/Items
    private String name;
    private int difficulty;
    private int damage;
    public String monsterName;
    private int hp;
    private String type;
<<<<<<< HEAD
    
    public Monster(String name, int difficulty){
=======

    public Monster(String name, int difficulty) {
>>>>>>> origin/Items
        this.name = name;
        this.difficulty = difficulty;
        this.type = type;
        this.hp = 100;
    }

    public String getName() {
        return name;
    }
<<<<<<< HEAD
    
    
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
    
    int getDifficulty(){
        return this.difficulty;
}
=======

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

    int getDifficulty() {
        return this.difficulty;
    }
>>>>>>> origin/Items
//Level damage modifier
//    public int getDamagelvl(){
//        int temp = this.getDifficulty();
//        switch(temp){
//            case 0:
//                return 10;
//            case 1:
//                return 20;
//            case 2:
//                return 30;
//            case 4:
//                return 50;
//            default:
//                return -1;
//        }
//    }

//Monster QuestionResults
    public void combat(QuestionResults results, Player player) {
        Scanner getAnswer = new Scanner(System.in);
        double answer;
<<<<<<< HEAD
        
=======

>>>>>>> origin/Items
        System.out.println(results.getQuestion());
        answer = getAnswer.nextDouble();
        if (answer == results.getAnswer()) {
            System.out.println("Correct!");
            this.changeHp(-100);
<<<<<<< HEAD
            
        } else {
            System.out.println("Wrong answer!");
            player.addmaxHP(-35);
=======

        } else {
            System.out.println("Wrong answer!");
            System.out.println(this.name + " hit you and you lost 35 hp");
            player.addHP(-35);
>>>>>>> origin/Items
        }

    }

<<<<<<< HEAD
    public void combatInitiate(Question question, Player player) {
        System.out.println("A " + this.name + " approaches!");
        while (player.getMaxHP()> 0 && this.getHp() > 0) {
            switch ((int)Math.floor(Math.random()*4)) {
=======
    public boolean combatInitiate(Question question, Player player) {
        System.out.println("A " + this.name + " approaches!");
        while (player.getHP() > 0 && this.getHp() > 0) {
            switch ((int) Math.floor(Math.random() * 4)) {
>>>>>>> origin/Items
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
<<<<<<< HEAD
        if(player.getMaxHP()<0){
            System.out.println("Game over.");
        }else {
            System.out.println("The " + this.name + " perished.");
=======
        if (player.getHP() <= 0) {
            System.out.println("You have no health left.");
            System.out.println("Game over.");
            return true;
        } else {
            // Makes a monster drop an item.
            Item droppedItem = new ItemGenerator().generateItem(1);
            System.out.println("The " + this.name + " perished and dropped " + droppedItem.getName());

            // Makes a monster to drop a healing potion randomly.
            if ((int) Math.floor(Math.random() * 10) > 4) {
                Consumable healingPot = new Consumable(30);
                player.pickupPot(healingPot);
                System.out.println("The monster dropped a healing potion aswell!");
            }

            player.pickupItem(droppedItem);

            return false;
>>>>>>> origin/Items
        }
    }
}
