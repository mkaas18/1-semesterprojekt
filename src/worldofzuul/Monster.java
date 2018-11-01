/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author SteamyBlizzard
 */
public class Monster {
    private String name;
    private int difficulty;
    private int damage;
    
    public Monster(String name, int difficulty){
        this.name = name;
        this.difficulty = difficulty;
    }
    int getDifficulty(){
        return this.difficulty;
}
    public int getDamage(){
        int temp = this.getDifficulty();
        switch(temp){
            case 0:
                return 5;
            case 1:
                return 20;
            case 2:
                return 40;
            default:
                return -1;
        }
    }
}
