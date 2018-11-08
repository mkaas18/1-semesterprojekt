package worldofzuul;

import java.util.Scanner;

public class Monster {

    private String name;
    private int difficulty;
    private int damage;
    public String monsterName;
    private int hp;
    private String type;

    public Monster(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
        this.type = type;
        this.hp = 100;
    }

    public String getName() {
        return name;
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

    int getDifficulty() {
        return this.difficulty;
    }
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

        System.out.println(results.getQuestion());
        answer = getAnswer.nextDouble();
        if (answer == results.getAnswer()) {
            System.out.println("Correct!");
            this.changeHp(-100);

        } else {
            System.out.println("Wrong answer!");
            player.addHP(-35);
        }

    }

    public boolean combatInitiate(Question question, Player player) {
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
            System.out.println("You have no health left.");
            System.out.println("Game over.");
            return true;
        } else {
            Item droppedItem = new ItemGenerator().generateItem(1);
            System.out.println("The " + this.name + " perished.");
            System.out.println("The " + this.name + " dropped " + droppedItem.getName() + " and you picked it up.");
            player.pickupItem(droppedItem);
            return false;
        }
    }
}
